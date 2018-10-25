package com.troytan.sixpack.dto;

import java.util.List;

import com.troytan.sixpack.domain.User;

public class GroupResult {

    private Integer    totalAcount; // 收到总投票金额
    private List<User> users;       // 用户列表

    public Integer getTotalAcount() {
        return totalAcount;
    }

    public void setTotalAcount(Integer totalAcount) {
        this.totalAcount = totalAcount;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
