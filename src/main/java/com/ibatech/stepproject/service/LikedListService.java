package com.ibatech.stepproject.service;

import com.ibatech.stepproject.dao.DaoFactory;
import com.ibatech.stepproject.entities.Likes;
import com.ibatech.stepproject.entities.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LikedListService implements Service {
    @Override
    public String startProcess(HttpServletRequest request, HttpServletResponse response) {
        Optional<Users> loggedUser = getLoggedUser(request, response);
        System.out.println("loggedUser list size: " + loggedUser.get().getLikesListFrom().size());
        Optional<Users> user = loggedUser.map(users ->
                (Users) DaoFactory.getDao(DaoFactory.DaoNames.USERS)
                        .getById(users.getId()).get());
        System.out.println("user list size: " + user.get().getLikesListFrom().size());
        List<Likes> likedListByQuery = DaoFactory.getDao(DaoFactory.DaoNames.LIKES).getEMCreator()
                .getEntityManager().createNamedQuery("Likes.findByLikeStatusAndIdUserFrom", Likes.class)
                .setParameter("idUserFrom", loggedUser.get()).getResultList();

        List<Likes> likesList = user.map(users ->
                users.getLikesListFrom().stream().filter(likes -> likes.getLikeStatus() == 1).collect(Collectors.toList())
        ).orElseGet(() -> null);
        likesList.forEach(likes -> System.out.println("idUserTo: " + likes.getIdUserTo().getId()));
        request.getSession()
                .setAttribute(
                        "user",
                        user.get()
                );
        request.getSession()
                .setAttribute(
                        "listOfLikedUsers",
                        likedListByQuery
                );
        return "people-list.jsp";
    }
}
