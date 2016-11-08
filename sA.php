/* 
Mitchell and Jason 2016
This script is for sending a message to all users. 
It is for announcements and the geo-based message sending feature that is planned. 
*/
$toSend = htmlspecialchars($_GET["msg"]);
$time = date('c');

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
        $getter = $id . " ";
        $myFile = '/var/www/data/'. $getter . ".csv";
        $line = array($getter,'server',$time,$toSend);
        if (file_exists($myFile)) 
        {
            $fh = fopen($myFile, 'a');
        } 
        else 
        {
            $fh = fopen($myFile, 'w');
        } 
        fputcsv($fh, $line);
        fclose($fh);
}

/* Close the connection to DB */
$conn->close();

?>
