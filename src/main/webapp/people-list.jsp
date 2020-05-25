<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="img/favicon.ico">

    <title>People list</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
          integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="css/style.css">
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<script>
    function btnFunction(value) {
        document.myForm.idLikes.value = value;
        document.myForm.submit();


    }
</script>

<div class="container">
    <form name="myForm" action="/StepProject_war/Dispatcher" method="post">
        <input type="hidden" name="idLikes"/>
        <input type="hidden" name="uid" value="messages"/>
        <div class="row">
            <div class="col-8 offset-2">
                <div class="panel panel-default user_panel">
                    <div class="panel-heading">
                        <h3 class="panel-title">Liked user List</h3>
                    </div>
                    <div class="panel-body">
                        <div class="table-container">
                            <table class="table-users table" border="0" id="idTable">
                                <tbody>
                                <c:forEach items="${listOfLikedUsers}" var="like">
                                    <tr id="idRow">
                                        <td width="10">
                                            <div class="avatar-img">
                                                <img class="img-circle" src="${like.idUserTo.imageUrl}"/>
                                            </div>

                                        </td>
                                        <td class="align-middle">
                                                ${like.idUserTo.fullName}
                                        </td>
                                        <td class="align-middle">
                                                ${like.idUserTo.jobTitle}
                                        </td>
                                        <td class="align-middle">
                                            Last Login: ${like.idUserTo.logging_log.logDate}<br><small class="text-muted">5 days ago</small> 
                                        </td>
                                        <td class="align-middle">
                                            <button type="submit" onclick="btnFunction(${like.idUserTo.id})"
                                                    class="btn btn-outline-success btn-block" name="id"
                                                    value="Send message">
                                            <span class="fa fa-mail-forward"></span>Chat</button>

                                        </td>
                                    </tr>
                                </c:forEach>


                                </tbody>
                            </table>
                            <div>
                                <a href="/StepProject_war/Dispatcher?uid=like-page">
                                <button type="button"  class="btn btn-outline-success btn-block">
                                    <span class="fa fa-heart"></span>
                                    Find Love
                                </button>
                                </a>
                                <a href="/StepProject_war/Dispatcher?uid=logout">
                                <button type="button"  class="btn btn-outline-danger btn-block">
                                    <span class="fa fa-sign-out-alt"></span>
                                    Log out
                                </button>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>

</body>
</html>
