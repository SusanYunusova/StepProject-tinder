<%--<!doctype html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>
<%--    <meta name="description" content="">--%>
<%--    <meta name="author" content="">--%>
<%--&lt;%&ndash;    <link rel="icon" href="img/favicon.ico">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <link rel="icon"  href="/images/tinder.png"  size="50"/>&ndash;%&gt;--%>
<%--    <link rel="icon" href="images/tinder.png">--%>

<%--    <title>Tinder-Login</title>--%>

<%--    <!-- Bootstrap core CSS -->--%>
<%--    <link type="text/css" href="css/bootstrap.min.css" rel="stylesheet">--%>

<%--    <!-- Custom styles for this template -->--%>
<%--    <link rel="stylesheet" href="css/style.css">--%>
<%--</head>--%>

<%--<body class="text-center">--%>
<%--<form class="form-signin" method="post" action="Dispatcher">--%>
<%--    <div class="login100-more" style="background-image: url('images/bg-01.jpg');size: auto">--%>
<%--    </div>--%>
<%--    <img class="mb-4" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">--%>
<%--    <img src="/images/tinder.png" alt="" width="96" height="51">--%>
<%--    <h1 class="h3 mb-3 font-weight-normal" style="color: deeppink">Wanna find love?</h1>--%>
<%--    <label for="inputEmail" class="sr-only" style="margin-top: 20px">Email address</label>--%>
<%--    <input  name="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>--%>
<%--    <label for="inputPassword" class="sr-only" style="margin-top: 10px">Password</label>--%>
<%--    <input name="password" type="password" id="inputPassword" style="margin-top: 10px" class="form-control" placeholder="Password" required>--%>
<%--    <button class="btn btn-lg btn-primary btn-block" style="background-color: deeppink" type="submit">Sign in</button>--%>

<%--    <a href="/StepProject_war/Dispatcher?uid=register">--%>
<%--        <button class="btn btn-lg btn-primary btn-block"--%>
<%--                style="margin-top: 30px;margin-bottom: 100px;background-color: hotpink"--%>
<%--                type="button">Sign up</button>--%>
<%--        </a>--%>
<%--    <p class="mt-5 mb-3 text-muted">&copy; Tinder 2020</p>--%>
<%--    <input type="hidden" name="uid" value="login"/>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>







<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!--===============================================================================================-->
</head>
<body style="background-color: #666666;">
<script>
    function btnFunction(value) {
        document.theForm.uid.value = value;
        document.theForm.submit();


    }
</script>
<div class="limiter">
    <div class="container-login100">
        <%--<form class="form-signin" method="post" action="Dispatcher">--%>

        <div class="wrap-login100">
            <form class="login100-form validate-form" method="post" action="/StepProject_war/Dispatcher">
					<span class="login100-form-title p-b-43">
						Login to continue
					</span>


                <div class="wrap-input100 validate-input" data-validate="Valid email is required: ex@abc.xyz">
                    <input class="input100" type="text" name="email"/>
                    <span class="focus-input100"></span>
                    <span class="label-input100">Email</span>
                </div>


                <div class="wrap-input100 validate-input" data-validate="Password is required">
                    <input class="input100" type="password" name="password"/>
                    <span class="focus-input100"></span>
                    <span class="label-input100">Password</span>
                </div>


                <div class="container-login100-form-btn">
                    <button class="login100-form-btn" type="submit">
                        Login
                    </button>
                <input type="hidden" name="uid" value="login"/>
                </div>
                <div class="container-login100-form-btn" style="margin-top: 10px">
                    <a href="/StepProject_war/Dispatcher?uid=register">
                        <button class="login100-form-btn" type="button" >
                            Sign up
                        </button>
                    </a>
                </div>
                <p class="mt-5 mb-3 text-muted">&copy; Tinder 2020</p>


            </form>

            <div class="login100-more" style="background-image: url('images/bg-01.jpg');size: auto">
            </div>
        </div>
    </div>
</div>


<!--===============================================================================================-->
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="js/main.js"></script>

</body>
</html>