package com.ibatech.stepproject.controller.internalService;


import com.ibatech.stepproject.dao.Dao;
import com.ibatech.stepproject.dao.DaoFactory;
import com.ibatech.stepproject.dao.impl.UsersDao;
import com.ibatech.stepproject.entities.Users;
import com.ibatech.stepproject.service.ServiceFactory;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class UrlResolver {

    private HttpServletRequest request;
    private HttpServletResponse response;


    public UrlResolver(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;


    }

    public String getUrl() {
        String uid = request.getParameter("uid");
        System.out.println("uid : " + uid);
        switch (uid) {
            case "login": {
                return ServiceFactory.getService(ServiceFactory.ServiceNames.LOGIN).startProcess(request, response);
            }
            case "register": {
                return "register.jsp";
            }
            case "save": {
                return ServiceFactory.getService(ServiceFactory.ServiceNames.REGISTRATION).startProcess(request, response);
            }
            case "dislike":
            case "like": {
                return ServiceFactory.getService(ServiceFactory.ServiceNames.LIKES).startProcess(request, response);
            }
            case "people-list":
                return ServiceFactory.getService(ServiceFactory.ServiceNames.PEOPLE_LIST).startProcess(request, response);
            case "messages":
                return ServiceFactory.getService(ServiceFactory.ServiceNames.MESSAGES).startProcess(request, response);

            default: {
                return "index.jsp";
            }
        }
    }


//todo commentleri axirda sil
//    private String like() {
//        Integer index = getIndex(request, response);
//
//        addParametersToSession(request.getSession(), getLoggedUser(request, response).get(), getListOfUsers(), index);
//        return "like-page.jsp";
//    }

//    private List<Users> getListOfUsers() {
//        return (List<Users>) DaoFactory.getDao(DaoFactory.DaoNames.USERS).getAll();
//    }

//    private String doSaveService() {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        String age = request.getParameter("age");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        String imageUrl = request.getParameter("imageUrl");
//        String gender = request.getParameter("gender");
//        String jobTitle = request.getParameter("jobTitle");
//
//
//        Users users = Users
//                .builder()
//                .age(Integer.parseInt(age))
//                .email(email)
//                .gender(gender)
//                .id(0)
//                .name(name)
//                .surname(surname)
//                .password(password)
//                .imageUrl(imageUrl)
//                .jobTitle(jobTitle)
//                .build();
//
//        users = (Users) DaoFactory.getDao(DaoFactory.DaoNames.USERS).create(users);
////        request.getSession().setAttribute("users",users);
//        return openLikesPage(request, response, users);
//    }

//    private String openLikesPage(HttpServletRequest request, HttpServletResponse response, Users loggedUser) {
////        Users loggedUser = getLoggedUser(request,response).get();
//
//
//        List<Users> all = getListOfUsers();
//        List<Users> listOfUsers = all.stream().filter(users ->
//                !users.equals(loggedUser)
//        ).collect(Collectors.toList());
//
//
//        addParametersToSession(request.getSession(), loggedUser, listOfUsers, 0);
//        return "like-page.jsp";
//    }

//    private void addParametersToSession(HttpSession session, Users user, List<Users> listOfUsers, int indexToShow) {
//        session.setAttribute("listOfUsers", listOfUsers);
//        session.setAttribute("user", user);
//        session.setAttribute("likesIndex", indexToShow);
//        session.setAttribute("userToShow", listOfUsers.get(indexToShow));
//    }

//    private Optional<Users> getLoggedUser(HttpServletRequest request, HttpServletResponse response) {
//        return Optional.ofNullable((Users) request.getSession().getAttribute("user"));
//    }

//    private Integer getIndex(HttpServletRequest request, HttpServletResponse response) {
//        Integer likesIndex = (Integer) request.getSession().getAttribute("likesIndex");
//        List<Users> listOfUsers = (List<Users>) request.getSession().getAttribute("listOfUsers");
//        if (likesIndex == null || listOfUsers.size() == likesIndex) {
//            likesIndex = 0;
//        }
//
//        //todo list sayina dikket
//        return likesIndex;
//    }


//    private String doLoginService() {
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//
//        Dao<Users> dao = DaoFactory.getDao(DaoFactory.DaoNames.USERS);
//
//        Optional<Users> user = ((UsersDao) dao).getByEmailAndPassword(email, password);
//
//        return user.map(usr -> openLikesPage(request, response, user.get())).orElseGet(() -> "index.jsp");
//
//    }


}
