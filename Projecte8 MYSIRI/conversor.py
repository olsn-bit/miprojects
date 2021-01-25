import tkinter as tk
import tkinter.messagebox as messagebox
#from Tkinter import Messagebox

def conversor():
    global numero
    root = tk.Tk()
    root.title("Conversor Km a Milles")
    root.geometry("280x100+100+50")
    tk.Label(root,relief="solid", text='Introdueix abaix un nombre:', fg='black', font=10).pack()
    numero = tk.StringVar(root)
    tk.Entry(root, textvar=numero).pack()
    tk.Label(text="Km") .pack()
    tk.Button(root, text='Convertir', fg="black", font=12,
              bg="light green", command=varconv).pack(side=tk.BOTTOM, fill=tk.X)
    root.mainloop()


def varconv():
    soca = int(numero.get())
    trica = soca *0.621
    messagebox.showinfo("Resultat en Milles = ", trica)
