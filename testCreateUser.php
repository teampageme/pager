<?php
define("DB_SERVER", "localhost");
define("DB_USER", "root");
define("DB_PASSWORD", "harambe");
define("DB_DATABASE", "testDB");
/* Connect to DB */
$conn = mysqli_connect(DB_SERVER , DB_USER, DB_PASSWORD, DB_DATABASE);
/* Check if connected */
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
/* Get input parameters */


$ID = $_GET["id"];
$password = $_GET["password"];
$key = $_GET["key"];
/*
$ID = $argv[1];
$password = $argv[2];
$key = $argv[3];
*/
//echo ($userID . "\n" . $pin . "\n");
/* SQL query to get row where id is equal */
$sql = "SELECT id FROM testUserTable WHERE id = $ID LIMIT 1";
$result = $conn->query($sql);
//$row = $result->fetch_assoc();
//echo "id: " . $row[userID] . "   pin: " . $row[pin];
/* ID does not exist */
if ($result->num_rows == 0) {
        /* Create Account */
	$sql = "INSERT INTO testUserTable (id, password, hash_key, reg_date)
	VALUES ($ID, $password, $key, CURRENT_TIMESTAMP)";
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
