package com.troytan.sixpack.domain;

import java.util.Date;

public class GroupUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_group_user.GROUP_USER_ID
     *
     * @mbg.generated
     */
    private Integer groupUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_group_user.GROUP_ID
     *
     * @mbg.generated
     */
    private String groupId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_group_user.OPEN_ID
     *
     * @mbg.generated
     */
    private String openId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_group_user.CREATE_BY
     *
     * @mbg.generated
     */
    private Integer createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_group_user.CREATE_ON
     *
     * @mbg.generated
     */
    private Date createOn;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_group_user.GROUP_USER_ID
     *
     * @return the value of tt_group_user.GROUP_USER_ID
     *
     * @mbg.generated
     */
    public Integer getGroupUserId() {
        return groupUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_group_user.GROUP_USER_ID
     *
     * @param groupUserId the value for tt_group_user.GROUP_USER_ID
     *
     * @mbg.generated
     */
    public void setGroupUserId(Integer groupUserId) {
        this.groupUserId = groupUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_group_user.GROUP_ID
     *
     * @return the value of tt_group_user.GROUP_ID
     *
     * @mbg.generated
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_group_user.GROUP_ID
     *
     * @param groupId the value for tt_group_user.GROUP_ID
     *
     * @mbg.generated
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_group_user.OPEN_ID
     *
     * @return the value of tt_group_user.OPEN_ID
     *
     * @mbg.generated
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_group_user.OPEN_ID
     *
     * @param openId the value for tt_group_user.OPEN_ID
     *
     * @mbg.generated
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_group_user.CREATE_BY
     *
     * @return the value of tt_group_user.CREATE_BY
     *
     * @mbg.generated
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_group_user.CREATE_BY
     *
     * @param createBy the value for tt_group_user.CREATE_BY
     *
     * @mbg.generated
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_group_user.CREATE_ON
     *
     * @return the value of tt_group_user.CREATE_ON
     *
     * @mbg.generated
     */
    public Date getCreateOn() {
        return createOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_group_user.CREATE_ON
     *
     * @param createOn the value for tt_group_user.CREATE_ON
     *
     * @mbg.generated
     */
    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }
}