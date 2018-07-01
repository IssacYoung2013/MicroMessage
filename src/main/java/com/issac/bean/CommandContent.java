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
    private int commandId;

    /**
    *
    */
    private String content;

    private Command command;

    public int getId() {
        return id;
    }

    public int getCommandId() {
        return commandId;
    }

    public void setCommandId(int commandId) {
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
