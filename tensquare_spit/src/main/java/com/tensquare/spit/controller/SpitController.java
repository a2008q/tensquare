package com.tensquare.spit.controller;

import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import util.IdWorker;

import javax.servlet.http.HttpServletRequest;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @author a2008q
 * @since 2021/9/5 18:06
 */
@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {
    @Autowired
    private SpitService spitService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private HttpServletRequest request;


    /**
     * 查询全部数据
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", spitService.findAll());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findOne(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", spitService.findById(id));
    }

    /**
     * 增加
     *
     * @param spit
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Spit spit) {
        Claims claims=(Claims)request.getAttribute("user_claims");
        if(claims==null){
            return new Result(false,StatusCode.ACCESSERROR,"无权访问");
        }
        spit.set_id(idWorker.nextId()+"");
        spitService.add(spit);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 修改
     *
     * @param spit
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody Spit spit, @PathVariable String id) {
        spit.set_id(id);
        spitService.update(spit);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id) {
        spitService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 根据父ID查询吐槽分页数据
     *
     * @param parentId 父ID
     * @param page     页码
     * @param size     大小
     * @return
     */
    @RequestMapping(value = "/comment/{parentId}/{page}/{size}", method = RequestMethod.GET)
    public Result findByParentId(@PathVariable String parentId,
                                 @PathVariable int page, @PathVariable int size) {
        Page<Spit> pageList = spitService.findByParentId(parentId, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Spit>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * 点赞
     *
     * @param id 吐槽Id
     * @return
     */
    @RequestMapping(value = "/thumbup/{id}", method = RequestMethod.PUT)
    public Result updateThumbup(@PathVariable String id) {
        // TODO fix userId
        String userid = "1";
        if (redisTemplate.opsForValue().get("thumbup_" + userid + "_" + id) != null) {
            return new Result(false, StatusCode.REPERROR, "您已经点过赞了");
        }
        spitService.updateThumbup(id);
        redisTemplate.opsForValue().set("thumbup_" + userid + "_" + id, "1");
        return new Result(true, StatusCode.OK, "点赞成功");
    }
}
