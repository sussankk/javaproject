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

$CountryCode = $_POST['CountryCode'];
$Telephone = $_POST['Telephone'];
$EmailAddress = $_POST['EmailAddress'];
$Want = $_POST['Want'];

$contact = "Insert into contact_details (CountryCode,Telephone,EmailAddress,Want)values ('$CountryCode','$Telephone','$EmailAddress','$Want')";

if(!mysqli_query($con,$contact))
{
	echo "Not Inserted";
}
else
{
	echo "Inserted successfully";
}

header("refresh:2; url=contact_details.html");

?>