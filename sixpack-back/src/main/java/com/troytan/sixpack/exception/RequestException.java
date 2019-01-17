package com.troytan.sixpack.exception;

/**
 * 请求异常,状态400
 * 
 * @author troytan
 * @date 2018年7月31日
 */

public class RequestException extends RuntimeException {

    private static final long serialVersionUID = 664393041374310799L;

    public RequestException(){
        super();
    }

    public RequestException(String msg){
        super(msg);
    }

    public RequestException(String msg, Throwable e){
        super(msg, e);
    }

}
