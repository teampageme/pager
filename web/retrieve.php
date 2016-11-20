<?php
	
	error_reporting(E_ERROR | E_PARSE);
	$userID = htmlspecialchars($_GET["userNumber"]);
	$myFile = '/var/www/data/'. $userID . ".csv";
        //if (filesize($myFile) == 0)
	//{
        //        echo 'NOMSG';
        //}
	$data = file_get_contents($myFile);
	$size = strlen($data);
	if (file_exists($myFile) && $size != 0 && filesize($myFile) != 0)
	{
	     $fh = fopen($myFile, 'r');
	     echo nl2br(file_get_contents($myFile));
	     //fclose($fh);
	     #unlink($myfile);
             //exec('rm '.$myFile);
	}	
	elseif(filesize($myFile) == 0)
	{
		echo "NOMSG";
	}

?>
