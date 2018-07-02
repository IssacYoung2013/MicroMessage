package com.issac.dao;

import com.issac.bean.CommandContent;
import com.issac.bean.Message;
import com.issac.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * author:  ywy
 * date:  2018-07-02
 * desc:
 *
 */
public class CommandContentDao {
    /**
     * 批量新增
     * @param contentList
     */
    public void insertBatchByJdbc(List<CommandContent> contentList) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC", "root", "123");
            String insertSql = "INSERT INTO COMMAND_CONTENT(CONTENT,COMMAND_ID) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(insertSql);
            for (CommandContent content :
                    contentList) {
                statement.setString(1,content.getContent());
                statement.setString(2,content.getCommandId());
                statement.addBatch();
            }
            statement.executeBatch();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertBatch(List<CommandContent> contentList) {
        DBAccess dbAccess = new DBAccess();
        List<Message> messageList = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            // 通过sqlSession执行sQL语句
            ICommandContent iCommandContent = sqlSession.getMapper(ICommandContent.class);
            iCommandContent.insertBatch(contentList);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }

}