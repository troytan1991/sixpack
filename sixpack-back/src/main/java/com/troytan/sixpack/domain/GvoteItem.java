package com.troytan.sixpack.domain;

public class GvoteItem {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_gvote_item.GVOTE_ITEM_ID
     *
     * @mbg.generated
     */
    private Integer gvoteItemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_gvote_item.GVOTE_ID
     *
     * @mbg.generated
     */
    private Integer gvoteId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tt_gvote_item.CONTENT
     *
     * @mbg.generated
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_gvote_item.GVOTE_ITEM_ID
     *
     * @return the value of tt_gvote_item.GVOTE_ITEM_ID
     *
     * @mbg.generated
     */
    public Integer getGvoteItemId() {
        return gvoteItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_gvote_item.GVOTE_ITEM_ID
     *
     * @param gvoteItemId the value for tt_gvote_item.GVOTE_ITEM_ID
     *
     * @mbg.generated
     */
    public void setGvoteItemId(Integer gvoteItemId) {
        this.gvoteItemId = gvoteItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_gvote_item.GVOTE_ID
     *
     * @return the value of tt_gvote_item.GVOTE_ID
     *
     * @mbg.generated
     */
    public Integer getGvoteId() {
        return gvoteId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_gvote_item.GVOTE_ID
     *
     * @param gvoteId the value for tt_gvote_item.GVOTE_ID
     *
     * @mbg.generated
     */
    public void setGvoteId(Integer gvoteId) {
        this.gvoteId = gvoteId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tt_gvote_item.CONTENT
     *
     * @return the value of tt_gvote_item.CONTENT
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tt_gvote_item.CONTENT
     *
     * @param content the value for tt_gvote_item.CONTENT
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}