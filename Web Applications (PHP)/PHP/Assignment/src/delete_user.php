<?php require_once '../public/templates/header.php'; ?>

<?php
if (isset($_GET["id"])) {
    try {
        require_once '../src/DBconnect.php';
        $id = $_GET["id"];
        $sql = "DELETE FROM users WHERE id = :id";
        $statement = $connection->prepare($sql);
        $statement->bindValue(':id', $id);
        $statement->execute();
        $result = $statement->fetchAll();
    } catch (PDOException $error) {
        echo $sql . "<br>" . $error->getMessage();
    }
}
?>
<?php foreach ($result as $row) : ?>
    <a href="delete.php?id=<?php echo $row["id"]; ?>">Delete Account</a>

<?php endforeach; ?>
