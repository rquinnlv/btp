import os
import sys
from time import sleep

if __name__ == "__main__":
	bb = "txt a "+"<speed6>"+sys.argv[1]
	a=open('bb.txt','w')
	a.write(bb)
	a.close()
	sleep(0.2)
	print bb
	os.system("~/bbusb/build/bbusb -i ~/btp/src/main/java/bb.txt")



