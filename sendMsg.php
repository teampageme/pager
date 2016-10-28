<?php
$userID = htmlspecialchars($_GET["userNumber"]);
$from = htmlspecialchars($_GET["from"]);
$msg = htmlspecialchars($_GET["msgToSend"]);
$time = date('c');
$myFile = '/var/www/data/'. $userID . ".csv";
$line = array($userID,$from,$time,$msg);
if (file_exists($myFile)) 
{
  $fh = fopen($myFile, 'a');
} 
else 
{
  $fh = fopen($myFile, 'w');
} 
fputcsv($fh, $line);
echo 'SENT';
fclose($fh);
?>
