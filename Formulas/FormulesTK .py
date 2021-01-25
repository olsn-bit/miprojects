from tkinter import*
ventana_añadir = Tk()
    ventana_añadir.title("Anadir un Usuario")
    ventana_añadir.geometry("550x200+600+250")
    ventana_añadir.resizable(width=False, height=False)
    nombre = StringVar()
    apellido = StringVar()
    id = StringVar()
    edad = StringVar()
    salario = StringVar()
    seleccion = Label(ventana_añadir, text = "Añadir Nueva Entrada", font = ("Times", 25)).place(x = 100, y = 10)
    Nombre_Label = Label(ventana_añadir, text = "Nombre ").place(x= 39, y = 70)
    Apellido_Label = Label(ventana_añadir, text = "Apellidos ").place(x = 239, y = 70)
    Edad_Label= Label(ventana_añadir, text = "Edad").place(x = 37, y = 110)
    Salario_Label = Label(ventana_añadir, text = "Salario").place(x = 100, y = 110)
    Nombre_Entry = Entry(ventana_añadir, textvariable = nombre, width = 30).place(x = 40, y = 90)
    Apellido_Entry = Entry(ventana_añadir, textvariable = apellido, width = 45).place(x = 240, y = 90)
    Edad_Spinbox = Spinbox(ventana_añadir, textvariable = edad, from_ = 10 , to = 99, state = "readonly", width = 5).place(x = 40, y = 130)
    Salario_Entry = Entry(ventana_añadir, textvariable = salario, width = 15).place(x = 100, y = 130)
    Añadir_Button = Button(ventana_añadir, text = "Añadir", font = ("Helvetica", 18),command = lambda: verificar_datos(str(nombre.get()), str(apellido.get()), str(edad.get()), str(salario.get()))).place(x = 240 , y = 120)
    ID_Label = Label(ventana_añadir, text = "ID").place(x = 39, y = 150 )
    ID_Entry = Entry(ventana_añadir, textvariable = id, state = "readonly").place(x = 40, y = 170)
    #Tkinter
    from tkinter import* #formula obliigada al fer algo en tk
    quadro = Tk()#crear una finestra
       quadro.title("titol del quadro")
       quadro.geometry("XXXxXXX+XXX+XX")
    nom = Checkbutton()
    titol = Label()
    bore ke es LabelFrame
    objecte.grid (row=x, column=x)
    for element in x:
        print(element)
        total = total + element
    button
    canvas
    checkbutton
    combobox
    entry
    frame
    label
    labelframe
    listbox
        listbox.delete(0, END)
        listbox.insert(END, newitem)
    menu
    menubutton
    message
    notebook
    tk_optionMenu
    panedwindow
    progressbar
    radiobutton
    scale
    scrollbar
    separator
    sizegrip
    spinbox
    text
    treeview
    It provides the following top-level windows:
    tk_chooseColor - pops up a dialog box for the user to select a color.
    tk_chooseDirectory - pops up a dialog box for the user to select a directory.
    tk_dialog - creates a modal dialog and waits for a response.
    tk_getOpenFile - pops up a dialog box for the user to select a file to open.
    tk_getSaveFile - pops up a dialog box for the user to select a file to save.
    tk_messageBox - pops up a message window and waits for a user response.
    tk_popup - posts a popup menu.
    toplevel - creates and manipulates toplevel widgets.
        Tk also provides three geometry managers:
        place - which positions widgets at absolute locations
        grid - which arranges widgets in a grid
        pack - which packs widgets into a cavity
    botó = Button()
    quadre de text = Entry()
        #coses pa posar dins de tkinter
        text=("text")
        fg="black"#color de lletra
        font=13
        bg="color de fondo del quadro en ingles"
        command=cosa que pasa quan actives al botó#nomes boto
    .pack() .pack(fill=X)
        side = RIGHT #costat on vols posar lobjecte
    quadro de messatge se te ke posar aixo
    from tkinter import messagebox
    messagebox.showerror("Error", "Error message")
    messagebox.showwarning("Warning","Warning message")
    messagebox.showinfo("Information","Informative message")
    #sempre al acabar algo en tk tens ke posar
    quadro.mainloop()

    #Exemple
    import tkinter as tk
    root = tk.Tk()
    root.geometry('600x400+80+40')

    class App:
        def __init__(self, root):
            self.entry_var = tk.StringVar()
            self.entry = tk.Entry(root, textvariable=self.entry_var)
            self.entry.bind('<Return>', self.show_output)
            self.entry.pack()

        def show_output(self, event):
            print(self.entry_var.get())

    App(root)
    tk.mainloop()
