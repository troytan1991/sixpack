package com.troytan.sixpack.constant;

/**
 * 常量池
 * 
 * @author troytan
 * @date 2018年12月27日
 */
public class BusinessConst {

    public static final short VOTE_STATUS_DELETED  = -1;// 已删除
    public static final short VOTE_STATUS_NOAUTH   = 0; // 无权限
    public static final short VOTE_STATUS_UNVOTE   = 1; // 未投票
    public static final short VOTE_STATUS_VOTED    = 5; // 已投票
    public static final short VOTE_STATUS_FINISHED = 10;// 已结束
}
