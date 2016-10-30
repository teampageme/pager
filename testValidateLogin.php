<?php

define("DB_SERVER", "localhost");
define("DB_USER", "root");
define("DB_PASSWORD", "");
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
$sql = "SELECT ID, password FROM testUserTable WHERE ID = $ID AND password = $password LIMIT 1";
$result = $conn->query($sql);

//$row = $result->fetch_assoc();
//echo "id: " . $row[userID] . "   pin: " . $row[pin];

/* Invalid login*/
if ($result->num_rows == 0) {
	echo "INVALID";
}
/* Valid login */
else {
	echo "VALID";
}

/* Close connection */
$conn->close();

?>
