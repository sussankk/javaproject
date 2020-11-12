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
$FullName = $_POST['FullName'];
$Email = $_POST['Email'];
$Address = $_POST['Address'];
$City = $_POST['City'];
$State = $_POST['State'];
$Zip = $_POST['Zip'];

$bill = "Insert into billing_address(FullName,Email,Address,City,State,Zip)values('$FullName','$Email','$Address','$City','$State','$Zip')";

if(!mysqli_query($con,$bill))
{
	echo "Not Inserted";
}
else
{
	echo "Inserted successfully";
}

header("refresh:2; url=billing_address.html");

?>