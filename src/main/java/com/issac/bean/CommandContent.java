package com.issac.bean;

/**
 *
 *
 * @author Issac
 *  *   @date    2018-07-01
 * @desc
 */
public class CommandContent {
    /**
    * 
    */
    private int id;
    
    /**
    * 指令id
    */
    private String commandId;

    /**
    *
    */
    private String content;

    private Command command;

    public int getId() {
        return id;
    }

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
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
}
