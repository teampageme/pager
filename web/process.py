#!/usr/bin/env python
# Needs number.txt to run
import sys

def main():
  input1 = sys.argv[1].rstrip()
  text_file = open("number.txt", "r")
  lines = text_file.read().split(' ')
  text_file.close()
  if(input1 in lines):
    print("FAILAURE: DUPLICATE")
  else:
    text_file = open("number.txt", "a")
    text_file.write(input1 + " ")
    text_file.close()
    print("SUCCESS")
    
if __name__ == "__main__":
  main()
