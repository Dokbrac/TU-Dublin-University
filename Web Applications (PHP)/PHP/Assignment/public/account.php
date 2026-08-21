<?php require_once '../public/templates/header.php'; ?>
<?php require_once '../src/update_user.php'; ?>
<?php require_once '../src/delete_user.php'; ?>

<nav>
    <ul>
        <li><a class="active" href="account.php">Account</a></li>
        <li><a href="products.php">Products</a></li>
        <li style="float:right"><a href="signout.php">Sign Out</a></li>
    </ul>
</nav>

<?php require_once '../public/templates/footer.php'; ?>
