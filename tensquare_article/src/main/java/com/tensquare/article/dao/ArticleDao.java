package com.tensquare.article.dao;

import com.tensquare.article.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * article数据访问接口
 *
 * @author Administrator
 */
public interface ArticleDao extends JpaRepository<Article, String>, JpaSpecificationExecutor<Article> {
    /**
     * 文章审核
     * Modifying删改操作只要是设计线程安全的都需要加，service层要加事务
     * ?1表示参数列表中第一个
     *
     * @param id 文章id
     */
    @Modifying
    @Query(value = "update tb_article set state =1 where id=?1", nativeQuery = true)
    void examine(String id);

    /**
     * 文章点赞
     * @param id 文章id
     * @return
     */
    @Modifying
    @Query(value = "update tb_article set thumbup = thumbup+1 where id=?1", nativeQuery = true)
    int updateThumbup(String id);
}
