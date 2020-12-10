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


//insert
$Country = $_POST['Country'];
$Telephone = $_POST['Telephone'];
$Email = $_POST['Email'];
$IsReceiveAds = $_POST['IsReceiveAds'];

$ContactDetails = "Insert into ContactDetails(Country,Telephone,Email,IsReceiveAds)values('$Country','$Telephone','$Email','$IsReceiveAds')";

if(!mysqli_query($con,$ContactDetails))
{
	echo "Not Inserted";
}
else
{
	session_start();
	echo "Inserted successfully";
	header("location: payment.html");
}

header("refresh:2; url=ContactDetails.html");

?>