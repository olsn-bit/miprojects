import os
import webbrowser
import time
desabilit = [1,4,5,6,7,8,9,10,11,12]
for e in desabilit:
    os.system("xinput float "+str(e))
os.system("killall chrome")
time.sleep(2)
os.system("google-chrome -kiosk -incognito www.fakeupdate.net/ubuntu")
time.sleep(1)
pyautogui.moveTo(x=0,y=500)

time.sleep(60)
for e in desabilit:
    os.system("xinput reattach "+str(e)+" 2")
for e in desabilit:
    os.system("xinput reattach "+str(e)+" 3")
