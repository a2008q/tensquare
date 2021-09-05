package com.tensquare.article.service;

import com.tensquare.article.dao.CommentDao;
import com.tensquare.article.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @author a2008q
 * @since 2021/9/5 22:38
 */
@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 增加评论
     *
     * @param comment 评论
     */
    public void add(Comment comment) {
        comment.set_id(idWorker.nextId() + "");
        commentDao.save(comment);
    }

    /**
     * 根据文章Id查询评论
     *
     * @param articleid 文章Id
     * @return
     */
    public List<Comment> findByArticleid(String articleid) {
        return commentDao.findByArticleid(articleid);
    }

    /**
     * 通过评论Id删除评论
     * @param id 评论Id
     */
    public void deleteById(String id) {
        commentDao.deleteById(id);
    }
}
