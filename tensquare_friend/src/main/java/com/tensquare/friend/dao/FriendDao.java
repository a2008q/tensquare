package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @autor lzh
 * @date 2021/8/31 17:44
 */
public interface FriendDao extends JpaRepository<Friend,String > {

    @Query(value = "select count(*) from tb_friend where userid = ? and friendid= ?",nativeQuery = true)
    public int selectCount(String userid,String friend);

    @Modifying
    @Query(value = "update tb_friend set islike=?1 where userid=?2 and friendid=?3",nativeQuery = true)
    public void updateLike(String islike,String userid,String friend);
    /**
     * 删除好友
     */
    @Modifying
    @Query(value = "delete from tb_friend where userid = ?1 and friendid =?2 ",nativeQuery = true)
    public void deleteFriend(String userid,String friendid);
}
