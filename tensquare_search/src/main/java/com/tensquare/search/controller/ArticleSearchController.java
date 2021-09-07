package com.tensquare.search.controller;

import com.tensquare.search.pojo.Article;
import com.tensquare.search.service.ArticleSearchService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleSearchController {

    @Autowired
    private ArticleSearchService articleSearchService;
    @Autowired
    private HttpServletRequest request;

    /**
     * 添加文章
     *
     * @param article 文章
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article) {
        Claims claims = (Claims) request.getAttribute("user_claims");
        if (claims == null) {
            return new Result(false, StatusCode.ACCESSERROR, "无权访问");
        }
        articleSearchService.add(article);
        return new Result(true, StatusCode.OK, "操作成功");
    }

    /**
     * 搜索文章
     *
     * @param keywords 关键词
     * @param page     页码
     * @param size     大小
     * @return
     */
    @RequestMapping(value = "/search/{keywords}/{page}/{size}", method = RequestMethod.GET)
    public Result findByTitleLike(@PathVariable String keywords, @PathVariable int page, @PathVariable int size) {
        Page<Article> articles = articleSearchService.findByTitleLike(keywords, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Article>(articles.getTotalElements(), articles.getContent()));
    }
}
