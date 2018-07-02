package com.issac.homework;

import com.issac.bean.Message;

import java.util.List;

/**
 * author:  ywy
 * date:  2018-07-02
 * desc:
 */
public interface IMessage {

    List<Message> queryMessageList(Message message);
}