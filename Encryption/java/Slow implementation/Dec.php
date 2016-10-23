<?php
        $file = "decrypt.java";
        $filename = "decrypt";
        exec("javac -cp jasypt-1.9.1.jar:bcprov-jdk15on-155.jar: " .$file ,$output);
        exec("java  -cp jasypt-1.9.1.jar:bcprov-jdk15on-155.jar: " . "$filename $argv[1]" ,$output);
        print_r($output);
?>

