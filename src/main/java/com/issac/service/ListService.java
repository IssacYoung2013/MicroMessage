package com.issac.service;

import com.issac.bean.Message;
import com.issac.dao.MessageDao;

import java.util.List;

/**
 *
 * author:  ywy
 * date:  2018-06-29
 * desc:
 *
 */
public class ListService {

    public List<Message> queryMessageList(String command, String description) {
        MessageDao messageDao = new MessageDao();
        return messageDao.queryMessageList(command,description);
    }
}