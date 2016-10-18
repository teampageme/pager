Encryption algorithm  used is SHA-256 with AES 256-BIT

compiling: javac -cp jasypt-1.9.1.jar:bcprov-jdk15on-155.jar: x.java 
run:       java  -cp jasypt-1.9.1.jar:bcprov-jdk15on-155.jar: x 'arg'

Programs for encypting or decrypting can be used command line arguments or hardcoding the input 

Regarding php code:
Enc.php compiles and runs the encrypt.java file and command line arguments can be used. 
Dec.php compiles and runs the decrypt.java file and command line arguments can be used.

For running php code: php x.php 'arg'

You can remove the compile commands after they have been executed once, in case you want to have faster execution for the php script. 
