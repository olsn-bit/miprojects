from pygame.locals import*
from pygame import *
import pygame,sys,random,time
from pygame import time

import random
pygame.init()
############################################################################################################################
devmode = False
############################################################################################################################
#Notes de la versio 1.2
# Mes botos al menu i altres funcions (necessito models)
# Mode de joc                           (necessito info)
# Base de dades amb google api
# Mes habilitats per persona
# Splasharts
# Contador de morts
# Contador de temps
# Limit de mors per guanyar
# Apartat de configuracio al menu

#Coses que estic fent
#culdowns



##Colors
negre=0,0,0
blanc=255,255,255
roig=255,0,0
verd=0,255,0
blau=0,0,255
groc= 255,164,32

##Globalas
global movimentenpx
#Maestries


#Variables
maxhpp1 = 100
maxhpp2 = 100
habilitatondamal = 33
habilitatrayomal = 50
fpsset = 30
map = 3#5 el 6 es el meu
PJ1H1 = 'rayo'
PJ1H2 = None
PJ2H1 = 'onda'
PJ2H2 = None
oneplayereasy = False
oneplayerhard = True
winpoints = 0
winner = ''
habilitatqtirada = 0
credits = False
config = False
end = False
contadortemps = 0
minuts = 0
unminmes = 60
sombra = False
treuresombra = False
PXsombra = 0
PYsombra = 0
MaxWins = 1
PJ1Wins = 0
PJ2Wins = 0
ample=1250
alt=750
PJA = 1
PJA2 = 1
PX = 100
PY =350
PX2 = 1100
PY2 = 350
Energia = 100
HP = maxhpp1
Energia2 = 100
HP2 = maxhpp2
movimentenpx = 10
movimentenpx2 = 12
energiapermoviment = 0.5
PXH = 0
PXH2 = 0
PXH3 = 0
PXH4 = 0
PJH2_Altura = 0
CuraAva = True
CuraX= 350
CuraY= 100
fondoactivat = True
timee =2
CuraSpawn = 30
gamestart = False
intro = True
n1 = 1
n12 = -10
P2HT = 1
colorultidelp1 = roig
P1HNotAct = 0.1
rayolast = pygame.time.get_ticks()
bolalast = pygame.time.get_ticks()
cooldownbola = 1000
cooldownrayo = 2000

colormapa1 = roig
colormapa2 = roig
colorruna11 = roig
colorruna12 = roig
colorruna13 = roig
colorruna21 = roig
colorruna22 = roig
colorruna23 = roig = roig
colornolimitfps = roig
colorfullfps = roig
colorhalffps = roig
coloroneeasy = roig
coloronehard = roig
colortwop = roig

#INICIADORS SMOSQUARE

finestra = pygame.display.set_mode((ample,alt))
pygame.display.set_caption('Ecliono alpha1.3')
pygame.key.set_repeat(10,10)
clock = pygame.time.Clock()

#Imatges
#fondomenu = pygame.image.load('fondomenu.png')
#botomenu = pygame.image.load('botomenu.png')
fondo3 = pygame.image.load('Images/fondo3.png')
fondo4 = pygame.image.load('Images/fondo4.png')
fondo1 = pygame.image.load('Images/fondo1.png')
fondo2 = pygame.image.load('Images/fondo2.png')
fondo5 =pygame.image.load('Images/fondo5.png')
fondo6 = pygame.image.load('Images/squarefondo1.1.jpg')
PJ = pygame.image.load('Images/PJ.png')
PJ1 = pygame.image.load('Images/PJ1.png')
PJ2 = pygame.image.load('Images/PJ2.png')
PJ2x = pygame.image.load('Images/PJ2x.png')
PJ12 = pygame.image.load('Images/PJ12.png')
PJ22 = pygame.image.load('Images/PJ22.png')
#Fonts

