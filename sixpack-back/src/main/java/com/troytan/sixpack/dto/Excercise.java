package com.troytan.sixpack.dto;

/**
 * 训练计划练习对象
 * 
 * @author troytan
 * @date 2018年12月6日
 */
public class Excercise {

    private Integer videoId;
    private String  chnName;
    private Short   repetitions;
    private Short   sets;
    private String  thumbUrl;
    private String  videoUrl;

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

    public Short getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Short repetitions) {
        this.repetitions = repetitions;
    }

    public Short getSets() {
        return sets;
    }

    public void setSets(Short sets) {
        this.sets = sets;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

}
