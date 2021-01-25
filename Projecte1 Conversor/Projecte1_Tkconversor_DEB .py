import tkinter as tk
from tkinter import messagebox

def conversor():
    global numero
    root = tk.Tk()
    root.title("Conversor Km a Mi")
    root.geometry("380x170+100+50")
    tk.Label(root,relief="solid", text='Conversor de Km a Mi', fg='black', font=10).pack()
    numero = tk.IntVar(root)
    tk.Entry(root, textvar=numero).pack(fill=tk.X)
    tk.Button(root, text='Convertir', fg="black", font=12,
              bg="light green", command=varconv).pack(side=tk.TOP, fill=tk.X)
    tk.Label(root, text="TruftedBug89 S.A\n Fet per Alberto Dos Santos \n Copyright 2018") .pack()
    root.mainloop()


def varconv():
    soca = int(numero.get())
    messagebox.showinfo("Resultado", soca *0.621)

conversor()
