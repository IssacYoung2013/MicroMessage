package com.issac.dao;

import com.issac.bean.Command;
import com.issac.bean.Message;
import com.issac.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Issac
 *  *   @date    2018-07-01
 * @desc
 */
public class CommandDao {

    /**
     * 根据查询条件获取指令列表
     * @param name
     * @param description
     * @return
     */
    public List<Command> queryCommandList(String name, String description) {
        DBAccess dbAccess = new DBAccess();
        List<Command> commandList = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Command message = new Command();
            message.setName(name);
            message.setDescription(description);
            // 通过sqlSession执行sQL语句
            commandList = sqlSession.selectList("Command.queryCommandList",message);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

        return commandList;
    }
}
