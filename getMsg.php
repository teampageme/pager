<?php
$userID = htmlspecialchars($_GET["userNumber"]);
$myFile = '/var/www/html/'. $userID . ".csv";
if (file_exists($myFile)) 
{
     $fh = fopen($myFile, 'a');
     while(! feof($file))
    {
        print_r(fgetcsv($file));
    }
    fclose($fh);
    unlink($myfile);
}
else
{
    echo 'ERROR 001';
}

?>
