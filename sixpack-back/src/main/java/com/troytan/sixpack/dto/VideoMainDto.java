package com.troytan.sixpack.dto;

/**
 * 主页video对象
 * 
 * @author troytan
 * @date 2018年10月9日
 */
public class VideoMainDto {

    private Integer videoId;
    private String  chnName;
    private String  engName;
    private Short   difficulty;
    private Short   category;
    private Integer videoRcId;
    private String  thumbnailUrl;

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getChnName() {
        return chnName;
    }

    public void setChnName(String chnName) {
        this.chnName = chnName;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public Short getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Short difficulty) {
        this.difficulty = difficulty;
    }

    public Short getCategory() {
        return category;
    }

    public void setCategory(Short category) {
        this.category = category;
    }

    public Integer getVideoRcId() {
        return videoRcId;
    }

    public void setVideoRcId(Integer videoRcId) {
        this.videoRcId = videoRcId;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

}
