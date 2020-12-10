<?php
// Initialize the session
session_start();
 
// Check if the user is logged in, if not then redirect him to login page
if(!isset($_SESSION["loggedin"]) || $_SESSION["loggedin"] !== true){
    header("location: login.php");
    exit;
}
?>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
    <link href="https://fonts.googleapis.com/css?family=Kalam:700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Pangolin&display=swap" rel="stylesheet">  
    <link rel="stylesheet" type="text/css" href="home.css">
</head>
<body>
    <h1 id="b5"><big><strong>Euro Air</strong></big></h1>
    <div class="page-header">
        <h3 id="b6">Hi, <b><?php echo htmlspecialchars($_SESSION["Email"]); ?></b>. Welcome to Euro Air.</h3>
    </div>
    <p>
        <a href="logout.php" class="btn btn-danger" id="b6">Sign Out of Your Account</a>
        <a href="bookingpage.html" class="btn btn-success" id="b6">Go inside to the Booking Page</a>
    </p>
</body>
</html>