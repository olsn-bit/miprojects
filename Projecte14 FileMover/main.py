import os,subprocess
def main():
    dirlist = os.listdir("/home/alumne/Descargas")
    dirm4 = "/home/alumne/Dropbox/M4"
    dirm6 = "/home/alumne/Dropbox/M06"
    dirm7 = "/home/alumne/Dropbox/M7"
    dirm8 = "/home/alumne/Dropbox/m8"
    m4 = ["M04","m4","M4","m04"]
    m6 = ["M06","m6","M6","m06"]
    m7 = ["M07","m7","M7","m07"]
    m8 = ["M08","m8","M8","m08"]

    for dirthings in dirlist:
        for m4things in m4:
            if m4things in dirthings:
                llocpanvia = "mv","/home/alumne/Descargas/"+dirthings," ",dirm4
                subprocess.Popen(llocpanvia)
        for m6things in m6:
            if m6things in dirthings:
                llocpanvia = "mv","/home/alumne/Descargas/"+dirthings," ",dirm6
                subprocess.Popen(llocpanvia)
        for m7things in m7:
            if m7things in dirthings:
                llocpanvia = "mv","/home/alumne/Descargas/"+dirthings," ",dirm7
                subprocess.Popen(llocpanvia)
        for m8things in m8:
            if m8things in dirthings:
                llocpanvia = "mv","/home/alumne/Descargas/"+dirthings," ",dirm8
                subprocess.Popen(llocpanvia)
main()
