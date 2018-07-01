package com.issac.dao;

import com.issac.bean.Message;

import java.util.List;

/**
 * 与Message配置文件相对应的接口
 *
 * @author Issac
 *  *   @date    2018-07-01
 * @desc
 */
public interface IMessage {
    /**
     * 获取消息列表
     * @param message
     * @return
     */
    List<Message> queryMessageList(Message message);
}
