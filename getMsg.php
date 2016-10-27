<?php
$userID = htmlspecialchars($_GET["userNumber"]);
$myFile = '/var/www/html/'. $userID . ".csv";
if (file_exists($myFile)) 
{
     $fh = fopen($myFile, 'r');
    while (($line = fgetcsv($fh)) !== FALSE) 
    {
        print_r($line);
        echo '</br>';
    }
    fclose($fh);
    #unlink($myfile);
    exec('rm '.$myFile);
}
else
{
    echo 'ERROR 001';
}

?>
