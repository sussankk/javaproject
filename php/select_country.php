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

$country=mysqli_query($link,"SELECT * FROM country");
echo mysqli_error($link);
echo "<table border='1'>
    <tr>
          <th>country</th>
    </tr>";

while($row=mysqli_fetch_array($country)){
	echo "<tr>";
	echo "<td>".$row[0]."</td>";
	echo "</tr>";
}
echo "</table>";
?>