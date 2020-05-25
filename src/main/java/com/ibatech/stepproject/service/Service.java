package com.ibatech.stepproject.service;

import com.ibatech.stepproject.dao.DaoFactory;
import com.ibatech.stepproject.entities.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface Service {
    String startProcess(HttpServletRequest request, HttpServletResponse response);

    default String openLikesPage(HttpServletRequest request, HttpServletResponse response, Users loggedUser) {
        List<Users> listOfUsers = getListOfUsers(loggedUser);

        if (!listOfUsers.isEmpty()) {
            addParametersToSession(request.getSession(), loggedUser, listOfUsers, 0);
        }  return "like-page.jsp";

    }
    default Optional<Users> getLoggedUser(HttpServletRequest request, HttpServletResponse response) {
        return Optional.ofNullable((Users) request.getSession().getAttribute("user"));
    }

    default void addParametersToSession(HttpSession session, Users user, List<Users> listOfUsers, int indexToShow) {
        session.setAttribute("listOfUsers", listOfUsers);
        session.setAttribute("user", user);
        session.setAttribute("likesIndex", indexToShow);
        session.setAttribute("userToShow", listOfUsers.get(indexToShow));
    }

    default List<Users> getListOfUsers(Users loggedUser) {
        List<Users> all = (List<Users>) DaoFactory.getDao(DaoFactory.DaoNames.USERS).getAll();
        return all.stream().filter(user ->
               !user.equals(loggedUser)
        ).collect(Collectors.toList());

    }

}
