<?php
#doesn't work
$userID = htmlspecialchars($_GET["userNumber"]);
$from = htmlspecialchars($_GET["from"]);
$msg = htmlspecialchars($_GET["msgToSend"]);
$time = date('c');
$myFile = '/var/www/html/'. $userID . ".csv";
echo $myFile;
echo $time;
$line = array($userID,$from,$time,$msg);
if (file_exists($myFile)) {
  $fh = fopen($myFile, 'a');
} else {
  $fh = fopen($myFile, 'w');
} 
fputcsv($fh, $line);
fclose($fh);
?>
