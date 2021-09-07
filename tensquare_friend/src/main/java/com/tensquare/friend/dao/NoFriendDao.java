package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.NoFriend;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @autor lzh
 * @date 2021/8/31 20:21
 */
/**
 * 不喜欢列表数据访问层
 */
public interface NoFriendDao extends JpaRepository<NoFriend ,String > {
}
