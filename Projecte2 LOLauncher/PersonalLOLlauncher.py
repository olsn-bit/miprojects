import pyautogui as py
from tkinter import*
import tkinter as tk
import os
import subprocess
import pyautogui
DATA = "C:\LauncherLOL"
def main():
    password = '4987235892alto'

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
        subprocess.Popen('C:\Riot Games\League of Legends\LeagueClient.exe')
        pas = None
        while pas is None:
            pas = py.locateCenterOnScreen("TINPUT.PNG")
        py.click(pas)
        pyautogui.typewrite('4987235892alto')
        LOG = None
        while LOG is None:
            LOG = pyautogui.locateCenterOnScreen("LOG.PNG")
        pyautogui.click(LOG)
        PLAY = None
        while PLAY is None:
            PLAY = pyautogui.locateCenterOnScreen("PLAY.PNG")
        pyautogui.click(PLAY)
        ARAM = None
        while ARAM is None:
            ARAM = pyautogui.locateCenterOnScreen("ARAM.PNG")
        pyautogui.click(ARAM)
        CONF = None
        while CONF is None:
            CONF = pyautogui.locateCenterOnScreen("CONF.PNG")
        pyautogui.click(CONF)
        FM = None
        while FM is None:
            FM = py.locateCenterOnScreen('FM.PNG')
        pyautogui.click(FM)
        PLAYGAME = None
        while PLAYGAME is None:
            PLAYGAME = py.locateCenterOnScreen("ACEPTARPARTIDA.PNG")
        py.click(PLAYGAME)
main()
