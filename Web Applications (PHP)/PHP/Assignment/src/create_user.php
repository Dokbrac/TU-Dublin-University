<?php
if (isset($_POST['submit'])) {
    try {
        require "../src/DBconnect.php";
        $new_user = array(
            "firstname" => $_POST['firstname'],
            "lastname" => $_POST['lastname'],
            "email" => $_POST['email'],
            "age" => $_POST['age'],
            "location" => $_POST['location'],
            "username" => $_POST['username'],
            "password" => $_POST['password']
        );

        $sql = sprintf("INSERT INTO %s (%s) values (%s)", "users",
            implode(", ", array_keys($new_user)), ":" .
            implode(", :", array_keys($new_user)));
        $statement = $connection->prepare($sql);
        $statement->execute($new_user);
    } catch (PDOException $error) {
        echo $sql . "<br>" . $error->getMessage();
    }
}
?>

<?php
if (isset($_POST['submit']) && $statement) {
    echo $new_user['username'] . ' Successful Registration';
}
?>