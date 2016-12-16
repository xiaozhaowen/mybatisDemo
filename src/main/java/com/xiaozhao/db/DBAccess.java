package com.xiaozhao.db;

import com.xiaozhao.bean.Message;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by knight on 16/12/16.
 */
public class DBAccess {
    public SqlSession getSqlSession() throws IOException {
        //1. 通过配置文件获取数据库连接信息
        Reader reader = Resources.getResourceAsReader("Configuration.xml");

        //2. 通过配置信息构建一个SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        //3. 通过SqlSessionFactory打开一个会话
        SqlSession sqlSession = factory.openSession();
        return sqlSession;
    }

    @Test
    public  void test(){
        DBAccess dbAccess =new DBAccess();
        try {
          SqlSession sqlSession =   dbAccess.getSqlSession();
           List<Message> list = sqlSession.selectList("Message.queryMessageList");
            System.out.println("创建OK");
            System.out.println(list.size());


        } catch (IOException e) {
            System.out.println("创建失败");
            e.printStackTrace();
        }
        finally {

        }
    }
}
