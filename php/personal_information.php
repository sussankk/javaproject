<?php
$dbhost='localhost';
$username1='root';
$password='dzhzmnms0727';
$db='EuroAir';

$con= mysqli_connect("$dbhost","$username1","$password");
if(!$con)
{
	echo'not Connected To server';
}

if(!mysqli_select_db($con,'EuroAir'))
{
	echo 'Database not selected';
}

else{

}

$Title = $_POST['Title'];
$FirstName = $_POST['FirstName'];
$LastName = $_POST['LastName'];
$IsCard = $_POST['IsCard'];
$CardNumber = $_POST['CardNumber'];

$information = "Insert into personal_information (Title,FirstName,LastName,IsCard,CardNumber)values ('$Title','$FirstName','$LastName','$IsCard','$CardNumber')";

if(!mysqli_query($con,$information))
{
	echo "Not Inserted";
}
else
{
	echo "Inserted successfully";
}

header("refresh:2; url=personal_information.html");

?>