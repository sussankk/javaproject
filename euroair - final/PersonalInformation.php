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
$PassportNum = $_POST['PassportNum'];
$Email = $_POST['Email'];
$Telephone = $_POST['Telephone'];
$IsMember = $_POST['IsMember'];
$MembershipCardNum = $_POST['MembershipCardNum'];

$PersonalInformation = "Insert into PersonalInformation (Title,FirstName,LastName,PassportNum,Email,Telephone,IsMember,MembershipCardNum)values ('$Title','$FirstName','$LastName','$PassportNum','$Email','$Telephone','$IsMember','$MembershipCardNum')";

if(!mysqli_query($con,$PersonalInformation))
{
	echo "Not Inserted";
}
else
{
	session_start();
	echo "Inserted successfully";
	header("location: contactdetails.html");
}

header("refresh:2; url=PersonalInformation.html");

?>