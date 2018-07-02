package com.issac.homework;

import com.issac.bean.Message;

/**
 *
 * author:  ywy
 * date:  2018-07-02
 * desc:
 *
 */
public class MyMain {
    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession();
        IMessage iMessage = sqlSession.getMapper(IMessage.class);
        iMessage.queryMessageList(new Message());
    }
}