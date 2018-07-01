package com.issac.dao;

import com.issac.bean.Message;
import com.issac.db.DBAccess;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Condition;

/**
 * author:  ywy
 * date:  2018-06-29
 * desc:
 */
public class MessageDao {

    public List<Message> queryMessageList(String command, String description) {
        DBAccess dbAccess = new DBAccess();
        List<Message> messageList = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Message message = new Message();
            message.setCommand(command);
            message.setDescription(description);
            // 通过sqlSession执行sQL语句
//            messageList = sqlSession.selectList("Message.queryMessageList",message);
            IMessage imessage = sqlSession.getMapper(IMessage.class);
            messageList = imessage.queryMessageList(message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

        return messageList;
    }

    public void deletOne(int id) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            // 通过sqlSession执行sQL语句
            sqlSession.delete("Message.deleteOne",id);
            sqlSession.commit();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteBatch(List<Integer> ids) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            // 通过sqlSession执行sQL语句
            sqlSession.delete("Message.deleteBatch",ids);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

//    public List<Message> queryMessageList(String command, String description) {
//
//        List<Message> messageList = new ArrayList<>();
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC", "root", "123");
//
//            StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from MESSAGE where 1 = 1");
//
//            List<String> paramList = new ArrayList<>();
//
//            if (command != null && !"".equals(command.trim())) {
//                sql.append(" and COMMAND = ?");
//                paramList.add(command);
//            }
//
//            if (description != null && !"".equals(description.trim())) {
//                sql.append(" and DESCRIPTION like %'?'%");
//                paramList.add(description);
//            }
//
//            PreparedStatement statement = conn.prepareStatement(sql.toString());
//            for (int i = 0; i < paramList.size(); i++) {
//                statement.setString(i + 1, paramList.get(i));
//            }
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                Message message = new Message();
//                messageList.add(message);
//
//                message.setId(rs.getString("ID"));
//                message.setCommand(rs.getString("COMMAND"));
//                message.setContent(rs.getString("CONTENT"));
//                message.setDescription(rs.getString("DESCRIPTION"));
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return messageList;
//    }

    public static void main(String[] args) {
        MessageDao messageDao = new MessageDao();
        messageDao.queryMessageList("", "");
        Map<String,Message> messageMap = new HashMap<>();
        messageMap.put("key",new Message());
//        Logger log ;
//        log.debug("adf");
//        log.info("asioasd");
//        log.warn("");
//        log.error("");

    }
}