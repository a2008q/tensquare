package com.tensquare.spit.service;

import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @author a2008q
 * @since 2021/9/5 18:00
 */
@Service
public class SpitService {
    @Autowired
    private SpitDao spitDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部吐槽记录
     *
     * @return
     */
    public List<Spit> findAll() {
        return spitDao.findAll();
    }

    /**
     * 根据ID查询
     *
     * @param id 吐槽Id
     * @return
     */
    public Spit findById(String id) {
        Spit spit = spitDao.findById(id).get();
        return spit;
    }

    /**
     * 添加
     *
     * @param spit 吐槽
     */
    public void add(Spit spit) {
        spit.set_id(idWorker.nextId() + "");
        spitDao.save(spit);
    }

    /**
     * 修改
     *
     * @param spit 吐槽
     */
    public void update(Spit spit) {
        spitDao.save(spit);
    }

    /**
     * 删除
     *
     * @param id 吐槽Id
     */
    public void deleteById(String id) {
        spitDao.deleteById(id);
    }
}
