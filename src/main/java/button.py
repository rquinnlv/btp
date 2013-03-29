from time import sleep
from subprocess import call
import os
import RPi.GPIO as GPIO

GREEN_LED=17
RED_LED=4	

GPIO.setmode(GPIO.BCM)
GPIO.setup(23, GPIO.IN)
GPIO.setup(24, GPIO.IN)
GPIO.setup(25, GPIO.IN)
GPIO.setup(GREEN_LED, GPIO.OUT)
GPIO.setup(RED_LED, GPIO.OUT)

while True:
        if ( GPIO.input(23) == False ): 	 
		GPIO.output(GREEN_LED, False)
		GPIO.output(RED_LED, True)
		os.system("rm test.jpg")
                os.system("fswebcam --save test.jpg")
                sleep(0.2)
                os.system("zbarimg -q test.jpg > temp.txt")
                a=open('temp.txt','r')
                val=a.read()
                b=val[8:]
                a.close
                #c=open('bang.txt','w')
                print "b1,"+b.lower()
		out='echo "b1,%s" > bang.txt' % b.lower()
		print out
                os.system(out)
		#c.write("b1,"+b.lower())
                #c.close
		GPIO.output(GREEN_LED, True)
                GPIO.output(RED_LED, False)
        if ( GPIO.input(24) == False ):
		GPIO.output(GREEN_LED, False)
                GPIO.output(RED_LED, True)
		os.system("rm test.jpg")
                os.system("fswebcam --save test.jpg")
                sleep(0.2)
                os.system("zbarimg -q test.jpg > temp.txt")
                a=open('temp.txt','r')
                val=a.read()
                b=val[8:]
                a.close
                #c=open('bang.txt','w')
                print "b2,"+b.lower()
                out='echo "b2,%s" > bang.txt' % b.lower()
                print out
                os.system(out)
                #c.write("b2,"+b.lower())
                #c.close
		GPIO.output(GREEN_LED, True)
                GPIO.output(RED_LED, False)                
	if ( GPIO.input(25)== False ):
		GPIO.output(GREEN_LED, False)
                GPIO.output(RED_LED, True)
#		os.system("rm test.jpg")
#		os.system("fswebcam --save test.jpg")       
#		sleep(0.2)
#		os.system("zbarimg -q test.jpg > temp.txt")
#		a=open('temp.txt','r')
#		val=a.read()
#		b=val[8:]
#		a.close
#		#c=open('bang.txt','w')
#		print "b3,"+b.lower()
                out='echo "b3,%s" > bang.txt' % "b3,b3"
                print out
                os.system(out)		
		#c.write("b3,"+b.lower())
		#c.close
		GPIO.output(GREEN_LED, True)
                GPIO.output(RED_LED, False)		
	sleep(0.2);
