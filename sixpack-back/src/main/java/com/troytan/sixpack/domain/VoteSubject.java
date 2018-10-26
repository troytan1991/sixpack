package com.troytan.sixpack.domain;

import java.util.Date;

public class VoteSubject {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_vote_subject.SUBJECT_ID
     *
     * @mbg.generated
     */
    private Integer subjectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_vote_subject.TITLE
     *
     * @mbg.generated
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_vote_subject.CONTENT
     *
     * @mbg.generated
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_vote_subject.SIDE1
     *
     * @mbg.generated
     */
    private String side1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_vote_subject.SIDE2
     *
     * @mbg.generated
     */
    private String side2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_vote_subject.SIDE3
     *
     * @mbg.generated
     */
    private String side3;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_vote_subject.SIDE4
     *
     * @mbg.generated
     */
    private String side4;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_vote_subject.ANONYMOUS
     *
     * @mbg.generated
     */
    private Boolean anonymous;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_vote_subject.GROUP_ID
     *
     * @mbg.generated
     */
    private String groupId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_vote_subject.TOTAL_NUM
     *
     * @mbg.generated
     */
    private Integer totalNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_vote_subject.UNIT_PRICE
     *
     * @mbg.generated
     */
    private Integer unitPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_vote_subject.STATUS
     *
     * @mbg.generated
     */
    private Short status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_vote_subject.CREATE_BY
     *
     * @mbg.generated
     */
    private Integer createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_vote_subject.CREATE_ON
     *
     * @mbg.generated
     */
    private Date createOn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_vote_subject.UPDATE_BY
     *
     * @mbg.generated
     */
    private Integer updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_vote_subject.UPDATE_ON
     *
     * @mbg.generated
     */
    private Date updateOn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_vote_subject.FUND_POOL
     *
     * @mbg.generated
     */
    private Integer fundPool;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_vote_subject.SUBJECT_ID
     *
     * @return the value of tt_vote_subject.SUBJECT_ID
     *
     * @mbg.generated
     */
    public Integer getSubjectId() {
        return subjectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_vote_subject.SUBJECT_ID
     *
     * @param subjectId the value for tt_vote_subject.SUBJECT_ID
     *
     * @mbg.generated
     */
    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_vote_subject.TITLE
     *
     * @return the value of tt_vote_subject.TITLE
     *
     * @mbg.generated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_vote_subject.TITLE
     *
     * @param title the value for tt_vote_subject.TITLE
     *
     * @mbg.generated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_vote_subject.CONTENT
     *
     * @return the value of tt_vote_subject.CONTENT
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_vote_subject.CONTENT
     *
     * @param content the value for tt_vote_subject.CONTENT
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_vote_subject.SIDE1
     *
     * @return the value of tt_vote_subject.SIDE1
     *
     * @mbg.generated
     */
    public String getSide1() {
        return side1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_vote_subject.SIDE1
     *
     * @param side1 the value for tt_vote_subject.SIDE1
     *
     * @mbg.generated
     */
    public void setSide1(String side1) {
        this.side1 = side1 == null ? null : side1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_vote_subject.SIDE2
     *
     * @return the value of tt_vote_subject.SIDE2
     *
     * @mbg.generated
     */
    public String getSide2() {
        return side2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_vote_subject.SIDE2
     *
     * @param side2 the value for tt_vote_subject.SIDE2
     *
     * @mbg.generated
     */
    public void setSide2(String side2) {
        this.side2 = side2 == null ? null : side2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_vote_subject.SIDE3
     *
     * @return the value of tt_vote_subject.SIDE3
     *
     * @mbg.generated
     */
    public String getSide3() {
        return side3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_vote_subject.SIDE3
     *
     * @param side3 the value for tt_vote_subject.SIDE3
     *
     * @mbg.generated
     */
    public void setSide3(String side3) {
        this.side3 = side3 == null ? null : side3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_vote_subject.SIDE4
     *
     * @return the value of tt_vote_subject.SIDE4
     *
     * @mbg.generated
     */
    public String getSide4() {
        return side4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_vote_subject.SIDE4
     *
     * @param side4 the value for tt_vote_subject.SIDE4
     *
     * @mbg.generated
     */
    public void setSide4(String side4) {
        this.side4 = side4 == null ? null : side4.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_vote_subject.ANONYMOUS
     *
     * @return the value of tt_vote_subject.ANONYMOUS
     *
     * @mbg.generated
     */
    public Boolean getAnonymous() {
        return anonymous;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_vote_subject.ANONYMOUS
     *
     * @param anonymous the value for tt_vote_subject.ANONYMOUS
     *
     * @mbg.generated
     */
    public void setAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_vote_subject.GROUP_ID
     *
     * @return the value of tt_vote_subject.GROUP_ID
     *
     * @mbg.generated
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_vote_subject.GROUP_ID
     *
     * @param groupId the value for tt_vote_subject.GROUP_ID
     *
     * @mbg.generated
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_vote_subject.TOTAL_NUM
     *
     * @return the value of tt_vote_subject.TOTAL_NUM
     *
     * @mbg.generated
     */
    public Integer getTotalNum() {
        return totalNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_vote_subject.TOTAL_NUM
     *
     * @param totalNum the value for tt_vote_subject.TOTAL_NUM
     *
     * @mbg.generated
     */
    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_vote_subject.UNIT_PRICE
     *
     * @return the value of tt_vote_subject.UNIT_PRICE
     *
     * @mbg.generated
     */
    public Integer getUnitPrice() {
        return unitPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_vote_subject.UNIT_PRICE
     *
     * @param unitPrice the value for tt_vote_subject.UNIT_PRICE
     *
     * @mbg.generated
     */
    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_vote_subject.STATUS
     *
     * @return the value of tt_vote_subject.STATUS
     *
     * @mbg.generated
     */
    public Short getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_vote_subject.STATUS
     *
     * @param status the value for tt_vote_subject.STATUS
     *
     * @mbg.generated
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_vote_subject.CREATE_BY
     *
     * @return the value of tt_vote_subject.CREATE_BY
     *
     * @mbg.generated
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_vote_subject.CREATE_BY
     *
     * @param createBy the value for tt_vote_subject.CREATE_BY
     *
     * @mbg.generated
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_vote_subject.CREATE_ON
     *
     * @return the value of tt_vote_subject.CREATE_ON
     *
     * @mbg.generated
     */
    public Date getCreateOn() {
        return createOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_vote_subject.CREATE_ON
     *
     * @param createOn the value for tt_vote_subject.CREATE_ON
     *
     * @mbg.generated
     */
    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_vote_subject.UPDATE_BY
     *
     * @return the value of tt_vote_subject.UPDATE_BY
     *
     * @mbg.generated
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_vote_subject.UPDATE_BY
     *
     * @param updateBy the value for tt_vote_subject.UPDATE_BY
     *
     * @mbg.generated
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_vote_subject.UPDATE_ON
     *
     * @return the value of tt_vote_subject.UPDATE_ON
     *
     * @mbg.generated
     */
    public Date getUpdateOn() {
        return updateOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_vote_subject.UPDATE_ON
     *
     * @param updateOn the value for tt_vote_subject.UPDATE_ON
     *
     * @mbg.generated
     */
    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_vote_subject.FUND_POOL
     *
     * @return the value of tt_vote_subject.FUND_POOL
     *
     * @mbg.generated
     */
    public Integer getFundPool() {
        return fundPool;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_vote_subject.FUND_POOL
     *
     * @param fundPool the value for tt_vote_subject.FUND_POOL
     *
     * @mbg.generated
     */
    public void setFundPool(Integer fundPool) {
        this.fundPool = fundPool;
    }
}