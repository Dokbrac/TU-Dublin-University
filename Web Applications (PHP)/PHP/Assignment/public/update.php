<?php require_once '../public/templates/header.php'; ?>
<link rel="stylesheet" type="text/css" href="../css/signin.css">

<nav>
    <ul>
        <li><a class="active" href="account.php">Account</a></li>
        <li><a href="products.php">Products</a></li>
        <li style="float:right"><a href="signout.php">Sign Out</a></li>
    </ul>
</nav>

<?php
if (isset($_POST['submit'])) {
    try {
        require_once '../src/DBconnect.php';
        $user = [
            "firstname" => $_POST['firstname'],
            "lastname" => $_POST['lastname'],
            "email" => $_POST['email'],
            "age" => $_POST['age'],
            "location" => $_POST['location'],
            "username" => $_POST['username'],
            "password" => $_POST['password']
        ];
        $sql = "UPDATE users SET
                 firstname = :firstname,
                 lastname = :lastname,
                 email = :email,
                 age = :age,
                 location = :location,
                 username = :username,
                 password = :password
                 WHERE username = :username";
        $statement = $connection->prepare($sql);
        $statement->execute($user);
    } catch (PDOException $error) {
        echo $sql . "<br>" . $error->getMessage();
    }
}
if (isset($_GET['id'])) {
    try {
        require_once '../src/DBconnect.php';
        $id = $_GET['id'];
        $sql = "SELECT firstname, lastname, email, age, location, username, password FROM users WHERE id = :id";
        $statement = $connection->prepare($sql);
        $statement->bindValue(':id', $id);
        $statement->execute();
        $user = $statement->fetch(PDO::FETCH_ASSOC);
    } catch (PDOException $error) {
        echo $sql . "<br>" . $error->getMessage();
    }
} else {
    echo "Something went wrong!";
    exit;
}
?>

<?php if (isset($_POST['submit']) && $statement) : ?>
    <?php echo $_POST['username']; ?> successfully updated!!!
<?php endif; ?>
<form method="post" class="form-signin">
    <?php foreach ($user as $key => $value) : ?>
        <!--        <label for="--><?php //echo $key; ?><!--">--><?php //echo ucfirst($key); ?><!--</label>-->
        <input class="form-control" type="text" name="<?php echo $key; ?>" id="<?php echo $key;
        ?>" value="<?php echo $value; ?>" <?php echo($key === 'id' ?
            'readonly' : null); ?>>
    <?php endforeach; ?>
    <input type="submit" name="submit" value="Submit" class="button">
</form>

<?php require_once '../public/templates/footer.php'; ?>
