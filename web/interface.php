<?php

$script = $_GET["script"];
$value = shell_exec("php script_to_int.php " . "'" . $script . "'");

switch ($value) {
	case 0:
		exit("Failed to load script: " . $script);
		break;
	case 1:
		$id = $_GET["id"];
		$password = $_GET["password"];
		echo shell_exec("php login.php " . $id . " '" . $password . "'");
		break;
	case 2:
		$id = $_GET["id"];
		echo shell_exec("php check_for_id.php " . $id);
		break;
	case 3:
		$id = $_GET["id"];
		$password = $_GET["password"];
		$email = $_GET["email"];
		echo shell_exec("php create_user.php " . $id . " '" . $password . "' " . $email);
		break;
	case 4:
		
		break;
	case 5:

		break;
}


?>
