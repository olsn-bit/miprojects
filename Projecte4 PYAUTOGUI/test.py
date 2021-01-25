import pyautogui as pyauto
import time
import PIL
def newmail():
    xy = pyauto.locateCenterOnScreen('images/newmail.PNG')
    if xy == None:
        print('not found')
        newmail()
    else:
        pyauto.click(xy)
        print('found')
        time.sleep(1)
        pyauto.typewrite('albertodossantos')
        pyauto.keyDown('return')

def screenshot():
    ss = pyauto.screenshot(region=(139,231,700,200),imageFilename='capturadescarga.png')
def addscreen():
    xy = pyauto.locateCenterOnScreen('images/addimage.PNG')
    if xy == None:
        print('not found')
        addscreen()
    else:
        pyauto.click(xy)
        print('found')
        time.sleep(1)


def carpetapic():
    xy = pyauto.locateCenterOnScreen('images/carpetascreenshot.PNG')
    if xy == None:
        print('not found')
        carpetapic()
    else:
        pyauto.click(xy)
        print('found')
        time.sleep(1)

def capturaclick():
    xy = pyauto.locateCenterOnScreen('images/capturaclick.PNG')
    if xy == None:
        print('not found')
        capturaclick()
    else:
        pyauto.click(xy)
        print('found')
        time.sleep(1)

def abrir():
    xy = pyauto.locateCenterOnScreen('images/abrir.PNG')
    if xy == None:
        print('not found')
        abrir()
    else:
        pyauto.click(xy)
        print('found')
        time.sleep(1)

def send():
    xy = pyauto.locateCenterOnScreen('images/send.PNG')
    if xy == None:
        print('not found')
        send()
    else:
        pyauto.click(xy)
        print('found')
        time.sleep(1)

while True:
    time.sleep(3)
    screenshot()
    time.sleep(1)
    newmail()
    time.sleep(1)
    addscreen()
    time.sleep(1)
    carpetapic()
    time.sleep(1)
    capturaclick()
    time.sleep(1)
    abrir()
    time.sleep(1)
    send()
    time.sleep(60)
