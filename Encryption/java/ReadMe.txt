Encryption algorithm  used is SHA-256 with AES 256BIT

compiling: javac -cp jasypt-1.9.1.jar:bcprov-jdk15on-155.jar: x.java
run: java -cp jasypt-1.9.1.jar:bcprov-jdk15on-155.jar: x

Programs for encypting or decrypting can be used command line arguments or hardcoding the input 

Regarding php code:
Enc.php compiles and runs the encrypt.java file and command line arguments can be used. 
Dec.php compiles and runs the decrypt.java file and command line arguments can be used.

You can remove the compile commands after it has been executed once, in case you want have faster exeecution for the php script. 
