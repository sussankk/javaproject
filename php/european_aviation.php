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

$Id = $_POST['Id'];
$StartCountry = $_POST['StartCountry'];
$EndCountry = $_POST['EndCountry'];
$ToOrReturn = $_POST['ToOrReturn'];
$DateOfDeparture = $_POST['DateOfDeparture'];
$ReturnDate = $_POST['ReturnDate'];
$TankType = $_POST['TankType'];

$european = "Insert into european_aviation (Id,StartCountry,EndCountry,ToOrReturn,DateOfDeparture,ReturnDate,TankType)values ('$Id','$StartCountry','$EndCountry','$ToOrReturn','$DateOfDeparture','$ReturnDate','$TankType')";

if(!mysqli_query($con,$european))
{
	echo "Not Inserted";
}
else
{
	echo "Inserted successfully";
}

header("refresh:2; url=european_aviation.html");

?>