<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="images/tinder.png">

    <title>Find Love</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
          integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="css/style.css">
</head>

<body style="background-color: #f5f5f5;">
<script>
    function btnFunction(value) {
        document.theForm.uid.value = value;
        document.theForm.submit();


    }
</script>

<div class="col-4 offset-4">
    <form id="myForm" name="theForm" action="/StepProject_war/Dispatcher" method="post">
        <input type="hidden" name="uid"/>
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-12 col-lg-12 col-md-12 text-center">
                        <img src="${userToShow.imageUrl}" alt="" class="mx-auto rounded-circle img-fluid">
                        <h3 class="mb-0 text-truncated">${userToShow.name} ${userToShow.surname}</h3>
                        <br>
                    </div>

                    <div class="col-12 col-lg-6">
                        <button type="button" onclick="btnFunction('dislike')" class="btn btn-outline-danger btn-block">
                            <span class="fa fa-thumbs-down"></span>
                            Dislike
                        </button>
                    </div>
                    <div class="col-12 col-lg-6">
                        <button type="button" onclick="btnFunction('like')" class="btn btn-outline-success btn-block">
                            <span class="fa fa-thumbs-up"></span> Like
                        </button>
                    </div>


                    <!--/col-->
                </div>


                <!--/row-->
            </div>
            <!--/card-block-->
        </div>


    <div>
                <button type="button" onclick="btnFunction('people-list')"  class="btn btn-outline-success btn-block">
                    <span class="fa fa-heart"></span>
                    Liked Users
                </button>
                <button type="button" onclick="btnFunction('logout')" class="btn btn-outline-danger btn-block">
                    <span class="fa fa-sign-out-alt"></span>
                    Log out
                </button>
        </div>
    </form>
    </div>
</div>
</body>
</html>