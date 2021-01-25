import pyautogui as pg
import time,random
def randomcode():
    leters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
    numbers = "1234567890"
    code = []
    codestructure = ["n","l","l","l","n","l","l","l"]
    for e in range(8):
        # # if e == "n":
        # if e % 2 == 0:
        #     code.append(random.choice(numbers))
        # else:
        code.append(random.choice(leters))
    return "".join(code)
def start():
    time.sleep(2)
    badrequest = pg.locateOnScreen("errorveri.png")
    if badrequest == None:
        return
    pg.doubleClick(775,730)
    code = randomcode()
    print(code)
    pg.typewrite(code)
while True:
    time.sleep(2)
    print(randomcode())
