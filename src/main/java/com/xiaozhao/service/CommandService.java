package com.xiaozhao.service;

import com.xiaozhao.bean.Command;
import com.xiaozhao.bean.CommandContent;
import com.xiaozhao.dao.CommandDao;

import java.util.List;

/**
 * Created by knight on 16/12/18.
 */
public class CommandService {
    public List<Command> queryAllCommand(){
        CommandDao commandDao = new CommandDao();
        return commandDao.queryAllCommand();
    }

    public List<CommandContent> queryAllContent(){
        CommandDao commandDao = new CommandDao();
        return  commandDao.queryAllContent();
    }
}
