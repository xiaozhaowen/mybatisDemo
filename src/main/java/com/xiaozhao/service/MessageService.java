package com.xiaozhao.service;

import com.xiaozhao.bean.Message;
import com.xiaozhao.dao.MessageDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by knight on 16/12/16.
 */
public class MessageService {


    public List<Message> querayAll() {
        MessageDao messageDao = new MessageDao();
        return messageDao.queryAll();
    }

    public List<Message> queryMessageList(String command, String content) {
        MessageDao messageDao = new MessageDao();
        return messageDao.queryMessageList(command, content);
    }


    public boolean deleteMessageById(String id) {
        MessageDao messageDao = new MessageDao();
        return messageDao.deleteMessageById(Integer.valueOf(id));
    }

    public boolean deleteMessagesWithArray(List<String> ids) {
        MessageDao messageDao = new MessageDao();
        List<Integer> list = new ArrayList<Integer>();
        for (String id : ids) {
            list.add(Integer.valueOf(id));
        }
        return messageDao.deleteMessagesWithArray(list);
    }

    public void addMessage(String command, String description, String content) {
        Message message = new Message();
        message.setCommand(command);
        message.setDesciption(description);
        message.setContent(content);

        MessageDao messageDao = new MessageDao();
        messageDao.addMessage(message);
    }

    public void updateMessage(String id,String description){
        MessageDao messageDao = new MessageDao();
        Message modifiedMessage = new Message();
        modifiedMessage.setId(Integer.valueOf(id));
        modifiedMessage.setDesciption(description);
        messageDao.updateMessage(modifiedMessage);
    }
}
