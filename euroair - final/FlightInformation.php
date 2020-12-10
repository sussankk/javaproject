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

$FlightNum = $_POST['FlightNum'];
$DepartureDate = $_POST['DepartureDate'];
$PassportNum = $_POST['PassportNum'];
$FlightInformation = "Insert into FlightInformation (FlightNum,DepartureDate,PassportNum)values ('$FlightNum','$DepartureDate','$PassportNum')";

if(!mysqli_query($con,$FlightInformation))
{
	echo "Not Inserted";
}
else
{
	session_start();
	echo "Inserted successfully";
	header("location: passengerdetails.html");
}

header("refresh:2; url=FlightInformation.html");

?>