import tkinter as tk
from tkinter import*
import time
hora = [0,0,0]
def contador():
    if (funciona):
        global hora
        hora[2] +=1
        if (hora[2] >= 100):
            hora[2] = 0
            hora[1] += 1

        if (hora[1] >= 60):
            hora[0] += 1
            hora[1] = 0
        timeString = str(hora[0]) + ':' + str(hora[1]) + ':' + str(hora[2])
        show.config(text=timeString)
    root.after(10, contador)
def pausa():
    global funciona
    funciona = False
def dale():
    global funciona
    funciona = True
funciona = False
########################
root = tk.Tk()
root.title("Rellotge")
root.geometry("350x70")
########################
show = tk.Label(root, text='0:0:0', font=('Helvetica', 40))
show.pack( side = LEFT )
boto = tk.Button(root, text="Start", command = dale, font=('Helvetica', 20)).pack(side=RIGHT, fill=Y)
botop = tk.Button(root, text="Stop", command = pausa, font=('Helvetica', 20)).pack(side=RIGHT, fill=Y)
contador()
root.mainloop()
