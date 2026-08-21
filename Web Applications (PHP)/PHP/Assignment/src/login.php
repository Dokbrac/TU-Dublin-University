<?php
{
    try {

        $connection = new PDO($dsn, $username, $password, $options);

        $sql = "SELECT username, password FROM users WHERE username = :USER";
        $statement = $connection->prepare($sql);
        if (isset ($_POST['Username'])) {
            $tmpUser = ($_POST['Username']);
        }
        $statement->bindParam(':USER', $tmpUser, PDO::PARAM_STR);
        $statement->execute();
        $result = $statement->fetchAll();
        foreach ($result as $row => $rows) {
            $username_db = $rows['username'];
            $pwd_db = $rows['password'];

            if (($_POST['Username'] == $username_db) && ($_POST['Password'] == $pwd_db)) {
                $_SESSION['Username'] = $username_db;
                $_SESSION['Active'] = true;
                header("location:account.php");
                exit;
            } else {
                echo 'Incorrect Username or Password';
            }
        }
    } catch
    (Exception $e) {
        echo 'Error Logging in';
    }
}
?>