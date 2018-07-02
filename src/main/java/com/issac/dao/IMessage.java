package com.issac.dao;

import com.issac.bean.Message;

import java.util.List;
import java.util.Map;

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
    List<Message> queryMessageList(Map<String,Object> message);

    int count(Message message);

    /**
     * 分页获取消息列表
     * @param message
     * @return
     */
    List<Message> queryMessageListByPage(Map<String,Object> message);

}
