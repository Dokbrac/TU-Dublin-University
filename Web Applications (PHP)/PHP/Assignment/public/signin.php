<?php session_start(); ?>
<?php require_once('../config.php'); ?>
<?php require_once('../src/login.php'); ?>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../css/stylesheet.css">
    <link rel="stylesheet" type="text/css" href="../css/signin.css">
</head>

<nav>
    <ul>
        <li><a href="index.php">Home</a></li>
        <li><a href="registration.php">Register</a></li>
        <li class="active" style="float:right"><a href="signin.php">Sign In</a></li>
    </ul>
</nav>

<body>

<div class="container">

    <form method="post" class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input name="Username" type="username" id="inputUsername" class="form-control" placeholder="Username" required
               autofocus>
        <input name="Password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <button name="Submit" value="Login" class="button" type="submit">Sign in</button>
    </form>

</div>

</body>

<footer>
    <p>&copy; 2024 Csaba Palosi, All Rights Reserved</p>
</footer>
</html>