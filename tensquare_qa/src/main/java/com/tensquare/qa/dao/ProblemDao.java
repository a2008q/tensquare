package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * problem数据访问接口
 *
 * @author Administrator
 */
public interface ProblemDao extends JpaRepository<Problem, String>, JpaSpecificationExecutor<Problem> {
    /**
     * 根据标签ID查询最新问题列表
     *
     * @param labelId  标签ID
     * @param pageable 分页对象
     * @return
     */
    @Query(value = "select * from tb_problem ,tb_pl where id=problemid and labelid =? ORDER BY replytime desc", nativeQuery = true)
    Page<Problem> newList(String labelId, Pageable pageable);

    /**
     * 热门问答
     *
     * @param labelId  标签ID
     * @param pageable 分页对象
     * @return
     */
    @Query(value = "select * from tb_problem ,tb_pl where id=problemid and labelid =? ORDER BY reply desc", nativeQuery = true)
    Page<Problem> hotList(String labelId, Pageable pageable);

    /**
     * 根据标签ID查询等待回答列表
     *
     * @param labelId  标签ID
     * @param pageable 分页对象
     * @return
     */
    @Query(value = "select * from tb_problem ,tb_pl where id=problemid and labelid =? AND reply=0  ORDER BY createtime desc", nativeQuery = true)
    Page<Problem> waitList(String labelId, Pageable pageable);
}
