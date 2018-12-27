package com.troytan.sixpack.dto;

import java.util.Date;

/**
 * 用户投票信息
 * 
 * @author troytan
 * @date 2018年12月26日
 */
public class UserVote {

    private String url;
    private String nickName;
    private Date   voteTime;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getVoteTime() {
        return voteTime;
    }

    public void setVoteTime(Date voteTime) {
        this.voteTime = voteTime;
    }

}
