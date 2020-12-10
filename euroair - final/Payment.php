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

$FullName = $_POST['FullName'];
$Email = $_POST['Email'];
$Address = $_POST['Address'];
$City = $_POST['City'];
$State = $_POST['State'];
$Zip = $_POST['Zip'];
$NameOnCard = $_POST['NameOnCard'];
$CreditCardNum = $_POST['CreditCardNum'];
$ExpMonth = $_POST['ExpMonth'];
$ExpYear = $_POST['ExpYear'];
$CVV = $_POST['CVV'];

$Payment = "Insert into Payment (FullName,Email,Address,City,State,Zip,NameOnCard,CreditCardNum,ExpMonth,ExpYear,CVV)values ('$FullName','$Email','$Address','$City','$State','$Zip','$NameOnCard','$CreditCardNum','$ExpMonth','$ExpYear','$CVV')";

if(!mysqli_query($con,$Payment))
{
	echo "Not Inserted";
}
else
{
	session_start();
	echo "Inserted successfully";
	header("location: confirmation.html");
}

header("refresh:2; url=Payment.html");

?>