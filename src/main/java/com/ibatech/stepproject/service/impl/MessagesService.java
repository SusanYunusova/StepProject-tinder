package com.ibatech.stepproject.service.impl;

import com.ibatech.stepproject.dao.Dao;
import com.ibatech.stepproject.dao.DaoFactory;
import com.ibatech.stepproject.dao.impl.MessagesDao;
import com.ibatech.stepproject.entities.Messages;
import com.ibatech.stepproject.entities.Users;
import com.ibatech.stepproject.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class MessagesService implements Service {
    @Override
    public String startProcess(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("idLike: " + request.getParameter("idLikes"));
        int idUserTo = Integer.parseInt(request.getParameter("idLikes"));
        Optional<Users> loggedUser = getLoggedUser(request, response);
        Users userTo = (Users)DaoFactory.getDao(DaoFactory.DaoNames.USERS).getById(idUserTo).get();
        String message= request.getParameter("senderMessage");
        MessagesDao dao = (MessagesDao) DaoFactory.getDao(DaoFactory.DaoNames.MESSAGES);
        if (message!=null){
            System.out.println("bura gelir message creator hissesi");
            dao.create(Messages
                        .builder()
                        .idUserFrom(loggedUser.get())
                    .idUserTo(userTo)
                    .message(message)
                    .date(new Date())
                    .build()
                    );

        }
        List<Messages> messagesList = dao
                .getUserMessages
                        (
                                loggedUser.get(),
                                userTo
                        );
        request.getSession().setAttribute("userTo",userTo);
        request.getSession().setAttribute("messagesList", messagesList);
        return "messages.jsp";
    }

}
