<?php
        exec("java run " . " $argv[1]", $output);
        //print_r($output);
        echo end($output);
        //echo prev($output);
?>

