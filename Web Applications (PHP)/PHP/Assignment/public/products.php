<?php require_once '../public/templates/header.php'; ?>
<?php require_once '../src/read_products.php'; ?>

    <nav>
        <ul>
            <li><a href="account.php">Account</a></li>
            <li><a class="active" href="products.php">Products</a></li>
            <li style="float:right"><a href="signout.php">Sign Out</a></li>
        </ul>
    </nav>

<?php include "templates/footer.php"; ?>