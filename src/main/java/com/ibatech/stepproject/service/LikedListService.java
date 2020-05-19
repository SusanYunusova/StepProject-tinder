package com.ibatech.stepproject.service;

import com.ibatech.stepproject.dao.DaoFactory;
import com.ibatech.stepproject.entities.Likes;
import com.ibatech.stepproject.entities.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

public class LikedListService implements Service {
    @Override
    public String startProcess(HttpServletRequest request, HttpServletResponse response) {
        List<Likes> likesList = getLoggedUser(request, response).map(users ->
                users.getLikesListFrom().stream().filter(likes -> likes.getLikeStatus() == 1).collect(Collectors.toList())
        ).orElseGet(() -> null);

        request.getSession()
                .setAttribute(
                        "listOfLikedUsers",
                        likesList
                );
        return "people-list.jsp";
    }
//    private  void getLikeUsers(Users loggedUser){
////        DaoFactory.getDao(DaoFactory.DaoNames.LIKES).getAllBy()
//        loggedUser.getLikesListFrom()
//    }
}
