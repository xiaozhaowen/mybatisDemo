package com.xiaozhao.dao;

import com.xiaozhao.bean.Message;
import com.xiaozhao.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by knight on 16/12/16.
 */
public class MessageDao {


    public List<Message> queryAll(){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession =null;
        List<Message> list = new ArrayList<Message>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Message.queryAll");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
        return  list;
    }

    public List<Message> queryMessageList(String command, String content) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        List<Message> list = new ArrayList<Message>();
        try {
            Message paramMessage = new Message();
            paramMessage.setCommand(command);
            paramMessage.setContent(content);
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Message.queryMessageList", paramMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
        return list;
    }


    public boolean deleteMessageById(int id) {
        DBAccess dbAccess = new DBAccess();
        boolean isSuccess = false;
        SqlSession sqlSession = null;

        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.delete("Message.deleteMessageById", id);
            sqlSession.commit();
            isSuccess = true;
        } catch (IOException e) {
            e.printStackTrace();
            isSuccess = false;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return isSuccess;
    }

    public boolean deleteMessagesWithArray(List<Integer> list) {
        boolean isSuccess = false;
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession =  dbAccess.getSqlSession();
            isSuccess = true;
            sqlSession.delete("Message.deleteMessagesWithArray",list);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
            isSuccess = false;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return isSuccess;
    }

    public void addMessage(Message newMessage){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.insert("Message.addMessage",newMessage);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    public void updateMessage(Message message){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession =null;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.update("Message.updateMessage",message);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }


}
