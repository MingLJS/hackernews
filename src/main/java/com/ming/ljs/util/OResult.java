package com.ming.ljs.util;

/**
 * created by ZMX
 * Date 2019/4/11 Time 15:16
 */
public class OResult {
    int code;
    String msgname;
    String msgpwd;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsgname() {
        return msgname;
    }

    public void setMsgname(String msgname) {
        this.msgname = msgname;
    }

    public String getMsgpwd() {
        return msgpwd;
    }

    public void setMsgpwd(String msgpwd) {
        this.msgpwd = msgpwd;
    }

    @Override
    public String toString() {
        return "OResult{" +
                "code=" + code +
                ", msgname='" + msgname + '\'' +
                ", msgpwd='" + msgpwd + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
