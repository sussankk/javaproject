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

$detail=mysqli_query($link,"SELECT * FROM contact_details");
echo mysqli_error($link);
echo "<table border='1'>
    <tr>
          <th>CountryCode</th>
          <th>Telephone</th>
          <th>EmailAddress</th>
          <th>Want</th>
    </tr>";

while($row=mysqli_fetch_array($detail)){
	echo "<tr>";
	echo "<td>".$row[0]."</td>";
	echo "<td>".$row[1]."</td>";
	echo "<td>".$row[2]."</td>";
	echo "<td>".$row[3]."</td>";
	echo "</tr>";
}
echo "</table>";

?>