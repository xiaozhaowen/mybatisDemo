package com.xiaozhao.controller;

import com.xiaozhao.bean.Message;
import com.xiaozhao.service.MessageService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by knight on 16/12/17.
 */
public class MessageController {


    @Test
    public void queryAll(){
        MessageService messageService = new MessageService();
        List<Message> list = messageService.querayAll();
        for(Message message: list){
            System.out.println(message.toString());
        }
    }



    @Test
    public void queryMessageList() {
        String paramCommand = "电影";


        MessageService messageService = new MessageService();
        List<Message> list = messageService.queryMessageList(paramCommand, "");
        System.out.println(list.size());
        for (Message row : list) {
            System.out.println(row.toString());
        }
//        return  "";
    }


    @Test
    public void deleteMessageById() {
        String deletedId = "13";
        MessageService messageService = new MessageService();
        boolean result = messageService.deleteMessageById(deletedId);
        System.out.println(result);
    }


    @Test
    public void deleteMessagesWithArray(){
        List<String> list = new ArrayList<String>();
        list.add("11");
        list.add("14");
        MessageService messageService = new MessageService();
        boolean result = messageService.deleteMessagesWithArray(list);
        System.out.println(result);
    }


    @Test
    public void addMessage(){
        String command="command",description="description",content="content";
        MessageService messageService = new MessageService();
        messageService.addMessage(command,description,content);
    }


    @Test
    public void updateMessage(){
        String id="1",description="美职篮";
        MessageService messageService = new MessageService();
        messageService.updateMessage(id,description);
    }
}
