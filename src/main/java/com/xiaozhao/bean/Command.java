package com.xiaozhao.bean;

import java.util.List;

/**
 * Created by knight on 16/12/18.
 */
public class Command {
    private int id;
    private String  name;
    private String description;
    private List<CommandContent> contentList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", contentList=" + contentList +
                '}';
    }

    public List<CommandContent> getContentList() {
        return contentList;
    }

    public void setContentList(List<CommandContent> contentList) {
        this.contentList = contentList;
    }
}
