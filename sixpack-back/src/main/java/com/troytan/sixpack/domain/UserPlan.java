package com.troytan.sixpack.domain;

import java.util.Date;

public class UserPlan {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_user_plan.USER_PLAN_ID
     *
     * @mbg.generated
     */
    private Integer userPlanId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_user_plan.USER_ID
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_user_plan.PLAN_ID
     *
     * @mbg.generated
     */
    private Integer planId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_user_plan.STATUS
     *
     * @mbg.generated
     */
    private Short status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_user_plan.CREATE_BY
     *
     * @mbg.generated
     */
    private Integer createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_user_plan.CREATE_ON
     *
     * @mbg.generated
     */
    private Date createOn;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_user_plan.USER_PLAN_ID
     *
     * @return the value of tt_user_plan.USER_PLAN_ID
     *
     * @mbg.generated
     */
    public Integer getUserPlanId() {
        return userPlanId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_user_plan.USER_PLAN_ID
     *
     * @param userPlanId the value for tt_user_plan.USER_PLAN_ID
     *
     * @mbg.generated
     */
    public void setUserPlanId(Integer userPlanId) {
        this.userPlanId = userPlanId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_user_plan.USER_ID
     *
     * @return the value of tt_user_plan.USER_ID
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_user_plan.USER_ID
     *
     * @param userId the value for tt_user_plan.USER_ID
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_user_plan.PLAN_ID
     *
     * @return the value of tt_user_plan.PLAN_ID
     *
     * @mbg.generated
     */
    public Integer getPlanId() {
        return planId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_user_plan.PLAN_ID
     *
     * @param planId the value for tt_user_plan.PLAN_ID
     *
     * @mbg.generated
     */
    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_user_plan.STATUS
     *
     * @return the value of tt_user_plan.STATUS
     *
     * @mbg.generated
     */
    public Short getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_user_plan.STATUS
     *
     * @param status the value for tt_user_plan.STATUS
     *
     * @mbg.generated
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_user_plan.CREATE_BY
     *
     * @return the value of tt_user_plan.CREATE_BY
     *
     * @mbg.generated
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_user_plan.CREATE_BY
     *
     * @param createBy the value for tt_user_plan.CREATE_BY
     *
     * @mbg.generated
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_user_plan.CREATE_ON
     *
     * @return the value of tt_user_plan.CREATE_ON
     *
     * @mbg.generated
     */
    public Date getCreateOn() {
        return createOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_user_plan.CREATE_ON
     *
     * @param createOn the value for tt_user_plan.CREATE_ON
     *
     * @mbg.generated
     */
    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }
}