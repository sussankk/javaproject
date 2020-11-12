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

$NameOnCard = $_POST['NameOnCard'];
$CreditCardNumber = $_POST['CreditCardNumber'];
$ExpMonth = $_POST['ExpMonth'];
$ExpYear = $_POST['ExpYear'];
$CVV = $_POST['CVV'];

$payment1 = "Insert into payment (NameOnCard,CreditCardNumber,ExpMonth,ExpYear,CVV)values ('$NameOnCard','$CreditCardNumber','$ExpMonth','$ExpYear','$CVV')";

if(!mysqli_query($con,$payment1))
{
	echo "Not Inserted";
}
else
{
	echo "Inserted successfully";
}

header("refresh:2; url=payment.html");

?>