package com.issac.service;

import com.issac.dao.MessageDao;

import java.util.ArrayList;
import java.util.List;

/**
 * 维护相关的业务功能
 *
 * @author Issac
 *  *   @date    2018-06-30
 * @desc
 */
public class MaintainService {
    /**
     * 单条删除
     *
     * @param id
     */
    public void deleteOne(String id) {
        if (id != null && !"".equals(id.trim())) {

            MessageDao messageDao = new MessageDao();
            messageDao.deletOne(Integer.valueOf(id));
        }
    }

    public void deleteBatch(String[] ids) {
        MessageDao messageDao = new MessageDao();
        List<Integer> idList = new ArrayList<>();
        for (String id :
                ids) {
            idList.add(Integer.valueOf(id));
        }

        messageDao.deleteBatch(idList);
    }
}
