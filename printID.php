<?php
// Mitchell 2016

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

/* SQL query to select all rows where id are equal */
$sql = "SELECT * FROM testUserTable";
$result = $conn->query($sql);


while($row = mysqli_fetch_assoc($result)) {
        $id = $row['ID'];
        echo $id . " ";
}

/* Close the connection to DB */
$conn->close();

?>
