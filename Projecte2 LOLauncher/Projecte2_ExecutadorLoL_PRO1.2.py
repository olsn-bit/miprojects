import pyautogui as py
from Tkinter import*
import Tkinter as tk
import os
import pyautogui
DATA = "C:\LauncherLOL"
def main():
    nomf = nomin.get()
    password = paswin.get()
    SIGN.destroy()
    paswsaver()
    FIN = tk.Tk()
    FIN.title("Map Switcher")
    FIN.geometry("280x100+400+400")
    tk.Button(FIN, text="Twisted Treeline", command=Twisted, font=20) .pack(fill=X)
    tk.Button(FIN, text="Summoner's Rift", command=Summoner, font=20).pack(fill=X)
    tk.Button(FIN, text="All Random All Mid", command=ARAM, font=20).pack(fill=X)
    FIN.mainloop()
def Twisted():
        nomf = nomin.get()
        password = paswin.get()
        LOLICON = None
        while LOLICON is None:
            LOLICON = pyautogui.locateOnScreen("LOLICON.PNG")
        LOLICON2 = pyautogui.center(LOLICON)
        LOLICON3 = pyautogui.click(LOLICON2)
        NAMEIN = None
        while NAMEIN is None:
            NAMEIN = pyautogui.locateOnScreen("NAMEIN.PNG")
        NAMEIN2 = pyautogui.center(NAMEIN)
        NAMEIN3 = pyautogui.click(NAMEIN2)
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.typewrite(nomf)
        pyautogui.press("tab")
        pyautogui.typewrite(password)
        LOG = None
        while LOG is None:
            LOG = pyautogui.locateOnScreen("LOG.PNG")
        LOG2 = pyautogui.center(LOG)
        LOG3 = pyautogui.click(LOG2)
        PLAY = None
        while PLAY is None:
            PLAY = pyautogui.locateOnScreen("PLAY.PNG")
        PLAY2 = pyautogui.center(PLAY)
        PLAY3 = pyautogui.click(PLAY2)
        TT = None
        while TT is None:
            TT = pyautogui.locateOnScreen("TT.PNG")
        TT2 = pyautogui.center(TT)
        TT3 = pyautogui.click(TT2)
        CONF = None
        while CONF is None:
            CONF = pyautogui.locateOnScreen("CONF.PNG")
        CONF2 = pyautogui.center(CONF)
        CONF3 = pyautogui.click(CONF2)
        FM = None
        while FM is None:
            FM = pyautogui.locateOnScreen("FM.PNG")
        FM2 = pyautogui.center(FM)
        FM3 = pyautogui.click(FM2)
def Summoner():
        nomf = nomin.get()
        password = paswin.get()
        LOLICON = None
        while LOLICON is None:
            LOLICON = pyautogui.locateOnScreen("LOLICON.PNG")
        LOLICON2 = pyautogui.center(LOLICON)
        LOLICON3 = pyautogui.click(LOLICON2)
        NAMEIN = None
        while NAMEIN is None:
            NAMEIN = pyautogui.locateOnScreen("NAMEIN.PNG")
        NAMEIN2 = pyautogui.center(NAMEIN)
        NAMEIN3 = pyautogui.click(NAMEIN2)
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.typewrite(nomf)
        pyautogui.press("tab")
        pyautogui.typewrite(password)
        LOG = None
        while LOG is None:
            LOG = pyautogui.locateOnScreen("LOG.PNG")
        LOG2 = pyautogui.center(LOG)
        LOG3 = pyautogui.click(LOG2)
        PLAY = None
        while PLAY is None:
            PLAY = pyautogui.locateOnScreen("PLAY.PNG")
        PLAY2 = pyautogui.center(PLAY)
        PLAY3 = pyautogui.click(PLAY2)
        CONF = None
        while CONF is None:
            CONF = pyautogui.locateOnScreen("CONF.PNG")
        CONF2 = pyautogui.center(CONF)
        CONF3 = pyautogui.click(CONF2)
        FM = None
        while FM is None:
            FM = pyautogui.locateOnScreen("FM.PNG")
        FM2 = pyautogui.center(FM)
        FM3 = pyautogui.click(FM2)
def ARAM():
        nomf = nomin.get()
        password = paswin.get()
        LOLICON = None
        while LOLICON is None:
            LOLICON = pyautogui.locateOnScreen("LOLICON.PNG")
        LOLICON2 = pyautogui.center(LOLICON)
        LOLICON3 = pyautogui.click(LOLICON2)
        NAMEIN = None
        while NAMEIN is None:
            NAMEIN = pyautogui.locateOnScreen("NAMEIN.PNG")
        NAMEIN2 = pyautogui.center(NAMEIN)
        NAMEIN3 = pyautogui.click(NAMEIN2)
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.press("backspace")
        pyautogui.typewrite(nomf)
        pyautogui.press("tab")
        pyautogui.typewrite(password)
        LOG = None
        while LOG is None:
            LOG = pyautogui.locateOnScreen("LOG.PNG")
        LOG2 = pyautogui.center(LOG)
        LOG3 = pyautogui.click(LOG2)
        PLAY = None
        while PLAY is None:
            PLAY = pyautogui.locateOnScreen("PLAY.PNG")
        PLAY2 = pyautogui.center(PLAY)
        PLAY3 = pyautogui.click(PLAY2)
        ARAM = None
        while ARAM is None:
            ARAM = pyautogui.locateOnScreen("ARAM.PNG")
        ARAM2 = pyautogui.center(ARAM)
        ARAM3 = pyautogui.click(ARAM2)
        CONF = None
        while CONF is None:
            CONF = pyautogui.locateOnScreen("CONF.PNG")
        CONF2 = pyautogui.center(CONF)
        CONF3 = pyautogui.click(CONF2)
        FM = None
        pyautogui.click()
        # while FM is None:
        #     FM = pyautogui.locateOnScreen("FM.PNG")
        # FM2 = pyautogui.center(FM)
        # FM3 = pyautogui.click(FM2)
def paswsaver():
    global DATA
    nomf = nomin.get()
    password = paswin.get()
    if not os.path.exists(DATA):
        os.makedirs(DATA)
    data = open("C:\LauncherLOL\LolLauncherData.txt","w")
    data.write(nomf)
    data.write("\n")
    data.write(password)
    data.close()
def recordar():
    global tnom
    global tpass
    inf = open("C:\LauncherLOL\LolLauncherData.txt","r")
    datan = inf.readline()
    py.moveRel(0,-60)
    py.click()
    py.typewrite(datan)
    inf.close()
SIGN = tk.Tk()
SIGN.title("Log In")
SIGN.geometry("720x85+400+400")
nomin = StringVar(SIGN)
paswin = StringVar(SIGN)
tnom = tk.Entry(SIGN, textvar=nomin, font=20).grid(row=1, column=1)
tpass = tk.Entry(SIGN, textvar=paswin, show="*", font=20).grid(row=2, column=1)
nom = tk.Label(SIGN, text="Username", font=20).grid(row=1, column=2)
pasw = tk.Label(SIGN, text="Password", font=20).grid(row=2, column=2)
log = tk.Button(SIGN, text="Log In", command=main, font=20).grid(row=3, column=2)
renovar = tk.Button(SIGN, text="Saved Username", command=recordar, font=20).grid(row=3, column=1)
tk.Label(SIGN, font=('Helvetica', 20), text="App Designed by Alberto Dos Santos\n Version 1.2", bg="light green", fg="blue").grid(row=1, rowspan=3, column=3)
SIGN.mainloop()
