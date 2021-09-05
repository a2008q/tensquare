package com.tensquare.article.dao;

import com.tensquare.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @author a2008q
 * @since 2021/9/5 22:37
 */
public interface CommentDao extends MongoRepository<Comment, String> {
    /**
     * 根据文章ID查询评论列表
     *
     * @param articleid 文章ID
     * @return
     */
    List<Comment> findByArticleid(String articleid);
}
