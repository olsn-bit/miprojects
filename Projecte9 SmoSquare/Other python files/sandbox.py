from pyautogui import*
import pyautogui, sys
from tkinter import*
import tkinter as tk
 
 
def apretat():
    x, y = pyautogui.position()
    supx = str(x).rjust(4)
    supy = str(y).rjust(4)
    positionStr = '    riu1 = pygame.draw.rect(finestra, (verd),(' + supx + ', ' + supy + ',32,32))\n'
    print(positionStr, end='')
    #print('\b' * len(positionStr), end='', flush=True)
    cordes = open("datacordes .txt","w")
    cordes.write("\n")
    cordes.write(supx)
    cordes.write(supy)
    cordes.close()
quadro = tk.Tk()
quadro.title("Coordenades")
quadro.geometry("200x25+100+20")
quadro.attributes("-alpha", 0.5)
tk.Button(text="Mirar", command=apretat, height = 1000, width = 1000) .pack()
 
quadro.mainloop()