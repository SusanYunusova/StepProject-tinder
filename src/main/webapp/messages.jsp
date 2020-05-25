<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="img/favicon.ico">

    <title>Chat</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
          integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<script>
    function btnFunction(value) {
        document.theForm.idLikes.value = value;
        document.theForm.submit();


    }
</script>
<script>
    function btnFunctionUid(value) {
        document.theForm.uid.value = value;
        document.theForm.submit();


    }
</script>

<div class="container">
    <div class="row">
        <div class="chat-main col-6 offset-3">
            <div class="col-md-12 chat-header">
                <div class="row header-one text-white p-1">
                    <div class="col-md-6 name pl-2">
                        <i class="fa fa-comment"></i>
                        <h6 class="ml-1 mb-0">${userTo.fullName}</h6>
                    </div>
                    <div class="col-md-6 options text-right pr-0">
                        <i class="fa fa-window-minimize hide-chat-box hover text-center pt-1"></i>
                        <p class="arrow-up mb-0">
                            <i class="fa fa-arrow-up text-center pt-1"></i>
                        </p>
                        <i class="fa fa-times hover text-center pt-1" onclick="btnFunctionUid('people-list')">
<%--                            <a href="/StepProject_war/Dispatcher?uid=logout">--%>
<%--                            </a>--%>
                        </i>
                    </div>
                </div>
                <div class="row header-two w-100">
                    <div class="col-md-6 options-left pl-1">
                        <i class="fa fa-video-camera mr-3"></i>
                        <i class="fa fa-user-plus"></i>
                    </div>
                    <div class="col-md-6 options-right text-right pr-2">
                        <i class="fa fa-cog"></i>
                    </div>
                </div>
            </div>
            <div class="chat-content">


                <div class="col-md-12 chats pt-3 pl-2 pr-3 pb-3">
                    <ul class="p-0">
                        <c:forEach items="${messagesList}" var="message">

                            <c:if test="${message.idUserFrom.id==user.id}">
                                <li class="send-msg float-right mb-2">
                                    <p class="pt-1 pb-1 pl-2 pr-2 m-0 rounded">
                                            ${message.message}
                                    </p>
                                </li>
                            </c:if>

                            <c:if test="${message.idUserFrom.id!=user.id}">
                                <li class="receive-msg float-left mb-2">
                                    <div class="sender-img">
                                        <img src="${user.imageUrl}" class="float-left">
                                    </div>
                                    <div class="receive-msg-desc float-left ml-2">
                                        <p class="bg-white m-0 pt-1 pb-1 pl-2 pr-2 rounded">
                                                ${message.message}
                                        </p>
                                        <span class="receive-msg-time">${userTo.name}},${message.date}</span>
                                    </div>
                                </li>
                            </c:if>
                        </c:forEach>
                    </ul>
                </div>


                <div class="col-md-12 p-2 msg-box border border-primary">
                    <div class="row">
                        <div class="col-md-2 options-left">
                            <i class="fa fa-smile-o"></i>
                        </div>
                        <div class="col-md-7 pl-0">
                            <form name="theForm" action="/StepProject_war/Dispatcher" method="post">
                                <input type="hidden" name="idLikes"/>
                                <input type="hidden" name="uid" value="messages"/>
                            <input type="text" name="senderMessage" class="border-0"  placeholder=" Send message"/>
                            <button onclick="btnFunction('${userTo.id}')" value="send" class="fa fa-arrow-right" style="margin-top: 1px;margin-left: 410px">
                            </button>
                            </form>
                        </div>
                        <div class="col-md-3 text-right options-right">
                            <i class="fa fa-picture-o mr-2"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>