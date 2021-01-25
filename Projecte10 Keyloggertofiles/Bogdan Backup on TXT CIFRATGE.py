
import os
import getpass
archius = "keydata"
if not os.path.exists(archius):
        os.makedirs(archius)



def start():
    cifratgell = 0
    datapassverify = ''
    descifratedlist = []
    descifrantll = 0
    cifrant = True
    descifrant = True
    nombre = 0
    contrasenya = 0
    working = True
    cifratgeotreblaotrebla = [2,1,6,4,9,3,8,7,5,0,'!','.','-','@','%','&','/','(',')','=','?','¿','_','ç','+','⁺']
    abecedari = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
    usernamecorrect = False
    print("Write 'S' to Sign In and 'L' to Log In")
    mains = input("")


    if mains.lower() == 's':
        nomsl = open("keydata/noms.txt","r",)
        nomslr = nomsl.read().split(',')
        nomsvells = open("keydata/noms.txt","w",)
        contresl = open("keydata/contres.txt","r",)
        contreslr = contresl.read().split(',')
        contresvelles = open("keydata/contres.txt","w",)
        print("_________________________________________________________")
        print("Create a Username")

        nomintroduit = input("")
        nomnou = nomintroduit.replace(' ','')
        print("_________________________________________________________")
        print("Create a Password for: "+nomintroduit)
        contranova = getpass.getpass()
        Dades2 = True
        Dades = True
        contralen = len(contreslr)
        nomslen = len(nomslr)

        while Dades2:
            contresvelles.writelines(contreslr[contrasenya])
            contresvelles.write(",")
            contrasenya += 1
            if contrasenya == contralen:
                Dades2 = False


        while cifrant:
            i = abecedari.index(str(contranova[cifratgell]))
            contresvelles.write(str(cifratgeotreblaotrebla[i]))
            cifratgell += 1
            if cifratgell == len(contranova):
                cifrant = False

        while Dades:

            nomsvells.writelines(nomslr[nombre])
            nomsvells.write(",")
            nombre += 1
            if nombre == nomslen:
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
            namecheck = nomslr.index(nomverify)

        except ValueError:
            print('\n\n\nUsername is incorrect\n\n\n')


        while descifrant:#contraverify[descifrantll]
            i = abecedari.index(contraverify[descifrantll])
            descifratedlist.append(str(cifratgeotreblaotrebla[i]))
            descifrantll += 1
            if descifrantll == len(contraverify):
                descifrant = False
        datapassverify = datapassverify.join(descifratedlist)
        if datapassverify in contreslr[namecheck
        ]:
            print('\n\n\nWelcome '+nomintroduit)
        else:
            print('\n\n\nUsername or Password is incorrect\n\n\n')

        archiuobert = [nomsl,contresl]

    for e in archiuobert:
        e.close()
start()
