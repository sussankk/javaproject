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

$aviation=mysqli_query($link,"SELECT * FROM european_aviation");
echo mysqli_error($link);
echo "<table border='1'>
    <tr>
          <th>Id</th>
          <th>StartCountry</th>
          <th>EndCountry</th>
          <th>ToOrReturn</th>
          <th>DateOfDeparture</th>
          <th>ReturnDate</th>
          <th>TankType</th>
    </tr>";

while($row=mysqli_fetch_array($aviation)){
	echo "<tr>";
	echo "<td>".$row[0]."</td>";
	echo "<td>".$row[1]."</td>";
	echo "<td>".$row[2]."</td>";
	echo "<td>".$row[3]."</td>";
	echo "<td>".$row[4]."</td>";
	echo "<td>".$row[5]."</td>";
	echo "<td>".$row[6]."</td>";
	echo "</tr>";
}
echo "</table>";

?>