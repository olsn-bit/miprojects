from PIL import ImageGrab, ImageOps, ImageChops, Image
import pyautogui as pauto
import time
from numpy import *
restartimage = 'restartlasttry.PNG'
stop = 0
def restart():

    xy = pauto.locateCenterOnScreen(restartimage)
    if xy == None:
        print('not found')
        restart()
    else:
        pauto.click(xy)
        print('found')



def obstacles():

    img1 = pauto.screenshot(region=(295,388,10,10),imageFilename='screenshot1.png')
    img = 'screenshot1.png'
    time.sleep(0.08)
    img = Image.open(img)
    clrs = img.getcolors()
    print(clrs)
    if clrs != [(100, (247, 247, 247))]:
        print('jump')
        pauto.keyDown('up')
    else:
        print('dont jump')

restart()
while True:
    obstacles()
