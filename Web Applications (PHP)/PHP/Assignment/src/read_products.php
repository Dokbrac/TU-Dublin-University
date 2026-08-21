<?php
try {
    require_once '../src/DBconnect.php';
    $sql = "SELECT * FROM products";
    $statement = $connection->prepare($sql);
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
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <?php foreach ($result as $row) { ?>
            <tr>
                <td><?php echo $row["id"]; ?></td>
                <td><?php echo $row["name"]; ?></td>
                <td><?php echo $row["euro"]; ?> EURO</td>
            </tr>
        <?php } ?>
        </tbody>
    </table>
<?php } else { ?>
    > No results found for <?php echo $_SESSION['Username']; ?>.
<?php }
?>


