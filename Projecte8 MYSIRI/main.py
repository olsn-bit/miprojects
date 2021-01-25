from playsound import playsound
import webbrowser
global word
import conversor
import smosquare
import os
def clear():
    print("\n" * 100)
    os.system('cls')
clear()
nombre = ''
talk = ''
nombrepre = False#nombre preguntado
nombreinp = False#saludar por el nombre una vez definido el input
wwwsearch = False
normaltalk = True
wwwASK = False#esto define que pasa cuando le pregunta si quiere que busque algo
#Funciones
#Data
saludos = ['hola','buenas']
comoestas = ['bien','mal']
while True:
    var = 0
    varBool = True
    word = 'no te entiendo, escribe help'
    print(normaltalk)
    print(nombreinp)
    print(talk)
    print(nombre)
    if normaltalk == True:
        talk = input()
    if nombreinp == True:
        talk = ''
        nombre = input()
        word = 'encantado ' + nombre + ' quieres que busque algo?'
        #wwwASK()
    if wwwsearch == True:
        www = input('Ire a https://www.')
        wwwsearch = False
        URL = 'https://www.'+www
        webbrowser.open(URL)
        wwwsearch = False
        normaltalk = True
    def wwwASK():

        wwwASKI = input()
        if 'si' in wwwASKI:
            word = 'escribe el nombre de la pagina que quieras buscar'
            wwwsearch = True
        if 'no' in wwwASKI:
            word = 'ok, que quieres hacer?'
            normaltalk = True
            wwwASK = False
        else:
            normaltalk = True

    if talk == 'help':
        print('Funciones:\nMirar videos:videos\nPoner Música:musica\nNavegar:www\nConversor:conversor\nJuego:smosquare')
        word = 'Estas son todas por ahora'

    if talk in saludos :
        word = 'hola buenos dias como estas?'
    if talk in comoestas:
        word = 'me alegro, i como te llamas?'
        normaltalk = False
        nombreinp = True


    if talk == 'musica':
        word = 'ok, te llevo a soundcloud'
        webbrowser.open('https://www.soundcloud.com')
    if talk == 'videos':
        word = 'ok, te llevo a youtube'
        webbrowser.open('https://www.youtube.com')
    if talk == 'www':
        wwwASK = True
        #print('\n\n\n\n\nescribe help para ayuda')
    if talk == 'conversor':
        word = 'todo correcto?'
        conversor.conversor()
    if talk == 'smosquare':
        word = 'te lo has pasado bien?'
        smosquare.start()
        clear()
    if 'tonto' in talk:
        word = 'no digas eso hombre'

    wordfinal = word.replace(" ", "")
    wordfinal = wordfinal.replace("?","")
    wordfinal = wordfinal.replace(",","")
    wordfinal = wordfinal.replace("@","")
    wordfinal = wordfinal.replace(":","")
    wordfinal = wordfinal.replace("\n","")
    print(word)
    print('\n')
    while varBool:
        wordlist = list(wordfinal)
        wordp = wordlist[var] + '.wav'
        if var == (len(wordlist)-1):
            varBool = False
        wordp = wordlist[var] + '.wav'
        playsound(wordp)
        var += 1
