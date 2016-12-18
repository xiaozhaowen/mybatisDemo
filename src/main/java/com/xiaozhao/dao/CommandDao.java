package com.xiaozhao.dao;

import com.xiaozhao.bean.Command;
import com.xiaozhao.bean.CommandContent;
import com.xiaozhao.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by knight on 16/12/15.
 */
public class CommandDao {
    public List<Command> queryAllCommand(){
        DBAccess dbAccess =new DBAccess();
        SqlSession sqlSession = null;
        List<Command> list = new ArrayList<Command>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list =sqlSession.selectList("Command.queryAllCommand");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
        return list;
    }


    public List<CommandContent> queryAllContent(){
        List<CommandContent> list = new ArrayList<CommandContent>();
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession= null;
        try {
            sqlSession = dbAccess.getSqlSession();
            list =sqlSession.selectList("CommandContent.queryAllContent");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
        return list;
    }
}
