
from tkinter import *
import tkinter as tk
import os
import webbrowser
global whattoexe
whattoexe = ["","","",""]
def checker():
    if CheckKan.get() == 1:
        whattoexe[1] = websites[1]
    else:
        whattoexe[1] = ""
    if CheckMoodle.get() == 1:
        whattoexe[3] = websites[3]
    else:
        whattoexe[3] = ""
    if CheckDrive.get() == 1:
        whattoexe[0] = websites[0]
    else:
        whattoexe[0] = ""
    if CheckEmail.get() == 1:
        whattoexe[2] = websites[2]
    else:
        whattoexe[2] = ""
def m04fun():
    global websites
    websites = ["https://www.drive.google.com","https://www.kanbanflow.com","https://www.gmail.com","http://moodle.iesmontsia.org/course/view.php?id=207"]

    checker()
    print(whattoexe,websites)
    for url in whattoexe:
        if url == "":
            pass
        else:
            webbrowser.open(url)
def m06fun():
    global websites
    websites = ["https://www.drive.google.com","https://www.kanbanflow.com","https://www.gmail.com","https://moodle.iesmontsia.org/course/view.php?id=217"]
    checker()
    print(whattoexe,websites)
    for url in whattoexe:
        if url == "":
            pass
        else:
            webbrowser.open(url)
def m07fun():
    global websites
    websites = ["https://www.drive.google.com","https://www.kanbanflow.com","https://www.gmail.com","https://moodle.iesmontsia.org/course/view.php?id=240"]
    checker()
    print(whattoexe,websites)
    for url in whattoexe:
        if url == "":
            pass
        else:
            webbrowser.open(url)
def m08fun():
    global websites
    websites = ["https://www.drive.google.com","https://www.kanbanflow.com","https://www.gmail.com","https://moodle.iesmontsia.org/course/view.php?id=266"]
    checker()
    print(whattoexe,websites)
    for url in whattoexe:
        if url == "":
            pass
        else:
            webbrowser.open(url)
def eiefun():
    global websites
    websites = ["https://www.drive.google.com","https://www.kanbanflow.com","https://www.gmail.com","https://moodle.iesmontsia.org/course/view.php?id=220"]
    checker()
    print(whattoexe,websites)
    for url in whattoexe:
        if url == "":
            pass
        else:
            webbrowser.open(url)
def entfun():
    websites = ["https://www.soundcloud.com","https://www.youtube.com","https://www.9gag.com"]
    for url in websites:
        webbrowser.open(url)
def main():
    global CheckKan,CheckEmail,CheckMoodle,CheckDrive
    mainwindow = tk.Tk()
    # ios = "win"
    ios = "linux"
    CheckMoodle = IntVar(mainwindow)
    CheckKan = IntVar(mainwindow)
    CheckEmail = IntVar(mainwindow)
    CheckDrive = IntVar(mainwindow)
    mainwindow.title("Browser Tab Organizer")
    if ios == "win":
        buttonswidth = 43
        mainwindow.geometry("1000x380+600+250")
    else:
        buttonswidth = 39
        mainwindow.geometry("1000x370+600+250")
    mainwindow.resizable(width=False, height=False)
    title = Label(mainwindow, text = "Select Class", font = ("Times", 25)).grid(row=1,column=2,)
    credits = Label(mainwindow, text = "App Designed by Alberto Dos Santos", font = ("Times", 9),bg="light grey").grid(row=1,column=3,)
    m4but = Button(text="M04",command=m04fun,width=buttonswidth,height=5,bg="pink").grid(row=2,column=1)
    m6but = Button(text="M06",command=m06fun,width=buttonswidth,height=5,bg="light green").grid(row=2,column=2)
    m7but = Button(text="M07",command=m07fun,width=buttonswidth,height=5,bg="light blue").grid(row=2,column=3)
    m8but = Button(text="M08",command=m08fun,width=buttonswidth,height=5,bg="grey").grid(row=3,column=1)
    eiebut = Button(text="EIE",command=eiefun,width=buttonswidth,height=5,bg="yellow").grid(row=3,column=2)
    entrbut = Button(text="Entretainment",command=entfun,width=buttonswidth,height=5,bg="red").grid(row=3,column=3)
    Checkbutton(variable=CheckMoodle,text="Moodle",width=buttonswidth,height=5,bg="light grey").grid(row=4,column=1)
    Checkbutton(variable=CheckDrive,text="Drive",width=buttonswidth,height=5,bg="light grey").grid(row=4,column=2)
    Checkbutton(variable=CheckKan,text="KanBanFlow",width=buttonswidth,height=5,bg="light grey").grid(row=4,column=3)
    Checkbutton(variable=CheckEmail,text="E-mail",width=buttonswidth,height=5,bg="light grey",).grid(row=5,column=2)

    tk.mainloop()

main()