twentytext = pygame.font.Font(None, 20)
fortytext = pygame.font.Font(None, 40)
twohundtext = pygame.font.SysFont('comicsansms',200)
onehundtext = pygame.font.SysFont('comicsansms',100)
fiftytext = pygame.font.SysFont('comicsansms',50)
seventytext = pygame.font.SysFont('comicsansms',70)
textmenu = twohundtext.render(' Ecliono',0,blau)
playbuttontext = seventytext.render('Play',0,negre)

#Objectes

#PJ2H = pygame.draw.rect(finestra,(roig),(PX2,PY2,50,PJH2_Altura))

PJH1D = pygame.draw.rect(finestra,(colorultidelp1),(PX,PY,(PXH),50))
PJH1D2 = pygame.draw.rect(finestra,(colorultidelp1),(PX+8,PY+12,25,(PXH2)))
PJH1D3 = pygame.draw.rect(finestra,(colorultidelp1),(PX+8,PY+12,(PXH3),25))
PJH1D4 = pygame.draw.rect(finestra,(colorultidelp1),(PX+8,PY+12,25,(PXH4)))

#Data

#funcions
def restartpositions():
    global PJ2HPY,PJ2HPX,PJ2HAreaX,PJ2HAreaY,PXH,PXH2,PXH3,PXH4,P1HNotAct,P2HT
    PJ2HPX =-100
    PJ2HPY =-100
    PJ2HAreaX = -100
    PJ2HAreaY = -100
    PXH = P1HNotAct
    PXH2 = P1HNotAct
    PXH3 = P1HNotAct
    PXH4 = P1HNotAct
    P2HT = 1
    PJH2_Altura = 0
def HabBola(x,y):
    global bolalast,cooldownbola,P2HT,PJ2HAreaX,PJ2HAreaY
    now = pygame.time.get_ticks()
    if now - bolalast >= cooldownbola:
        bolalast = now
        PJ2HAreaX = (x+20)
        PJ2HAreaY = (y+20)
        P2HT = 150
    else:
        pass
def Hab4rayos(x,y):
    global PJ2HPX,PJ2HPY,PXH,PXH2,PXH3,PXH4,rayolast,cooldownrayo
    now = pygame.time.get_ticks()
    if now - rayolast >= cooldownrayo:
        rayolast = now
        PJ2HPX =( PX+8)
        PJ2HPY = (PY+12)
        PXH = 1250
        PXH2 = 1250
        PXH3 = -1250
        PXH4 = -1250
        P1HNotAct = 0.1
        P2HT = 1
    else:
        pass
#datareadopen = open("smopersonaldata.txt","r",)
#dataread = datareadopen.readline()
#datawrite = open("smopersonaldata.txt","w",)


