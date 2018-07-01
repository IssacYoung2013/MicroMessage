package com.issac.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 *
 *
 * @author Issac
 *  *   @date    2018-06-30
 * @desc 访问数据库
 */
public class DBAccess {

    public SqlSession getSqlSession() throws IOException{
        // 通过配置文件获取数据库连接信息
        Reader reader = Resources.getResourceAsReader("com/issac/config/Configuration.xml");
        // 通过配置信息构建一个SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 通过sqlSessionFactory 打开一个数据库会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        return sqlSession;
    }
}
