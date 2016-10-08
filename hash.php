<?php
$word = htmlspecialchars($_GET["word"]);
$temp = "";
for($i=0; $i<strlen($word); $i++)
{
    $temp = $temp . ord($word[$i]);
}
$salt = random_bytes(15);
$temp = $temp . $salt;
echo "Pretty Damn Safe Hash Generator"."<br>";
echo hash('sha512',$temp);
echo "<br>".'Salt: '. $salt;
?>
