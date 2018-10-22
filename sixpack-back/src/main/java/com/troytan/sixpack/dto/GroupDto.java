package com.troytan.sixpack.dto;

public class GroupDto {

    private String  encryptedData; // group加密数据
    private String  iv;            // 初始向量
    private Integer subjectId;     // 主题ID

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

}
