package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleSearchDao;
import com.tensquare.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import util.IdWorker;

@Service
public class ArticleSearchService {
    @Autowired
    private ArticleSearchDao articleSearchDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 增加文章
     *
     * @param article 文章
     */
    public void add(Article article) {
        article.setId(idWorker.nextId() + "");
        articleSearchDao.save(article);
    }

    /**
     * 搜索文章
     *
     * @param keywords 关键词
     * @param page     页码
     * @param size     大小
     * @return
     */
    public Page<Article> findByTitleLike(String keywords, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return articleSearchDao.findByTitleLikeOrContentLike(keywords, keywords, pageRequest);
    }
}
