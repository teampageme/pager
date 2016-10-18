<?php
emailAddress =  $_GET['email'];
$to      = emailAddress;
$key = uniqid(rand(5, 1000000), true);
$subject = 'Key';
$headers = 'From: webmaster@example.com' . "\r\n" .
    'Reply-To: webmaster@example.com' . "\r\n" .
    'X-Mailer: PHP/' . phpversion();

mail($to, $subject, $key, $headers);
?> 
