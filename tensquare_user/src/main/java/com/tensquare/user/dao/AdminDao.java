package com.tensquare.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.user.pojo.Admin;

/**
 * admin数据访问接口
 *
 * @author Administrator
 */
public interface AdminDao extends JpaRepository<Admin, String>, JpaSpecificationExecutor<Admin> {
    /**
     * 通过同户名查询用户
     *
     * @param loginname 用户名
     * @return
     */
    Admin findByLoginname(String loginname);
}
