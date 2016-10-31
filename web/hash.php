<?php
function saltedHash($word)
{
  $temp = "";
  for($i=0; $i<strlen($word); $i++)
  {
      $temp = $temp . ord($word[$i]);
  }
  $salt = random_bytes(15);
  $temp = $temp . $salt;
  $toReturn = array($temp,$salt);

  return $toreturn;
}
$word = htmlspecialchars($_GET["word"]);
$toPrint = saltedHash($word);
echo "Pretty Damn Safe Hash Generator"."<br>";
echo hash('sha512',$toPrint[0];
echo "<br>".'Salt: '. $toPrint[1];
?>
