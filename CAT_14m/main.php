<?php

$cipher_t = "UVXYZ";
$s = 2;

function encrypt($cipher_t, $s)
{
$result = "";
for ($i = 0; $i < strlen($cipher_t); $i++)
$result = $result.chr((ord($cipher_t[$i]) +$s - 65) % 26 + 65);
return $result;
}

echo "\nText :".$cipher_t;
echo "\nShift:".$s;
echo "\nCipher:".encrypt($cipher_t, $s);
?>