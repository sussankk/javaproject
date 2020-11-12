<?php
$dbhost='localhost';
$username1='root';
$password='dzhzmnms0727';
$db='EuroAir';

$link= mysqli_connect("$dbhost","$username1","$password");
if(!$link)
{
	echo'not Connected To server';
}

if(!mysqli_select_db($link,'EuroAir'))
{
	echo 'Database not selected';
}

else{
	

}

$payment=mysqli_query($link,"SELECT * FROM payment");
echo mysqli_error($link);
echo "<table border='1'>
    <tr>
          <th>NameOnCard</th>
          <th>CreditCardNumber</th>
          <th>ExpMonth</th>
          <th>ExpYear</th>
          <th>CVV</th>
    </tr>";

while($row=mysqli_fetch_array($payment)){
	echo "<tr>";
	echo "<td>".$row[0]."</td>";
	echo "<td>".$row[1]."</td>";
	echo "<td>".$row[2]."</td>";
	echo "<td>".$row[3]."</td>";
	echo "<td>".$row[4]."</td>";
	echo "</tr>";
}
echo "</table>";

?>