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
$id = mysqli_real_escape_string($conn, $argv[1]);
$password = str_replace("'", "", $argv[2]);

exec("java -server run '" . $password . "'", $output);

/* SQL query to check if id and password are correct */
$sql = "SELECT id, password FROM testUserTable2 WHERE id = $id LIMIT 1";
$result = $conn->query($sql);
$row = $result->fetch_assoc();

exec("java run '" . $row[password] . "'", $output2);

//echo "pass1: " . $password . "  pass2: "  . $row[password];
/* Valid login*/

//echo end($output) . " " . end($output);

if (end($output) == end($output2)) {
	echo "VALID";
}
/* Invalid login */
else {
	echo "INVALID";
}

/* Close connection */
$conn->close();

?>

