package com.troytan.sixpack.dto;

import java.util.List;

import com.troytan.sixpack.domain.User;

/**
 * 实名投票结果
 * 
 * @author troytan
 * @date 2018年10月22日
 */
public class RealVoteResult {

    private Short      value;
    private List<User> users;

    public Short getValue() {
        return value;
    }

    public void setValue(Short value) {
        this.value = value;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
