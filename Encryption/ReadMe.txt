<<<<<<< HEAD
This folder contains a python program that encrypts and decrypts msgs(Now it is just for testing purposes).

We used Nuitka to compile our python code to make it a lot faster when executing the python code on the server.
=======
Encryption algorithm  used is SHA-256 with AES 256-BIT

compiling: javac -cp jasypt-1.9.1.jar:bcprov-jdk15on-155.jar: x.java 
run:       java  -cp jasypt-1.9.1.jar:bcprov-jdk15on-155.jar: x 'arg'
>>>>>>> origin/Develop

Basically Nuitka translates python into a C++ program or into something called Cpython.

For compiling your python code: "nuitka x.py"
For running you python executable: "./x.exe"

<<<<<<< HEAD
As for the encryption part in python, we used the cryptography library which encrypts string using AES algorithm and with nuitka the speed of execution is efficent for what we want to achieve. 
=======
For running php code: php x.php 'arg'

You can remove the compile commands after they have been executed once, in case you want to have faster execution for the php script. 
>>>>>>> origin/Develop
