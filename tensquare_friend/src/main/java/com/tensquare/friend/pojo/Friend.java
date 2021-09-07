package com.tensquare.friend.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @autor lzh
 * @date 2021/8/31 17:42
 */
@Entity
@Table(name="tb_friend")
@IdClass(Friend.class)
public class Friend implements Serializable {
    @Id
    private String userid;
    @Id
    private String friendid;

    private String islike;
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getFriendid() {
        return friendid;
    }
    public void setFriendid(String friendid) {
        this.friendid = friendid;
    }

    public String getIslike() {
        return islike;
    }

    public void setIslike(String islike) {
        this.islike = islike;
    }
}
