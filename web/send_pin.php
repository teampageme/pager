<?php

$email = $_GET["email"];
//$email = "alikafag@buffalo.edu";
function generate($length = 4)
{
	$characters = '0123456789abcdefghijklmnopqrstuvwxyz';
	$charactersLength = strlen($characters);
	$randomString = '';
	for($i = 0; $i < $length; $i++)
	{
		$randomString .= $characters[rand(0, $charactersLength - 1)];
	} 
	return $randomString;
}

$pin = generate();

exec("echo " . "$pin" . " | mail -s 'PageMe Confirmation'"  . " $email", $output);

echo $pin;

?>
