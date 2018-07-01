package com.issac.bean;

import java.util.List;

/**
 *
 *
 * @author Issac
 *  *   @date    2018-07-01
 * @desc
 */
public class Command {
    /**
    * 
    */
    private String id;

    /**
    * 指令名称
    */
    private String name;

    /**
    * 描述
    */
    private String description;


    private List<CommandContent> commandContentList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<CommandContent> getCommandContentList() {
        return commandContentList;
    }

    public void setCommandContentList(List<CommandContent> commandContentList) {
        this.commandContentList = commandContentList;
    }
}
