package com.ibatech.stepproject.dao;

import com.ibatech.stepproject.dao.impl.LikesDao;
import com.ibatech.stepproject.dao.impl.LoggingDao;
import com.ibatech.stepproject.dao.impl.MessagesDao;
import com.ibatech.stepproject.dao.impl.UsersDao;

public class DaoFactory {
    public  enum DaoNames{
        LIKES,LOGGING_LOG,MESSAGES,USERS
    }

    public  static Dao getDao(DaoNames daoName){
        switch (daoName){
            case LIKES: return new LikesDao();
            case LOGGING_LOG: return new LoggingDao();
            case MESSAGES: return  new MessagesDao();
            case USERS: return  new UsersDao();
            default: return null;
        }
    }
}
