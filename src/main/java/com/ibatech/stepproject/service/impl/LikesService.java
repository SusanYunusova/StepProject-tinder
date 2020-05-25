package com.ibatech.stepproject.service.impl;

import com.ibatech.stepproject.dao.DaoFactory;
import com.ibatech.stepproject.entities.Likes;
import com.ibatech.stepproject.entities.Users;
import com.ibatech.stepproject.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class LikesService implements Service {
    @Override
    public String startProcess(HttpServletRequest request, HttpServletResponse response) {

        return like(request, response);
    }

    private String like(HttpServletRequest request, HttpServletResponse response) {
        Integer index = getIndex(request, response);
        String uid = request.getParameter("uid");
        if (uid.equals("like")) {
            addLikeProcess(request, 1);
        } else {
            addLikeProcess(request, 0);
        }

        addParametersToSession(request.getSession(), getLoggedUser(request, response).get(), getListOfUsers(getLoggedUser(request, response).get()), index);
        return "like-page.jsp";
    }

    private void addLikeProcess(HttpServletRequest request, Integer likeStatus) {
        Users likedUser = (Users) request.getSession().getAttribute("userToShow");
        Optional<Users> loggedUser = getLoggedUser(request, null);
        Likes likes;
        try {

       likes = DaoFactory
                .getDao(DaoFactory.DaoNames.LIKES)
                .getEMCreator()
                .getEntityManager()
                .createNamedQuery("Likes.findByLikesFromTo", Likes.class)
                .setParameter("userFrom", loggedUser.get())
                .setParameter("userTo", likedUser)
                .getSingleResult();
        }catch (Exception e){
            System.out.println("error likes addlikeProcess");
            likes=null;
        }
        if (likes == null) {

            likes = Likes
                    .builder()
                    .idLikes(0)
                    .idUserFrom(getLoggedUser(request, null).get())
                    .idUserTo(likedUser)
                    .likeStatus(likeStatus)
                    .date(new Date())
                    .build();
        }else {
            likes.setLikeStatus(likeStatus);
            likes.setDate(new Date());
        }

        DaoFactory.getDao(DaoFactory.DaoNames.LIKES).create(likes);

    }

    private Integer getIndex(HttpServletRequest request, HttpServletResponse response) {
        Integer likesIndex = (Integer) request.getSession().getAttribute("likesIndex");
        if (likesIndex != null) {
            likesIndex++;
            List<Users> listOfUsers = (List<Users>) request.getSession().getAttribute("listOfUsers");
            if (listOfUsers.size() == likesIndex) {
                likesIndex = 0;
            }
        } else {
            likesIndex = 0;
        }

        //todo list sayina dikket
        return likesIndex;
    }

}
