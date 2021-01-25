
import os
import getpass
archius = "keydata"
if not os.path.exists(archius):
        os.makedirs(archius)
usernamecorrect = False
working = True
while working:

    print("Write 'S' to Sign In and 'L' to Log In")
    mains = input("")


    if mains.lower() == 's':
        nomsl = open("keydata/noms.txt","r",)
        nomslr = nomsl.read().split(',')
        nomsvells = open("keydata/noms.txt","w",)
        #usuarios = [lecturanomsvells]
        contresl = open("keydata/contres.txt","r",)
        contreslr = contresl.read().split(',')
        contresvelles = open("keydata/contres.txt","w",)
        print("_________________________________________________________")
        print("Create a Username")

        nomintroduit = input("")
        nomnou = nomintroduit.replace(' ','')
        print("_________________________________________________________")
        print("Create a Password for: "+nomnou)
        contranova = getpass.getpass()
        Dades = True
        Dades2 = True
        contrasenya = len(contreslr)
        nombre = len(nomslr)
        #if nombre == 0:
        #    nombre = +1
        if contrasenya != 0:
            contrasenya = contrasenya -1
        while Dades2:

            contresvelles.write(",")
            contresvelles.writelines(contreslr[contrasenya])
            contrasenya = contrasenya - 1
            if contrasenya == -1:
                Dades2 = False

        contresvelles.write(contranova)

        if nombre != 0:
            nombre = nombre -1
        while Dades:

            nomsvells.write(",")
            nomsvells.writelines(nomslr[nombre])
            nombre = nombre - 1
            if nombre == -1:
                Dades = False

        nomsvells.write(nomnou)
        archiuobert = [nomsl,nomsvells,contresl,contresvelles]
    if mains.lower() == 'l':
        nomsl = open("keydata/noms.txt","r",)
        nomslr = nomsl.read().split(',')
        contresl = open("keydata/contres.txt","r",)
        contreslr = contresl.read().split(',')
        print("_________________________________________________________")
        print("Put your username")

        nomintroduit = input("")
        nomverify = nomintroduit.replace(' ','')

        print("_________________________________________________________")
        contraverify = getpass.getpass()
        try:
            nomslr.index(nomverify)
            namecheck = nomslr.index(nomverify)

        except ValueError:
            print('\n\n\nUsername or password is incorrect\n\n\n')

        if usernamecorrect == True:
            namecheck = nomslr.index(nomverify)



        if contreslr[namecheck] == contraverify:

                print('\n\n\nWelcome ',nomverify)
                working = False

        elif nomverify is not nomslr:
            print('\n\n\nUsername or password is incorrect\n\n\n')
        archiuobert = [nomsl,contresl]

    for e in archiuobert:
        e.close()
