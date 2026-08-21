<?php
try {
    require_once '../src/DBconnect.php';
    $sql = "SELECT *
            FROM users
            WHERE username = :username";

    $username = $_SESSION['Username'];

    $statement = $connection->prepare($sql);
    $statement->bindParam(':username', $username, PDO::PARAM_STR);
    $statement->execute();
    $result = $statement->fetchAll();


} catch (PDOException $error) {
    echo $sql . "<br>" . $error->getMessage();
}
?>

<?php
if ($result && $statement->rowCount() > 0) {
    ?>
    <h1>Status: You are logged in <?php echo $_SESSION['Username']; ?> </h1>
    <table>
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email Address</th>
            <th>Age</th>
            <th>Location</th>
        </tr>
        </thead>
        <tbody>
        <?php foreach ($result as $row) { ?>
            <tr>
                <td><?php echo $row["firstname"]; ?></td>
                <td><?php echo $row["lastname"]; ?></td>
                <td><?php echo $row["email"]; ?></td>
                <td><?php echo $row["age"]; ?></td>
                <td><?php echo $row["location"]; ?></td>
            </tr>
        <?php } ?>
        </tbody>
    </table>
<?php } else { ?>
    > No results found for <?php echo $_SESSION['Username']; ?>.
<?php }
?>