package com.troytan.sixpack.exception;

/**
 * 请求异常,状态400
 * 
 * @author troytan
 * @date 2018年7月31日
 */

public class UnauthException extends RuntimeException {

    private static final long serialVersionUID = 664393041374310799L;

    public UnauthException(){
        super();
    }

    public UnauthException(String msg){
        super(msg);
    }

    public UnauthException(String msg, Throwable e){
        super(msg, e);
    }

}
