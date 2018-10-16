package com.troytan.sixpack.dto;

/**
 * 视频单独展示对象
 * 
 * @author troytan
 * @date 2018年10月9日
 */
public class VideoDetailDto {

    private Integer videoRcId;
    private String  videoUrl;
    private String  chnName;
    private String  engName;
    private String  trainMuscle;
    private String  startAction;
    private String  essenExercise;
    private String  remind;

    public Integer getVideoRcId() {
        return videoRcId;
    }

    public void setVideoRcId(Integer videoRcId) {
        this.videoRcId = videoRcId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
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

    public String getTrainMuscle() {
        return trainMuscle;
    }

    public void setTrainMuscle(String trainMuscle) {
        this.trainMuscle = trainMuscle;
    }

    public String getStartAction() {
        return startAction;
    }

    public void setStartAction(String startAction) {
        this.startAction = startAction;
    }

    public String getEssenExercise() {
        return essenExercise;
    }

    public void setEssenExercise(String essenExercise) {
        this.essenExercise = essenExercise;
    }

    public String getRemind() {
        return remind;
    }

    public void setRemind(String remind) {
        this.remind = remind;
    }

}
