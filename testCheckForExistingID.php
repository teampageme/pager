<?php

define("DB_SERVER", "localhost");
define("DB_USER", "root");
define("DB_PASSWORD", "");
define("DB_DATABASE", "testDB");

/* Connect to DB */
$conn = mysqli_connect(DB_SERVER , DB_USER, DB_PASSWORD, DB_DATABASE);

// Check if connected
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}


/* Read paramter inputs */
$ID = $_GET["id"];

//echo ($userID . "\n" . $pin . "\n");

/* SQL query to select all rows where id are equal */
$sql = "SELECT ID FROM testUserTable WHERE ID = $ID LIMIT 1";
$result = $conn->query($sql);

//$row = $result->fetch_assoc();
//echo "id: " . $row[userID] . "   pin: " . $row[pin];

/* The ID does not exist */
if ($result->num_rows == 0) {
        echo "DOES_NOT_EXIST";
}
/* The ID exists */
else {
        echo "EXISTS";
}

/* Close the connection to DB */
$conn->close();

?>

