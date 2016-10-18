<?php
$emailAddress =  $_GET['email'];
$pin =  $_GET['tempPin'];
$to      = $emailAddress;
$key = uniqid(rand(5, 1000000), true);
$subject = 'Key';
$headers = 'From: admin@teampageme.com' . "\r\n" .
    'Reply-To: admin@teampageme.com' . "\r\n" .
    'X-Mailer: PHP/' . phpversion();

mail($to, $subject, $key, $headers);
?> 
