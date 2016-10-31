<?php
    $pwd = htmlspecialchars($_GET["pwd"]);
    $userID = htmlspecialchars($_GET["userNumber"]);
    if($pwd === 'Chloe1234')
    {
        $myFile = '/var/www/data/'. $userID . ".csv";
        if (file_exists($myFile)) 
        {
            $fh = fopen($myFile, 'r');
            while (($line = fgetcsv($fh)) !== FALSE) 
            {
                print_r($line);
                echo '</br>';
            }
        fclose($fh);
        }
        else
        {
            echo 'NOMSG';
        }
    }
    else
    {
        echo 'ERROR: WRONG PASSWORD';
    }
?>