while True:
    if devmode == True:
        config = True
        gamestart = False
        intro = False
        fondoactivat = True
    while intro:
        #    finestra.blit(fondomenu,(0,0))
            for event in pygame.event.get():

                if event.type == pygame.QUIT:
                    pygame.quit()
                    quit()

            ratoliX,ratoliY = pygame.mouse.get_pos()
            if ratoliX == 1 and ratoliY == 740:
                Pass

            finestra.fill((n1,0,0))
            if n1  > 250:
                n12 = -1
            if n1 < 10:
                n12 = 1
            n1 += n12
        #    menubutton = finestra.blit(botomenu,(475,400))
            playbutton = pygame.draw.rect(finestra,(verd),((475,400),(300,100)))
            #contolsbutton = pygame.deaw.rect(finestra,(verd()))
            finestra.blit(textmenu,(200,112))
            finestra.blit(playbuttontext,(555,405))
            easteregg = pygame.draw.rect(finestra,(groc),((1,740),(1,1)))

            if event.type == pygame.MOUSEBUTTONDOWN:
                mouse_pos = event.pos
                if playbutton.collidepoint(mouse_pos):
                    intro = False
                    config = True
            pygame.display.flip()
    while credits:
        pass
    while config:
        print(map)
        finestra.fill(groc)
        for event in pygame.event.get():

            if event.type == pygame.QUIT:
                pygame.quit()
                quit()
        Conftitle = onehundtext.render('Configuration',1,negre)
        masteriestext = fiftytext.render('Masteries',1,negre)
        gamemodetext =  fiftytext.render('Mode Select',1,negre)
        otherconftext = fiftytext.render('Options',1,negre)
        finestra.blit(twentytext.render('Player 1',1,negre),(60,380))
        finestra.blit(twentytext.render('Player 2',1,negre),(60,480))
        finestra.blit(twentytext.render('Default',1,negre),(610,330))
        finestra.blit(twentytext.render('Nosek',1,negre),(610,480))
        finestra.blit(twentytext.render('oneplayer easy',1,negre),(910,330))
        finestra.blit(twentytext.render('oneplayer hard',1,negre),(1060,330))
        finestra.blit(twentytext.render('twoplayer',1,negre),(1010,430))
        finestra.blit(twentytext.render('fps limit',1,negre),(1010,530))
        #14
        finestra.blit(masteriestext,(150,250))
        finestra.blit(gamemodetext,(500,250))
        finestra.blit(otherconftext,(950,250))
        finestra.blit(Conftitle,(300,50))

        defaultmodebutton = pygame.draw.rect(finestra, colormapa1,((526, 359),(200,100)))
        nosekmodebutton = pygame.draw.rect(finestra, colormapa2,((526, 529),(200,100)))
        startbutton = pygame.draw.rect(finestra, negre,((526, 679),(200,100)))

        oneplayereasybutton = pygame.draw.rect(finestra, coloroneeasy,((930, 358),(50,50)))
        oneplayerhardbutton = pygame.draw.rect(finestra, coloronehard,((1084, 361),(50,50)))
        twoplayerbutton = pygame.draw.rect(finestra, colortwop,((1014, 458),(50,50)))

        movrunebuttonp2 = pygame.draw.rect(finestra, colorruna21,((162, 463),(50,50)))
        dmgrunebuttonp2 = pygame.draw.rect(finestra, colorruna22,((247, 463),(50,50)))
        hprunebuttonp2 = pygame.draw.rect(finestra, colorruna23,((335, 463),(50,50)))

        movrunebuttonp1 = pygame.draw.rect(finestra, colorruna11,((162, 372),(50,50)))
        dmgrunebuttonp1 = pygame.draw.rect(finestra, colorruna12,((247, 372),(50,50)))
        hprunebuttonp1 = pygame.draw.rect(finestra, colorruna13,((335, 372),(50,50)))

        fpsthreebutton =pygame.draw.rect(finestra, colorhalffps,((918, 571),(50,50)))
        fpssixbutton = pygame.draw.rect(finestra, colorfullfps,((1016, 571),(50,50)))
        fpsunlimitedbutt =pygame.draw.rect(finestra, colornolimitfps,((1110, 571),(50,50)))
        #defaultmodebutton = pygame.draw.rect()

        if event.type == pygame.MOUSEBUTTONDOWN:
            mouse_pos = event.pos
            if defaultmodebutton.collidepoint(mouse_pos):
                if map == 3:
                    colormapa2 = roig
                map = 6
                PX = 100
                PY = 700
                PX2 = 1100
                PY2 = 100
                colormapa1 = verd
            if nosekmodebutton.collidepoint(mouse_pos):
                if map == 6:
                    colormapa1 = roig
                PX = 100
                PY =350
                PX2 = 1100
                PY2 = 350
                map = 3
                colormapa2 = verd
            if startbutton.collidepoint(mouse_pos):
                config = False
                gamestart = True

            if oneplayereasybutton.collidepoint(mouse_pos):
                if coloronehard == verd:
                    coloronehard = roig
                elif colortwop == verd:
                    colortwop = roig
                oneplayereasy = True
                coloroneeasy = verd
            if oneplayerhardbutton.collidepoint(mouse_pos):
                if coloroneeasy == verd:
                    coloroneeasy = roig
                elif colortwop == verd:
                    colortwop = roig
                oneplayerhard = True
                coloronehard = verd
            if twoplayerbutton.collidepoint(mouse_pos):
                if coloronehard == verd or coloroneeasy == verd:
                    coloronehard = roig
                    coloroneeasy = roig

                oneplayerhard = False
                oneplayereasy = False
                colortwop = verd
            if fpsthreebutton.collidepoint(mouse_pos):
                if colorfullfps == verd:
                    colorfullfps = roig
                elif colornolimitfps == verd:
                    colornolimitfps = roig
                fpsset = 30
                colorhalffps = verd
            if fpssixbutton.collidepoint(mouse_pos):
                if colornolimitfps == verd:
                    colornolimitfps = roig
                elif colorhalffps == verd:
                    colorhalffps = roig
                fpsset = 60
                colorfullfps = verd
            if fpsunlimitedbutt.collidepoint(mouse_pos):
                if colorhalffps == verd:
                    colorhalffps = roig
                elif colorfullfps == verd:
                    colorfullfps = roig

                fpsset = 144
                colornolimitfps = verd
            if movrunebuttonp1.collidepoint(mouse_pos):
                if colorruna12 == verd:
                    colorruna12 = roig
                elif colorruna13 == verd:
                    colorruna13 = roig



                colorruna11 = verd
            if dmgrunebuttonp1.collidepoint(mouse_pos):
                if colorruna13 == verd:
                    colorruna13 = roig
                elif colorruna11 == verd:
                    colorruna11 = roig

                colorruna12 = verd
            if hprunebuttonp1.collidepoint(mouse_pos):
                if colorruna11 == verd:
                    colorruna11 = roig
                elif colorruna12 == verd:
                    colorruna12 = roig


                colorruna13 = verd
            if movrunebuttonp2.collidepoint(mouse_pos):
                if colorruna22 == verd:
                    colorruna22 = roig
                elif colorruna23 == verd:
                    colorruna23 = roig

                colorruna21 = verd
            if dmgrunebuttonp2.collidepoint(mouse_pos):
                if colorruna23 == verd:
                    colorruna23 = roig
                elif colorruna21 == verd:
                    colorruna21 = roig

                colorruna22 = verd
            if hprunebuttonp2.collidepoint(mouse_pos):
                if colorruna21 == verd:
                    colorruna21 = roig
                elif colorruna22 == verd:
                    colorruna22 = roig


                colorruna23 = verd

        pygame.display.update()

    while gamestart:
        if colorruna11 == verd:
            movimentenpx += 2
            colorruna11 = roig
        if colorruna12 == verd:
            habilitatrayomal += 10
            colorruna12 = roig
        if colorruna13 == verd:
            HP += 20
            maxhpp1 += 20
            colorruna13 = roig
        if colorruna21 == verd:
            movimentenpx2 += 2
            colorruna21 = roig
        if colorruna22 == verd:
            habilitatondamal += 10
            colorruna22 = roig
        if colorruna23 == verd:
            HP2 += 20
            maxhpp2 += 20
            colorruna23 = roig

        restartpositions()
        clock = pygame.time.Clock()
        clock.tick(fpsset)

        timer = pygame.time.get_ticks()/1000
        contadortemps += int(timer)
        if int(timer) == timee:
            timee += 1
        if timee > CuraSpawn:
            CuraAva = True
            CuraSpawn += 30
        if pygame.key.get_pressed()[pygame.K_d]:
            PX += movimentenpx
            Energia +=energiapermoviment
        if pygame.key.get_pressed()[pygame.K_a]:
            PX -= movimentenpx
            Energia +=energiapermoviment
        if pygame.key.get_pressed()[pygame.K_w]:

            PY -= movimentenpx
            Energia +=energiapermoviment
        if pygame.key.get_pressed()[pygame.K_s]:

            PY += movimentenpx
            Energia +=energiapermoviment
        if pygame.key.get_pressed()[pygame.K_e]:
            Hab4rayos(PX,PY)
        if oneplayereasy == False and oneplayerhard == False:
            if  pygame.key.get_pressed()[pygame.K_UP]:

                PY2 -=movimentenpx2
                Energia2 +=energiapermoviment


            if  pygame.key.get_pressed()[pygame.K_LEFT]:
                PX2 -= movimentenpx2

                Energia2 +=energiapermoviment

            if  pygame.key.get_pressed()[pygame.K_DOWN]:

                PY2 += movimentenpx2
                Energia2 +=energiapermoviment

            if  pygame.key.get_pressed()[pygame.K_RIGHT]:
                PX2 +=movimentenpx2
                Energia2 +=energiapermoviment

            if  pygame.key.get_pressed()[ pygame.K_KP_MULTIPLY]:
                HabBola(PX2,PY2)
        for e in pygame.event.get():
            if e.type == QUIT:
                pygame.quit()
                sys.exit()
            if e.type == pygame.KEYDOWN:
                pass
        #Objectes de fondo3
        finestra.fill(blau)
        PJO = pygame.draw.rect(finestra,(verd),((PX+10),(PY+10),35,35))
        PJO2 = pygame.draw.rect(finestra,(verd),((PX2+10),(PY2+10),35,35))
        if map == 4:

            base1 = pygame.draw.rect(finestra,(verd),(0,300,200,200))
            base2 = pygame.draw.rect(finestra,(verd),(1050,300,200,200))
            if PJO.colliderect(base1):
                HP = maxhpp1
                Energia = 100
            if PJO.colliderect(base2):
                HP = 0
                Energia = 0
            if PJO2.colliderect(base1):
                HP2 = 0
                Energia2 = 0

            if PJO2.colliderect(base2):
                HP2 = maxhpp2
                Energia2 = 100
            if fondoactivat == True:
                finestra.blit(fondo4,(0,0))
        if oneplayereasy == True and map != 6:


            if PX > 200:
                if PX2 in range(PX-150,PX+150) and PY2 in range(PY-150,PY+150):
                    if Energia2 < 10:
                        pass
                    if Energia2 >= 10:
                        PJ2HAreaX = (PX2+20)
                        PJ2HAreaY = (PY2+20)
                        P2HT = 150
                        Energia2 -= 10

                else:
                    if PX2 > PX:
                        PX2 -= 10
                    elif PX2 < PX:
                        PX2 += 10
                    if PY2 > PY:
                        PY2 -= 10
                    elif PY2 < PY:
                        PY2 += 10


            if PY2 in range(PY-50,PY+50):
                if PY2 > 375:
                    PY2 += random.choice([20,-20,-20])
                    Energia2 +=energiapermoviment
                if PY2 < 375:
                    PY2 += random.choice([20,-20,20])
                    Energia2 +=energiapermoviment



            if PX2 in range(PX-50,PX+50):
                if PX2 > 625:
                    PX2 += random.choice([20,-20,-20])
                    Energia2 +=energiapermoviment
                if PX2 < 625:
                    PX2 += random.choice([20,-20,20])
                    Energia2 +=energiapermoviment

            if HP2 <= 50:
                if PX2 < 1200:
                    PX2 += 20
                if PY2 < 375:
                    PY2 += 20
                if PY2 > 375:
                    PY2 -= 20
        if oneplayerhard == True and map != 6:
                if HP2 == maxhpp2:
                    if PX > 200:
                        if PX2 in range(PX-150,PX+150) and PY2 in range(PY-150,PY+150):
                            if Energia2 < 10:
                                pass
                            if Energia2 >= 10:
                                PJ2HAreaX = (PX2+20)
                                PJ2HAreaY = (PY2+20)
                                P2HT = 150
                                Energia2 -= 10

                        else:
                            if PX2 > PX:
                                PX2 -= 15
                            elif PX2 < PX:
                                PX2 += 15
                            if PY2 > PY:
                                PY2 -= 15
                            elif PY2 < PY:
                                PY2 += 15


                if PY2 in range(PY-40,PY+40):
                    if PY2 >= 375:
                        if PY < PY2:
                            PY2 += 30
                            Energia2 +=energiapermoviment
                        else:
                            PY2 -= 30
                            Energia2 +=energiapermoviment
                        #PY2 += random.choice([30,-30,-30])
                        #Energia2 +=energiapermoviment
                    if PY2 <= 375:
                        if PY < PY2:
                            PY2 += 30
                            Energia2 +=energiapermoviment
                        else:
                            PY2 -= 30
                            Energia2 +=energiapermoviment
                        #PY2 += random.choice([30,-30,-30])
                        #Energia2 +=energiapermoviment



                if PX2 in range(PX-40,PX+40):
                    if PX2 > 625:
                        PX2 += random.choice([30,-30,-30])
                        Energia2 +=energiapermoviment
                    if PX2 < 625:
                        PX2 += random.choice([30,-30,30])
                        Energia2 +=energiapermoviment

                if HP2 <= 50:
                    if PX2 < 1200:
                        PX2 += 20
                    if PY2 < 375:
                        PY2 += 20
                    if PY2 > 375:
                        PY2 -= 20
        if map == 3:
            base1 = pygame.draw.rect(finestra,(verd),(0,300,200,200))
            base2 = pygame.draw.rect(finestra,(verd),(1050,300,200,200))
            if PJO.colliderect(base1):
                HP = maxhpp1
                Energia = 100
            if PJO.colliderect(base2):
                HP = 0
                Energia = 0
            if PJO2.colliderect(base1):
                HP2 = 0
                Energia2 = 0

            if PJO2.colliderect(base2):
                HP2 = maxhpp2
                Energia2 = 100
            if fondoactivat == True:
                finestra.blit(fondo3,(0,0))
        if map == 6:
            if PJ2Wins > PJ1Wins:
                winpoints = PJ2Wins
                winner = '2'
            else:
                winpoints = PJ1Wins
                winner = '1'

            base1 = pygame.draw.rect(finestra,(verd),(0,550,200,200))
            base12= pygame.draw.rect(finestra,(verd),(0,450,100,100))
            base13= pygame.draw.rect(finestra,(verd),(200,650,100,100))
            base2 = pygame.draw.rect(finestra,(verd),(1050,0,200,200))
            base22= pygame.draw.rect(finestra,(verd),(950,0,100,100))
            base23 = pygame.draw.rect(finestra,(verd),(1150,200,100,100))
            if PJO.colliderect(base1):
                HP = maxhpp1
                Energia = 100
            if PJO.colliderect(base2):
                HP = 0
                Energia = 0
            if PJO.colliderect(base12):
                HP = maxhpp1
                Energia = 100
            if PJO.colliderect(base22):
                HP = 0
                Energia = 0
            if PJO.colliderect(base13):
                HP = maxhpp1
                Energia = 100
            if PJO.colliderect(base23):
                HP = 0
                Energia = 0

            if PJO2.colliderect(base1):
                HP2 = 0
                Energia2 = 0

            if PJO2.colliderect(base2):
                HP2 = maxhpp2
                Energia2 = 100
            if PJO2.colliderect(base12):
                HP2 = 0
                Energia2 = 0

            if PJO2.colliderect(base22):
                HP2 = maxhpp2
                Energia2 = 100
            if PJO2.colliderect(base13):
                HP2 = 0
                Energia2 = 0

            if PJO2.colliderect(base23):
                HP2 = maxhpp2
                Energia2 = 100

            #Objectes de 1
            if fondoactivat == True:
                finestra.blit(fondo6,(0,0))
            Cura = pygame.draw.rect(finestra,(blau),(CuraX,CuraY,50,50))
            if CuraAva == True:
                CuraX= 350
                CuraY= 100
            if CuraAva == False:
                CuraX = -50
                CuraY = -50
            if PJO2.colliderect(Cura):
                HP2 += 10
                Energia2 += 50
                CuraAva = False
            if PJO.colliderect(Cura):
                HP += 10
                Energia += 50
                CuraAva = False
        if map == 2:

            base1 = pygame.draw.rect(finestra,(verd),(0,300,200,200))
            base2 = pygame.draw.rect(finestra,(verd),(1050,300,200,200))
            if PJO.colliderect(base1):
                HP = maxhpp1
                Energia = 100
            if PJO.colliderect(base2):
                HP = 0
                Energia = 0
            if PJO2.colliderect(base1):
                HP2 = 0
                Energia2 = 0

            if PJO2.colliderect(base2):
                HP2 = maxhpp2
                Energia2 = 100
            if fondoactivat == True:
                finestra.blit(fondo2,(0,0))
        if map == 1:

            base1 = pygame.draw.rect(finestra,(verd),(0,300,200,200))
            base2 = pygame.draw.rect(finestra,(verd),(1050,300,200,200))
            if PJO.colliderect(base1):
                HP = maxhpp1
                Energia = 100
            if PJO.colliderect(base2):
                HP = 0
                Energia = 0
            if PJO2.colliderect(base1):
                HP2 = 0
                Energia2 = 0

            if PJO2.colliderect(base2):
                HP2 = maxhpp2
                Energia2 = 100
            if fondoactivat == True:
                finestra.blit(fondo1,(0,0))
        if map == 5:

            base1 = pygame.draw.rect(finestra,(verd),(0,300,200,200))
            base2 = pygame.draw.rect(finestra,(verd),(1050,300,200,200))
            if PJO.colliderect(base1):
                HP = maxhpp1
                Energia = 100
            if PJO.colliderect(base2):
                HP = 0
                Energia = 0
            if PJO2.colliderect(base1):
                HP2 = 0
                Energia2 = 0

            if PJO2.colliderect(base2):
                HP2 = maxhpp2
                Energia2 = 100
            if fondoactivat == True:
                finestra.blit(fondo5,(0,0))
        vidaquetellevasurtir = 5
        if PX > 1210:
            PX = 1200
        if PX2 > 1210:
            PX2 = 1210
        if PX2 < 1:
            PX2 = 0
        if PX < 1:
            PX = 0
        if PY > 701:
            PY = 700
        if PY2 > 701:
            PY2 = 700
        if PY2 < 1:
            PY2 = 0
        if PY < 1:
            PY = 0
        if PJ1H1 == 'rayo':
            if PJO2.colliderect(PJH1D)or PJO2.colliderect(PJH1D2) or PJO2.colliderect(PJH1D3) or PJO2.colliderect(PJH1D4):
                HP2 -= habilitatrayomal
        elif PJ2H1 == 'rayo':
            if PJO.colliderect(PJH1D)or PJO.colliderect(PJH1D2) or PJO.colliderect(PJH1D3) or PJO.colliderect(PJH1D4):
                HP -= habilitatrayomal
        P2HV = pygame.draw.circle(finestra, roig,(PJ2HAreaX,PJ2HAreaY), P2HT)
        if PJ1H1 == 'onda':
            if PJO2.colliderect(P2HV):
                HP2 -= habilitatondamal
        elif PJ2H1 == 'onda':
            if PJO.colliderect(P2HV):
                HP -= habilitatondamal
        PJH1D = pygame.draw.rect(finestra,(roig),(PJ2HPX,PJ2HPY,(PXH),25))
        PJH1D2 = pygame.draw.rect(finestra,(roig),(PJ2HPX,PJ2HPY,25,(PXH2)))
        PJH1D3 = pygame.draw.rect(finestra,(roig),(PJ2HPX,PJ2HPY,(PXH3),25))
        PJH1D4 = pygame.draw.rect(finestra,(roig),(PJ2HPX,PJ2HPY,25,(PXH4)))
        #Animacions personatges
        if PJA == 1:
            finestra.blit(PJ,(PX,PY))
            PJA = 2

        elif PJA== 2:
            finestra.blit(PJ1,(PX,PY))
            PJA = 3

        elif PJA == 3:
            finestra.blit(PJ2,(PX,PY))

            PJA = 1
        if PJA2 == 1:
            finestra.blit(PJ2x,(PX2,PY2))
            PJA2 = 2

        elif PJA2== 2:
            finestra.blit(PJ12,(PX2,PY2))
            PJA2 = 3

        elif PJA2 == 3:
            finestra.blit(PJ22,(PX2,PY2))

            PJA2 = 1
        EnergiaBar = pygame.draw.rect(finestra,(groc),(50,100,int(Energia),30))
        HPBar = pygame.draw.rect(finestra,(verd),(50,50,HP,30))
        HPT = twentytext.render(str(HP)+'HPBar',0,negre)
        EnergiaT = twentytext.render(str(Energia)+'E',0,negre)
        finestra.blit(HPT,(50,50))
        finestra.blit(EnergiaT,(50,100))

        EnergiaBar2 = pygame.draw.rect(finestra,(groc),(1050,650,Energia2,30))
        HPBar2 = pygame.draw.rect(finestra,(verd),(1050,600,HP2,30))
        HPT2 = twentytext.render(str(HP2)+'HPBar2',0,negre)
        EnergiaT2 = twentytext.render(str(Energia2)+'E2',0,negre)
        finestra.blit(HPT2,(1050,600))
        finestra.blit(EnergiaT2,(1050,650))

        #contador de victories i temps
        TimeCounter = fortytext.render(str(int(timer)),1,negre)
        #TimeCounterMins = fortytext.render(str(minuts),1,negre)
        PJ2WinsF = fortytext.render(str(PJ2Wins),1,negre)
        PJ1WinsF = fortytext.render(str(PJ1Wins),1,negre)
        #finestra.blit(fortytext.render(':',1,negre),(627,9))
        #finestra.blit(TimeCounterMins,(610,10))
        finestra.blit(TimeCounter,(630,10))
        finestra.blit(PJ1WinsF,(550,10))
        finestra.blit(PJ2WinsF,(700,10))
        if contadortemps == timer:
            contadortemps += 1
        if HP < 1:
            if map != 6:
                map -= 1
            PJ2Wins += 1
            PX = 100
            PY =350
            PX2 = 1100
            PY2 = 350
            HP = maxhpp1
        if map == 0:
            end = True
            gamestart = False
            if PJ2Wins > PJ1Wins:
                winpoints = PJ2Wins
                winner = '2'
            else:
                winpoints = PJ1Wins
                winner = '1'
        if HP > maxhpp1:
            HP = maxhpp1
        if Energia > 100:
            Energia = 100
        if Energia < 1:
            Energia = 0
        if HP2 < 1:

            PX = 100
            PY =350
            PX2 = 1100
            PY2 = 350
            #PX2 = 1150
            #PY2 = 50
            PJ1Wins += 1
            if map != 6:
                map += 1
            HP2 = maxhpp2
        if HP2 > maxhpp2:
            HP2 = maxhpp2
        if Energia2 > 100:
            Energia2 = 100
        if Energia2 < 1:
            Energia2 = 0
        if oneplayereasy == False and oneplayerhard == False:
            if pygame.key.get_pressed()[pygame.K_KP_DIVIDE]:
                if Energia2 < 11:
                    pass
                if Energia2 > 10:

                    if sombra == True:
                        PX2 = PXsombra
                        PY2 = PYsombra
                        Energia2 -= 10
                        treuresombra = True
                    if sombra == False:

                        Energia2 -= 10
                        sombra = True
                        PXsombra = PX2
                        PYsombra = PY2
        if treuresombra == True:
            sombra = False
            treuresombra = False
        if sombra == True:

            PJ2H2 = pygame.draw.rect(finestra,(negre),(PXsombra,PYsombra,50,50))

        pygame.display.update()
    while end:
        finestra.fill(verd)

        lletralogin = fiftytext.render('Player '+winner+' won  with : '+str(winpoints)+' kills in '+str(int(timer))+' seconds',1,negre)
        finestra.blit(lletralogin,(50,150))

        for event in pygame.event.get():

            if event.type == pygame.QUIT:
                pygame.quit()
                quit()


        pygame.display.flip()
