package com.troytan.sixpack.domain;

import java.util.Date;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.USER_ID
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.OPEN_ID
     *
     * @mbg.generated
     */
    private String openId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.AVATAR_URL
     *
     * @mbg.generated
     */
    private String avatarUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.NICKNAME
     *
     * @mbg.generated
     */
    private String nickname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.PROVINCE
     *
     * @mbg.generated
     */
    private String province;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.GENDER
     *
     * @mbg.generated
     */
    private Short gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.PREFER
     *
     * @mbg.generated
     */
    private Short prefer;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.CREATE_BY
     *
     * @mbg.generated
     */
    private Integer createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.CREATE_ON
     *
     * @mbg.generated
     */
    private Date createOn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.UPDATE_BY
     *
     * @mbg.generated
     */
    private Integer updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.UPDATE_ON
     *
     * @mbg.generated
     */
    private Date updateOn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.VOTE_WEIGHT
     *
     * @mbg.generated
     */
    private Short voteWeight;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.USER_ID
     *
     * @return the value of tm_user.USER_ID
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.USER_ID
     *
     * @param userId the value for tm_user.USER_ID
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.OPEN_ID
     *
     * @return the value of tm_user.OPEN_ID
     *
     * @mbg.generated
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.OPEN_ID
     *
     * @param openId the value for tm_user.OPEN_ID
     *
     * @mbg.generated
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.AVATAR_URL
     *
     * @return the value of tm_user.AVATAR_URL
     *
     * @mbg.generated
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.AVATAR_URL
     *
     * @param avatarUrl the value for tm_user.AVATAR_URL
     *
     * @mbg.generated
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.NICKNAME
     *
     * @return the value of tm_user.NICKNAME
     *
     * @mbg.generated
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.NICKNAME
     *
     * @param nickname the value for tm_user.NICKNAME
     *
     * @mbg.generated
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.PROVINCE
     *
     * @return the value of tm_user.PROVINCE
     *
     * @mbg.generated
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.PROVINCE
     *
     * @param province the value for tm_user.PROVINCE
     *
     * @mbg.generated
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.GENDER
     *
     * @return the value of tm_user.GENDER
     *
     * @mbg.generated
     */
    public Short getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.GENDER
     *
     * @param gender the value for tm_user.GENDER
     *
     * @mbg.generated
     */
    public void setGender(Short gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.PREFER
     *
     * @return the value of tm_user.PREFER
     *
     * @mbg.generated
     */
    public Short getPrefer() {
        return prefer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.PREFER
     *
     * @param prefer the value for tm_user.PREFER
     *
     * @mbg.generated
     */
    public void setPrefer(Short prefer) {
        this.prefer = prefer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.CREATE_BY
     *
     * @return the value of tm_user.CREATE_BY
     *
     * @mbg.generated
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.CREATE_BY
     *
     * @param createBy the value for tm_user.CREATE_BY
     *
     * @mbg.generated
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.CREATE_ON
     *
     * @return the value of tm_user.CREATE_ON
     *
     * @mbg.generated
     */
    public Date getCreateOn() {
        return createOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.CREATE_ON
     *
     * @param createOn the value for tm_user.CREATE_ON
     *
     * @mbg.generated
     */
    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.UPDATE_BY
     *
     * @return the value of tm_user.UPDATE_BY
     *
     * @mbg.generated
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.UPDATE_BY
     *
     * @param updateBy the value for tm_user.UPDATE_BY
     *
     * @mbg.generated
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.UPDATE_ON
     *
     * @return the value of tm_user.UPDATE_ON
     *
     * @mbg.generated
     */
    public Date getUpdateOn() {
        return updateOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.UPDATE_ON
     *
     * @param updateOn the value for tm_user.UPDATE_ON
     *
     * @mbg.generated
     */
    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.VOTE_WEIGHT
     *
     * @return the value of tm_user.VOTE_WEIGHT
     *
     * @mbg.generated
     */
    public Short getVoteWeight() {
        return voteWeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.VOTE_WEIGHT
     *
     * @param voteWeight the value for tm_user.VOTE_WEIGHT
     *
     * @mbg.generated
     */
    public void setVoteWeight(Short voteWeight) {
        this.voteWeight = voteWeight;
    }
}