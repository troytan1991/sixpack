package com.troytan.sixpack.domain;

import java.util.Date;

public class GvoteResult {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_gvote_result.GVOTE_ITEM_ID
     *
     * @mbg.generated
     */
    private Integer gvoteItemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_gvote_result.USER_ID
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_gvote_result.CREATE_ON
     *
     * @mbg.generated
     */
    private Date createOn;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_gvote_result.GVOTE_ITEM_ID
     *
     * @return the value of tr_gvote_result.GVOTE_ITEM_ID
     *
     * @mbg.generated
     */
    public Integer getGvoteItemId() {
        return gvoteItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_gvote_result.GVOTE_ITEM_ID
     *
     * @param gvoteItemId the value for tr_gvote_result.GVOTE_ITEM_ID
     *
     * @mbg.generated
     */
    public void setGvoteItemId(Integer gvoteItemId) {
        this.gvoteItemId = gvoteItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_gvote_result.USER_ID
     *
     * @return the value of tr_gvote_result.USER_ID
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_gvote_result.USER_ID
     *
     * @param userId the value for tr_gvote_result.USER_ID
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_gvote_result.CREATE_ON
     *
     * @return the value of tr_gvote_result.CREATE_ON
     *
     * @mbg.generated
     */
    public Date getCreateOn() {
        return createOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_gvote_result.CREATE_ON
     *
     * @param createOn the value for tr_gvote_result.CREATE_ON
     *
     * @mbg.generated
     */
    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }
}