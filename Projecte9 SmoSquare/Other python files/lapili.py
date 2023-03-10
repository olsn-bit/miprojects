import tkinter as tk
from tkinter import *
root = tk.Tk()
root.title('gcalculator')
root.geometry('360x335')
root.resizable(width=False,height=False )
main= tk.Entry(font=('Helvetica', '25', 'bold')) .grid(row=1, column=1, columnspan=5)
main.insert(0,'0')
###
tk.Button(root, text='C', width=5, height=3) .grid(row=2, column=3)
tk.Button(root, text='AC', width=5, height=3).grid(row=2, column=4)
tk.Button(root, text='.', width=5, height=2).grid(row=7, column=2)
tk.Button(root, text='+/-', width=5, height=2).grid(row=7, column=3)
tk.Button(root, text='<-', width=5, height=3).grid(row=2, column=5)
tk.Button(root, text='+', width=5, height=2).grid(row=7, column=4)
tk.Button(root, text='=', height=5, width=5).grid(row=6, column=5, rowspan=2)
tk.Button(root, text='9', width=5, height=2).grid(row=4, column=3)
tk.Button(root, text='8', width=5, height=2).grid(row=4, column=2)
tk.Button(root, text='7', width=5, height=2).grid(row=4, column=1)
tk.Button(root, text='6', width=5, height=2).grid(row=5, column=3)
tk.Button(root, text='5', width=5, height=2).grid(row=5, column=2)
tk.Button(root, text='4', width=5, height=2).grid(row=5, column=1)
tk.Button(root, text='3', width=5, height=2).grid(row=6, column=3)
tk.Button(root, text='2', width=5, height=2).grid(row=6, column=2)
tk.Button(root, text='1', width=5, height=2).grid(row=6, column=1)
tk.Button(root, text='0', width=5, height=2).grid(row=7, column=1)
tk.Button(root, text='%', width=5, height=2).grid(row=5, column=5)
tk.Button(root, text='sqrt', width=5, height=2).grid(row=4, column=5)
tk.Button(root, text=')', width=5, height=2).grid(row=3, column=2)
tk.Button(root, text='(', width=5, height=2).grid(row=3, column=1)
tk.Button(root, text='/', width=5, height=2).grid(row=4, column=4)
tk.Button(root, text='*', width=5, height=2).grid(row=5, column=4)
tk.Button(root, text='-', width=5, height=2).grid(row=6, column=4)
tk.OptionMenu(root, 'MS','..') .grid(row=3, column=3)
tk.OptionMenu(root, 'MR','..') .grid(row=3, column=4)
tk.OptionMenu(root, 'M+','..') .grid(row=3, column=5)
menu = Menu(root)
filafile = Menu(menu, tearoff=0)
filaedit = Menu(menu, tearoff=0)
filaview = Menu(menu, tearoff=0)
filacalc = Menu(menu, tearoff=0)
filahelp = Menu(menu, tearoff=0)
filafile.add_command(label="Close")
menu.add_cascade(label="File", menu= filafile)
filaedit.add_command(label="Close")
menu.add_cascade(label="Edit", menu= filaedit)
filaview.add_command(label="Close")
menu.add_cascade(label="View", menu= filaview)
filacalc.add_command(label="Close")
menu.add_cascade(label="Calculator", menu= filacalc)
filahelp.add_command(label="Close")
menu.add_cascade(label="Help", menu= filahelp)
root.config(menu=menu)
root.mainloop()