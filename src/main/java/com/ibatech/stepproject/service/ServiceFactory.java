package com.ibatech.stepproject.service;

import com.ibatech.stepproject.service.impl.*;

public class ServiceFactory {
    public  enum  ServiceNames{
        LIKES,LOGIN,SESSION,MESSAGES, PEOPLE_LIST, REGISTRATION
    }

    public static Service getService(ServiceNames serviceNames){
        switch (serviceNames){
            case LIKES: return new LikesService();
            case LOGIN: return new LoginService();
            case SESSION: return  new SessionService();
            case MESSAGES:return new MessagesService();
            case REGISTRATION:return new RegistrationService();
            case PEOPLE_LIST:return new LikedListService();
            default:return null;
        }
    }

}
