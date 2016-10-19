<?php

define("DB_SERVER", "localhost");
define("DB_USER", "root");
define("DB_PASSWORD", "Down!Town9");
define("DB_DATABASE", "testDB");

/* Connect to DB */
$conn = mysqli_connect(DB_SERVER , DB_USER, DB_PASSWORD, DB_DATABASE);


/* Check if connected */
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

/* Get input parameters */
$userID = $_GET["id"];
$pin = $_GET["pin"];

//echo ($userID . "\n" . $pin . "\n");

/* SQL query to get row where id is equal */
$sql = "SELECT userID FROM testuserdata WHERE userID = $userID LIMIT 1";
$result = $conn->query($sql);

//$row = $result->fetch_assoc();
//echo "id: " . $row[userID] . "   pin: " . $row[pin];

/* ID does not exist */
if ($result->num_rows == 0) {
        /* Create Account */
	$sql = "INSERT INTO testuserdata (userID, pin, reg_date)
	VALUES ($userID, $pin, CURRENT_TIMESTAMP)";

	/* Check to see if query was successful */
	if ($conn->query($sql) === TRUE) {
    		echo "SUCCESS";
	} else {
    		echo "FAILED_TO_CREATE" . $conn->error;
	}
}
/* Account ID already exists */
else {
	//ID already exists
        echo "FAILED_ALREADY_EXISTS";
}

/* Close Connection */
$conn->close();

?>

