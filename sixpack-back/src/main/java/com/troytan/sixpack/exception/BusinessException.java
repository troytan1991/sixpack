package com.troytan.sixpack.exception;

/**
 * 业务逻辑异常，状态500
 * 
 * @author troytan
 * @date 2018年7月31日
 */

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 7626219528013526739L;

    public BusinessException(){
        super();
    }

    public BusinessException(String msg){
        super(msg);
    }

    public BusinessException(String msg, Throwable t){
        super(msg, t);
    }
}
