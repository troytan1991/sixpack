/*
* Copyright 2018 SAIC General Motors Corporation Ltd. All Rights Reserved.
*
* This software is published under the terms of the SGM Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : itsr
*
* @File name : BusinessException.java
*
* @Author : s8xriw
*
* @Date : 2018年7月31日
*
----------------------------------------------------------------------------------
*     Date       Who       Version     Comments
* 1. 2018年7月31日    s8xriw    1.0
*
*
*
*
----------------------------------------------------------------------------------
*/

package com.troytan.sixpack.exception;

/**
 * 业务逻辑异常，状态500
 * 
 * @author s8xriw
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
