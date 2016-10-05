<?php
$servername = "localhost";
$username = "root";
$password = "Down!Town9";
$dbname = "testDB";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

// Create database
/*
$sql = "CREATE DATABASE testDB";
if ($conn->query($sql) === TRUE) {
    echo "Database created successfully";
} else {
    echo "Error creating database: " . $conn->error;
}
*/

// sql to create table
/*
$sql = "CREATE TABLE userdata (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
usernumber VARCHAR(9) NOT NULL,
online VARCHAR(1),
reg_date TIMESTAMP
)";

if ($conn->query($sql) === TRUE) {
    echo "Table userdate created successfully";
} else {
    echo "Error creating table: " . $conn->error;
}
*/


// Insert Value into DB
/*
$sql = "INSERT INTO userdata (usernumber, online, reg_date)
VALUES ('123456789', 0, CURRENT_TIMESTAMP)";

if ($conn->query($sql) === TRUE) {
    echo "\nNew record created successfully\n";
} else {
    echo "\nError: " . $sql . "<br>\n" . $conn->error;
}
*/

$conn->close();
?>
