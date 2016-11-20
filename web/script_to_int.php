<?php

$script = $argv[1];

if ($script == "login") {
	echo "1";
}
else if ($script == "check_for_id") {
	echo "2";
}
else if ($script == "create_user") {
	echo "3";
}
else if ($script == "send_message") {
	echo "4";
}
else if ($script == "get_message") {
        echo "5";
}
else {
	echo "0";
}


?>
