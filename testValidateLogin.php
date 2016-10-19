<?php

define("DB_SERVER", "localhost");
define("DB_USER", "root");
define("DB_PASSWORD", "Down!Town9");
define("DB_DATABASE", "testDB");

/* Connect to DB */
$conn = mysqli_connect(DB_SERVER , DB_USER, DB_PASSWORD, DB_DATABASE);

/* Check the connection */
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

/* Get input paramters */
$userID = $_GET["id"];
$pin = $_GET["pin"];

//echo ($userID . "\n" . $pin . "\n");

/* SQL query to check if id and pin are correct */
$sql = "SELECT userID, pin FROM testuserdata WHERE userID = $userID AND pin = $pin LIMIT 1";
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
