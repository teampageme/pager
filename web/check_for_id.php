<?php

define("DB_SERVER", "localhost");
define("DB_USER", "root");
define("DB_PASSWORD", "Down!Town9");
define("DB_DATABASE", "testDB");

/* Connect to DB */
$conn = mysqli_connect(DB_SERVER , DB_USER, DB_PASSWORD, DB_DATABASE);

// Check if connected
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

/* Get input paramters */
$id = mysqli_real_escape_string($conn, $argv[1]);

/* SQL query to check if id and password are correct */
$sql = "SELECT id FROM testUserTable2 WHERE id = '" . $id . "' LIMIT 1";

$result = $conn->query($sql);

if ($result->num_rows == 0) {
        echo "DOES_NOT_EXIST";
}

else {
        echo "EXISTS";
}

/* Close the connection to DB */
$conn->close();

?>


