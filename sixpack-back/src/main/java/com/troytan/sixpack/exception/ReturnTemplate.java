package com.troytan.sixpack.exception;

/**
 * TODO description
 * 
 * @author troytan
 * @date 2018年7月23日
 */

public class ReturnTemplate {

    private String message;
    private Short  code;

    public Short getCode() {
        return code;
    }

    public void setCode(Short code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
