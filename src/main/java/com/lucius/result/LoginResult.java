package com.lucius.result;

import lombok.Data;

/**
 * @author : gaolu email-->g956509785@163.com
 * @Date :  2020-07-29
 **/
@Data
public class LoginResult {
    private int code;
    private String msg;
    private Object object;
    public LoginResult(){}

    public LoginResult(int code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
    }
}
