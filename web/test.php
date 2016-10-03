<?php
$input = htmlspecialchars($_GET["numberToAdd"]);
$output = shell_exec('/var/www/html/process.py '.$input);
echo "<pre>$output</pre>"
?>
