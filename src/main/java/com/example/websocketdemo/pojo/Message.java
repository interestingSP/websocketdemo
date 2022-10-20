package com.example.websocketdemo.pojo;

public class Message {
    private String to;//给谁
    private String source;//谁发
    private Integer type;//消息 0所有人 1指定人 2视频通话 3确定进行视频通话
    private String msg;//消息内容

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "to='" + to + '\'' +
                ", source='" + source + '\'' +
                ", type=" + type +
                ", msg='" + msg + '\'' +
                '}';
    }
}
