package com.issac.dao;

import com.issac.bean.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * author:  ywy
 * date:  2018-06-29
 * desc:
 */
public class MessageDao {

    public List<Message> queryMessageList(String command, String description) {

        List<Message> messageList = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC", "root", "123");

            StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from MESSAGE where 1 = 1");

            List<String> paramList = new ArrayList<>();

            if (command != null && !"".equals(command.trim())) {
                sql.append(" and COMMAND = ?");
                paramList.add(command);
            }

            if (description != null && !"".equals(description.trim())) {
                sql.append(" and DESCRIPTION like %'?'%");
                paramList.add(description);
            }

            PreparedStatement statement = conn.prepareStatement(sql.toString());
            for (int i = 0; i < paramList.size(); i++) {
                statement.setString(i + 1, paramList.get(i));
            }
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Message message = new Message();
                messageList.add(message);

                message.setId(rs.getString("ID"));
                message.setCommand(rs.getString("COMMAND"));
                message.setContent(rs.getString("CONTENT"));
                message.setDescription(rs.getString("DESCRIPTION"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return messageList;
    }
}