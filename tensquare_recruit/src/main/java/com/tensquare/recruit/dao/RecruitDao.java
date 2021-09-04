package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * recruit数据访问接口
 *
 * @author Administrator
 */
public interface RecruitDao extends JpaRepository<Recruit, String>, JpaSpecificationExecutor<Recruit> {
    /**
     * 查询推荐职位列表(按创建日期降序排序)
     *
     * @return
     */
    List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state);

    /**
     * 最新职位列表
     *
     * @param state
     * @return
     */
    List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String state);
}
