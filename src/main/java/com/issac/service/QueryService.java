package com.issac.service;

import com.issac.bean.Command;
import com.issac.bean.CommandContent;
import com.issac.bean.Message;
import com.issac.dao.CommandDao;
import com.issac.dao.MessageDao;
import com.issac.entity.Page;
import com.issac.util.Iconst;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * author:  ywy
 * date:  2018-06-29
 * desc:
 */
public class QueryService {

    public List<Message> queryMessageList(String command, String description,Page page) {
        // 组织消息对象
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);

        MessageDao messageDao = new MessageDao();
        // 根据条件查询条数
        int totalNumber = messageDao.count(message);
        // 组织分页查询参数
        page.setTotalNumber(totalNumber);
        page.count();
        Map<String,Object> parameter = new HashMap<>();
        parameter.put("message",message);
        parameter.put("page",page);

        // 分页查询返回结果
        return messageDao.queryMessageList(parameter);
    }


    public List<Message> queryMessageListByPage(String command, String description,Page page) {
        // 组织消息对象
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);

        MessageDao messageDao = new MessageDao();

        Map<String,Object> parameter = new HashMap<>();
        parameter.put("message",message);
        parameter.put("page",page);

        // 分页查询返回结果
        return messageDao.queryMessageListByPage(parameter);
    }

    /**
     * 通过指令查询自动回复的内容
     *
     * @param name
     * @return
     */
    public String queryByCommand(String name) {
        CommandDao commandDao = new CommandDao();
        List<Command> commandList = null;
        if (Iconst.HELP_COMMAND.equals(name)) {
            commandList = commandDao.queryCommandList(null, null);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < commandList.size(); i++) {
                if (i != 0) {
                    result.append("<br/>");
                }
                result.append("回复[" + commandList.get(i).getName() + "]可以查看" + commandList.get(i).getDescription());
            }

            return result.toString();
        }
        commandList = commandDao.queryCommandList(name, null);

        if (commandList.size() > 0) {
            List<CommandContent> contentList = commandList.get(0).getCommandContentList();
            return contentList.get(new Random().nextInt(contentList.size())).getContent();
        }

        return Iconst.NO_MATCHING_CONTENT;
    }
}