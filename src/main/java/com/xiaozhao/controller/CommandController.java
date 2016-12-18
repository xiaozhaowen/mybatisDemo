package com.xiaozhao.controller;

import com.alibaba.fastjson.JSON;
import com.xiaozhao.bean.Command;
import com.xiaozhao.bean.CommandContent;
import com.xiaozhao.bean.Group;
import com.xiaozhao.bean.User;
import com.xiaozhao.service.CommandService;
import org.junit.Test;

import java.util.List;

/**
 * Created by knight on 16/12/18.
 */
public class CommandController {

    @Test
    public void queryAllCommand(){
        CommandService commandService = new CommandService();
        List<Command> list = commandService.queryAllCommand();
        String jsonString = JSON.toJSONString(list);
        System.out.println(jsonString);
    }


    @Test
    public void queryAllContent(){
        CommandService commandService = new CommandService();
        List<CommandContent> list = commandService.queryAllContent();
        String jsonString = JSON.toJSONString(list);
        System.out.println(jsonString);
    }

    @Test
    public void fastJsonTest(){
        Group group = new Group();
        group.setId(0L);
        group.setName("admin");

        User guestUser = new User();
        guestUser.setId(2L);
        guestUser.setName("guest");

        User rootUser = new User();
        rootUser.setId(3L);
        rootUser.setName("root");

        group.addUser(guestUser);
        group.addUser(rootUser);

        String jsonString = JSON.toJSONString(group);

        System.out.println(jsonString);
    }


    @Test
    public void decode(){
        String jsonString ="{\"id\":0,\"name\":\"admin\",\"users\":[{\"id\":2,\"name\":\"guest\"},{\"id\":3,\"name\":\"root\"}]}";
        Group group = JSON.parseObject(jsonString, Group.class);
        System.out.println(group.getName());
    }
}
