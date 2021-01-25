import requests
import time
abc = ['','a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
abcvar = 1
abcvar2 = 0
abcvar3 = 0
abcvar4 = 0
abcvar5 = 0
abcvar6 = 0
Running = True
while Running:

    trywww = "https://www."+abc[abcvar]+abc[abcvar2]+abc[abcvar3]+abc[abcvar4]+abc[abcvar5]+abc[abcvar6]+".com"

    print('Provando ',trywww)
    try:
        r = requests.get(trywww)
        rstatus = r.status_code
        print('Codigo recibido = ',rstatus)
        if rstatus == 200:
            print('Si que existe, guardando ...')
            truewww = trywww
            oldtxt = open('webpages.txt','r')
            oldtxtr = oldtxt.read()
            oldtxtr.split(',')
            writetxt = open('webpages.txt','w')
            writetxt.write(oldtxtr)
            writetxt.write(('\n' +str(truewww)))
            print('Guardado ',trywww)
            abcvar += 1
            oldtxt.close()
            writetxt.close()

    except requests.exceptions.ConnectionError:
        print('No existe o no funciona')
        abcvar += 1



    if abcvar == len(abc):

        abcvar = 0
        abcvar2 += 1

    if abcvar2 == len(abc):

        abcvar = 0
        abcvar2 = 0
        abcvar3 += 1

    if abcvar3 == len(abc):

        abcvar = 0
        abcvar2 = 0
        abcvar3 = 0
        abcvar4 += 1

    if abcvar4 == len(abc):

        abcvar = 0
        abcvar2 = 0
        abcvar3 = 0
        abcvar4 = 0
        abcvar5 += 1

    if abcvar5 == len(abc):
        abcvar = 0
        abcvar2 = 0
        abcvar3 = 0
        abcvar4 = 0
        abcvar5 = 0
        abcvar6 += 1
    if abcvar6 == len(abc):
        Running = False
