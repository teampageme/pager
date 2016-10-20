This folder contains a python program that encrypts and decrypts msgs(Now it is just for testing purposes).

We used Nuitka to compile our python code to make it a lot faster when executing the python code on the server.

Basically Nuitka translates python into a C++ program or into something called Cpython.

For compiling your python code: "nuitka x.py"
For running you python executable: "./x.exe"
As for the encryption part in python, we used the cryptography library which encrypts string using AES algorithm and with nuitka the speed of execution is efficent for what we want to achieve. 

For running php code: php x.php 'arg'

You can remove the compile commands after they have been executed once, in case you want to have faster execution for the php script. 
