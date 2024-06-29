package com.hh.deepseeksdk.model;

public class ChatRequest {
    //系统消息内容 比如指定你是某某某
    private String SysTemContent;
    //用户消息内容 比如你要指定的消息内容 请帮我把xxxx翻译成xxxx
    private String UserContent;
    //模型 包括 deepseek-chat deepseek-coder
    private String model;

    public ChatRequest(String sysTemContent, String userContent, String model) {
        SysTemContent = sysTemContent;
        UserContent = userContent;
        this.model = model;
    }

    public ChatRequest() {
    }

    public String getSysTemContent() {
        return SysTemContent;
    }

    public void setSysTemContent(String sysTemContent) {
        SysTemContent = sysTemContent;
    }

    public String getUserContent() {
        return UserContent;
    }

    public void setUserContent(String userContent) {
        UserContent = userContent;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
