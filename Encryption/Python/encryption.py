#!/usr/bin/env python
import time
import sys
from cryptography.fernet import Fernet

start_time = time.time()

key = Fernet.generate_key()
cryptor = Fernet(key)

msg = str(sys.argv[-1]) 

encryptedMsg = cryptor.encrypt(msg)
decryptedMsg = cryptor.decrypt(encryptedMsg)

print "Original msgs:  ", msg, "\n"
print "encrypted msgs: ", encryptedMsg, "\n"
print "Decrypted msgs: ", decryptedMsg, "\n"

print("---%s seconds ---" % (time.time() - start_time))
