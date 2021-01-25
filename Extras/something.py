import playsound,time
import pyautogui as pauto
from PIL import Image
e = 0
def main():
    global e
    img1 = pauto.screenshot(region=(1384,569,1,1),imageFilename='detect.png')
    img = 'detect.png'
    time.sleep(0.4 )
    img = Image.open(img)
    clrs = img.getcolors()
    integer = str(clrs)[6:9]
    #print(clrs)
    try:
        print(int(integer),e)
        something = 0
    except:
        something = 1
        pauto.screenshot(imageFilename=('capture'+str(e)+'.png'))
        print("notgud")
        playsound._playsoundWin("alarm.mp3")

    if something == 0:
        if int(integer) in range(190,240):
            pass
        else:
            pauto.screenshot(imageFilename=('capture'+str(e)+'.png'))
            playsound._playsoundWin("alarm.mp3")

    # clrs = [(1, eq,ew,ee))]
    # if eq < 100:
    #     if ew < 100:
    #         if ee < 100:
    #             print(ello)
    #print(e)
    #if clrs == [(1, (range(100,200),range(100,200),range(100,200)))]:
        #print("print")
        #    print('jump')
        #    pauto.keyDown('up')

    #else:
        #print('pront')
while True:
    e += 1
    main()
#playsound._playsoundWin("alarm.mp3")
