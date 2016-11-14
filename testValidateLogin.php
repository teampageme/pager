<?php
define("DB_SERVER", "localhost");
define("DB_USER", "root");
define("DB_PASSWORD", "harambe");
define("DB_DATABASE", "testDB");
/* Connect to DB */
$conn = mysqli_connect(DB_SERVER , DB_USER, DB_PASSWORD, DB_DATABASE);
/* Check the connection */
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
/* Get input paramters */
$ID = $_GET["id"];
$password = $_GET["password"];
//echo ($userID . "\n" . $pin . "\n");
/* SQL query to check if id and pin are correct */
exec("java run " . $password, $output);
$dec = end($output);
$sql = "SELECT id, password FROM testUserTable WHERE id = $ID  LIMIT 1";
$result = $conn->query($sql);
$row = $result->fetch_assoc();
exec("java run " . $row[password], $output2);
$dec2 = end($output2);
/* Invalid login*/
if (strcmp($dec, $dec2)) {
	echo "VALID";
}
/* Valid login */
else {
	echo "INVALID";
}
/* Close connection */
$conn->close();
?>

