<<<<<<< HEAD
Encryption algorithm  used is AES 128 with SHA-1

Programs for encypting or decrypting need command line arguments as inputs. 

The java code is located in "java/fast impelemenation"
All java code are precompiled and are ready to be excuted using php scripts Enc.php for encryption and Dec.php for decryption.
=======
This folder contains a python program that encrypts and decrypts msgs(Now it is just for testing purposes).

We used Nuitka to compile our python code to make it a lot faster when executing the python code on the server.
>>>>>>> origin/Develop

Regarding php code:
Enc.php runs the runE.java file and command line arguments can be used. 
Dec.php runs the runD.java file and command line arguments can be used.

<<<<<<< HEAD
runtime of code running on the client side takes about 0.4 seconds to execute.
runtime of code running on the server side takes about 3.6 seconds to execute, which means we need to upgrade our server's capabilites to improve the runtime of our program...

=======
For compiling your python code: "nuitka x.py"
For running you python executable: "./x.exe"
As for the encryption part in python, we used the cryptography library which encrypts string using AES algorithm and with nuitka the speed of execution is efficent for what we want to achieve. 

For running php code: php x.php 'arg'

You can remove the compile commands after they have been executed once, in case you want to have faster execution for the php script. 
>>>>>>> origin/Develop
