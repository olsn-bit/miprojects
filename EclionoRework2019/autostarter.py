import pyautogui as pg
import time
# print(pg.position())
def start():
    if pg.position() == (0,0):
        import os
        os.system("python main.py")
        time.sleep(0.2)
    # else:
    #
    #     string = "[<rect(0, 0, 50, 50)>, <rect(50, 0, 50, 50)>, <rect(0, 50, 50, 50)>, <rect(50, 50, 50, 50)>, <rect(100, 50, 50, 50)>, <rect(50, 100, 50, 50)>, <rect(100, 100, 50, 50)>, <rect(150, 100, 50, 50)>, <rect(100, 150, 50, 50)>, <rect(150, 150, 50, 50)>, <rect(200, 150, 50, 50)>, <rect(150, 200, 50, 50)>, <rect(200, 200, 50, 50)>, <rect(200, 250, 50, 50)>, <rect(350, 250, 50, 50)>, <rect(200, 300, 50, 50)>, <rect(350, 300, 50, 50)>, <rect(200, 350, 50, 50)>, <rect(250, 350, 50,     50)>, <rect(300, 350, 50, 50)>, <rect(350, 350, 50, 50)>, <rect(400, 350, 50, 50)>, <rect(450, 350, 50, 50)>, <rect(500, 350, 50, 50)>, <rect(550, 350, 50, 50)>, <rect(600, 350, 50, 50)>, <rect(350, 400, 50, 50)>, <rect(400, 400, 50, 50)>, <rect(450, 400, 50, 50)>, <rect(500, 400, 50, 50)>, <rect(550, 400, 50, 50)>, <rect(600, 400, 50, 50)>, <rect(650, 400, 50, 50)>, <rect(750, 400, 50, 50)>, <rect(600, 450, 50, 50)>, <rect(650, 450, 50, 50)>, <rect(700, 450, 50, 50)>, <rect(750, 450,   50, 50)>, <rect(800, 450, 50, 50)>, <rect(850, 450, 50, 50)>, <rect(900, 450, 50, 50)>, <rect(700, 500, 50, 50)>, <rect(750, 500, 50, 50)>, <rect(800, 500, 50, 50)>, <rect(850, 500, 50, 50)>, <rect(900, 500, 50, 50)>, <rect(950, 500, 50, 50)>, <rect(1000, 500, 50, 50)>, <rect(700, 550, 50, 50)>, <rect(750, 550, 50, 50)>, <rect(800, 550, 50, 50)>, <rect(850, 550, 50, 50)>, <rect(900, 550, 50, 50)>, <rect(950, 550, 50, 50)>, <rect(1000, 550, 50, 50)>, <rect(1050, 550, 50, 50)>,    <rect(1100, 550, 50, 50)>, <rect(650, 600, 50, 50)>, <rect(700, 600, 50, 50)>, <rect(750, 600, 50, 50)>, <rect(800, 600, 50, 50)>, <rect(850, 600, 50, 50)>, <rect(900, 600, 50, 50)>, <rect(950, 600, 50, 50)>, <rect(1000, 600, 50, 50)>, <rect(1050, 600, 50, 50)>, <rect(1100, 600, 50, 50)>, <rect(650, 650, 50, 50)>, <rect(700, 650, 50, 50)>, <rect(750, 650, 50, 50)>, <rect(800, 650, 50, 50)>, <rect(850, 650, 50, 50)>, <rect(900, 650, 50, 50)>, <rect(950, 650, 50, 50)>, <rect(1000, 650,    50, 50)>, <rect(600, 700, 50, 50)>, <rect(650, 700, 50, 50)>, <rect(700, 700, 50, 50)>, <rect(750, 700, 50, 50)>, <rect(800, 700, 50, 50)>, <rect(850, 700, 50, 50)>, <rect(900, 700, 50, 50)>, <rect(950, 700, 50, 50)>]"
    #     string = string.replace(">","")
    #     string = string.replace("<","")
    #     string = string.replace("rect","pygame.Rect")
    #
    #     print(string)
    #     break
while True:
    start()