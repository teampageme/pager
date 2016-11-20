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
$id = mysqli_real_escape_string($conn, $argv[1]);
$password = "'" . $argv[2] . "'";
$email = "'" . $argv[3] . "'";

$value = rtrim(shell_exec("php check_for_id.php $id"));

/* ID does not exist */
if ($value == "DOES_NOT_EXIST") {
    /* Create new user in table */
	$sql = "INSERT INTO testUserTable2 (id, password, email, reg_date)
	VALUES ($id, $password, $email, CURRENT_TIMESTAMP)";

	/* Check to see if query was successful */
	if ($conn->query($sql) === TRUE) {
    		echo "SUCCESS";
	} else {
    		echo "FAILED_TO_CREATE " . $conn->error;
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
