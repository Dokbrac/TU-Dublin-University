<?php require_once('../src/create_user.php'); ?>

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
        <li class="active"><a href="registration.php">Register</a></li>
        <li style="float:right"><a href="signin.php">Sign In</a></li>
    </ul>
</nav>

<div class="container">

    <form method="post" class="form-signin">
        <h2 class="form-signin-heading">Register</h2>
        <input type="text" name="firstname" id="firstname" class="form-control" placeholder="Firstname" required
               autofocus>
        <input type="text" name="lastname" id="lastname" class="form-control" placeholder="Lastname" required>
        <input type="text" name="email" id="email" class="form-control" placeholder="Email" required>
        <input type="text" name="age" id="age" class="form-control" placeholder="Age" required>
        <input type="text" name="location" id="location" class="form-control" placeholder="Location" required>
        <input type="text" name="username" id="username" class="form-control" placeholder="Username" required>
        <input type="text" name="password" id="password" class="form-control" placeholder="Password" required>
        <input type="submit" name="submit" value="Submit" class="button">
    </form>

</div>

<footer>
    <p>&copy; 2024 Csaba Palosi, All Rights Reserved</p>
</footer>
</html>