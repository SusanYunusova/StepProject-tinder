<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="img/favicon.ico">

    <title>Profile Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="css/style.css">
</head>

<body class="text-center">
<form class="form-signin" method="post" action="Dispatcher">
    <img class="mb-4" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">Profile Info</h1>
    <input type="url" class="form-control" placeholder="Photo Link" name="photo" required autofocus>
    <input type="text" class="form-control" placeholder="Name" name="name" required>
    <label for="gender" class="sr-only">Gender</label>
    <select id="gender" name="gender" class="form-control" style="height: 45px;" required autofocus>
        <option selected hidden value ="none">Gender</option>
        <option value ="male" name="male">Male</option>
        <option value ="female" name="female">Female</option>
        <option value ="other" name="other">Other</option>
    </select>    <input type="text" class="form-control" placeholder="Title" name="title" required>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Next</button>
    <p class="mt-5 mb-3 text-muted"> <h7 style="color: white">&copy; Tinder 2020</h7></p>
</form>
</body>
</html>