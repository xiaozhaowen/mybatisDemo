package com.xiaozhao.bean;

/**
 * Created by knight on 16/12/18.
 */
public class CommandContent {
    private int id;
    private String content;
    private int commandId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommandId() {
        return commandId;
    }

    public void setCommandId(int commandId) {
        this.commandId = commandId;
    }

    @Override
    public String toString() {
        return "CommandContent{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", commandId=" + commandId +
                '}';
    }
}
