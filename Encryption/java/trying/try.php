<?php

$file = "Main.java";
$filename = "Main";
exec('javac ' .$file, $output);
exec("java -cp . $filename $argv[1]", $output);

print_r($output);
?> 
