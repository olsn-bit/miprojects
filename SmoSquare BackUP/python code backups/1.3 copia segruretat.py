from pygame.locals import*
from pygame import *
import pygame,sys,random,time
from pygame import time

import random
pygame.init()
############################################################################################################################
devmode = True
############################################################################################################################
#Notes de la versió 1.2
# Mes botos al menu i altres funcions (necessito models)
# Mode de joc                           (necessito info)
# Base de dades amb google api
# Més habilitats per persona
# Splasharts
# Contador de morts
# Contador de temps
# Limit de mors per guanyar
# Apartat de configuració al menu

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

map = 3#5 el 6 es el meu
PJ1H1 = 'rayo'
PJ1H2 = None
PJ2H1 = 'onda'
PJ2H2 = None
oneplayereasy = False
oneplayerhard = False
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
HP = 100
Energia2 = 100
HP2 = 100
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
fondoactivat = False
timee =2
CuraSpawn = 30
gamestart = False
intro = True
n1 = 1
n12 = -10
P2HT = 1
colorultidelp1 = roig
P1HNotAct = 0.1


#INICIADORS SMOSQUARE

finestra = pygame.display.set_mode((ample,alt))
pygame.display.set_caption('Ecliono alpha1.3')
pygame.key.set_repeat(10,10)
clock = pygame.time.Clock()

#Imatges
#fondomenu = pygame.image.load('fondomenu.png')
#botomenu = pygame.image.load('botomenu.png')
fondo3 = pygame.image.load('fondo3.png')
fondo4 = pygame.image.load('fondo4.png')
fondo1 = pygame.image.load('fondo1.png')
fondo2 = pygame.image.load('fondo2.png')
fondo5 =pygame.image.load('fondo5.png')
PJ = pygame.image.load('PJ.png')
PJ1 = pygame.image.load('PJ1.png')
PJ2 = pygame.image.load('PJ2.png')
PJ2x = pygame.image.load('PJ2x.png')
PJ12 = pygame.image.load('PJ12.png')
PJ22 = pygame.image.load('PJ22.png')
#Fonts
wetfont = pygame.font.Font(None, 20)
HPEfont = pygame.font.Font(None, 20)
ContadorFont = pygame.font.Font(None, 40)
WET = wetfont.render('You got wet',0,roig)
largeText = pygame.font.SysFont('comicsansms',200)
largeTextm = pygame.font.SysFont('comicsansms',50)
largeTextplaybuttontext = pygame.font.SysFont('comicsansms',70)
textmenu = largeText.render(' Ecliono',0,blau)
playbuttontext = largeTextplaybuttontext.render('Play',0,negre)

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

    global P2HT,PJ2HAreaX,PJ2HAreaY
    PJ2HAreaX = (x+20)
    PJ2HAreaY = (y+20)
    P2HT = 150
def Hab4rayos(x,y):
    global PJ2HPX,PJ2HPY,PXH,PXH2,PXH3,PXH4
    PJ2HPX =( PX+8)
    PJ2HPY = (PY+12)
    PXH = 1250
    PXH2 = 1250
    PXH3 = -1250
    PXH4 = -1250
    P1HNotAct = 0.1
    P2HT = 1

#datareadopen = open("smopersonaldata.txt","r",)
#dataread = datareadopen.readline()
#datawrite = open("smopersonaldata.txt","w",)


while True:
    if devmode == True:

        gamestart = True
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
                    gamestart = True
            pygame.display.flip()
    while credits:
        pass
    while config:
        pass
    while gamestart:
        restartpositions()
        clock = pygame.time.Clock()
        clock.tick(30)
        movimentenpx = 10
        timer = pygame.time.get_ticks()/1000
        temsrandom = pygame.time.get_ticks()
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
                if Energia2 < 10:
                    pass
                else:
                    Energia2 -= 10
                    HabBola(PX2,PY2)
        if pygame.key.get_pressed()[pygame.K_r]:
                habilitatqtirada = pygame.time.get_ticks()
                if Energia < 30:
                    pass
                else:
                    Energia-=30
                    Hab4rayos(PX,PY)
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
                HP = 100
                Energia = 100
            if PJO.colliderect(base2):
                HP = 0
                Energia = 0
            if PJO2.colliderect(base1):
                HP2 = 0
                Energia2 = 0

            if PJO2.colliderect(base2):
                HP2 = 100
                Energia2 = 100
            if fondoactivat == True:
                finestra.blit(fondo4,(0,0))
        if oneplayereasy == True:


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
        if oneplayerhard == True:
                if HP2 == 100:
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
                    if PY2 > 375:
                        if PY < PY2:
                            PY2 += 30
                            Energia2 +=energiapermoviment
                        else:
                            PY2 -= 30
                            Energia2 +=energiapermoviment
                        #PY2 += random.choice([30,-30,-30])
                        #Energia2 +=energiapermoviment
                    if PY2 > 375:
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
                HP = 100
                Energia = 100
            if PJO.colliderect(base2):
                HP = 0
                Energia = 0
            if PJO2.colliderect(base1):
                HP2 = 0
                Energia2 = 0

            if PJO2.colliderect(base2):
                HP2 = 100
                Energia2 = 100
            if fondoactivat == True:
                finestra.blit(fondo3,(0,0))
        if map == 6:
            PX = None
            end = True
            gamestart = False
            if PJ2Wins > PJ1Wins:
                winpoints = PJ2Wins
                winner = '2'
            else:
                winpoints = PJ1Wins
                winner = '1'
        if map == 7:

            base1 = pygame.draw.rect(finestra,(verd),(0,550,200,200))
            base12= pygame.draw.rect(finestra,(verd),(0,450,100,100))
            base13= pygame.draw.rect(finestra,(verd),(200,650,100,100))
            base2 = pygame.draw.rect(finestra,(verd),(1050,0,200,200))
            base22= pygame.draw.rect(finestra,(verd),(950,0,100,100))
            base23 = pygame.draw.rect(finestra,(verd),(1150,200,100,100))
            if PJO.colliderect(base1):
                HP = 100
                Energia = 100
            if PJO.colliderect(base2):
                HP = 0
                Energia = 0
            if PJO.colliderect(base12):
                HP = 100
                Energia = 100
            if PJO.colliderect(base22):
                HP = 0
                Energia = 0
            if PJO.colliderect(base13):
                HP = 100
                Energia = 100
            if PJO.colliderect(base23):
                HP = 0
                Energia = 0

            if PJO2.colliderect(base1):
                HP2 = 0
                Energia2 = 0

            if PJO2.colliderect(base2):
                HP2 = 100
                Energia2 = 100
            if PJO2.colliderect(base12):
                HP2 = 0
                Energia2 = 0

            if PJO2.colliderect(base22):
                HP2 = 100
                Energia2 = 100
            if PJO2.colliderect(base13):
                HP2 = 0
                Energia2 = 0

            if PJO2.colliderect(base23):
                HP2 = 100
                Energia2 = 100

            #Objectes de 1
            if fondoactivat == True:
                finestra.blit(fondo3,(0,0))
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
                HP = 100
                Energia = 100
            if PJO.colliderect(base2):
                HP = 0
                Energia = 0
            if PJO2.colliderect(base1):
                HP2 = 0
                Energia2 = 0

            if PJO2.colliderect(base2):
                HP2 = 100
                Energia2 = 100
            if fondoactivat == True:
                finestra.blit(fondo2,(0,0))
        if map == 1:

            base1 = pygame.draw.rect(finestra,(verd),(0,300,200,200))
            base2 = pygame.draw.rect(finestra,(verd),(1050,300,200,200))
            if PJO.colliderect(base1):
                HP = 100
                Energia = 100
            if PJO.colliderect(base2):
                HP = 0
                Energia = 0
            if PJO2.colliderect(base1):
                HP2 = 0
                Energia2 = 0

            if PJO2.colliderect(base2):
                HP2 = 100
                Energia2 = 100
            if fondoactivat == True:
                finestra.blit(fondo1,(0,0))
        if map == 5:

            base1 = pygame.draw.rect(finestra,(verd),(0,300,200,200))
            base2 = pygame.draw.rect(finestra,(verd),(1050,300,200,200))
            if PJO.colliderect(base1):
                HP = 100
                Energia = 100
            if PJO.colliderect(base2):
                HP = 0
                Energia = 0
            if PJO2.colliderect(base1):
                HP2 = 0
                Energia2 = 0

            if PJO2.colliderect(base2):
                HP2 = 100
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
                HP2 -= 50
        elif PJ2H1 == 'rayo':
            if PJO.colliderect(PJH1D)or PJO.colliderect(PJH1D2) or PJO.colliderect(PJH1D3) or PJO.colliderect(PJH1D4):
                HP -= 50
        P2HV = pygame.draw.circle(finestra, roig,(PJ2HAreaX,PJ2HAreaY), P2HT)
        if PJ1H1 == 'onda':
            if PJO2.colliderect(P2HV):
                HP2 -= 33
        elif PJ2H1 == 'onda':
            if PJO.colliderect(P2HV):
                HP -= 33
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
        HPT = HPEfont.render(str(HP)+'HPBar',0,negre)
        EnergiaT = HPEfont.render(str(Energia)+'E',0,negre)
        finestra.blit(HPT,(50,50))
        finestra.blit(EnergiaT,(50,100))

        EnergiaBar2 = pygame.draw.rect(finestra,(groc),(1050,650,Energia2,30))
        HPBar2 = pygame.draw.rect(finestra,(verd),(1050,600,HP2,30))
        HPT2 = HPEfont.render(str(HP2)+'HPBar2',0,negre)
        EnergiaT2 = HPEfont.render(str(Energia2)+'E2',0,negre)
        finestra.blit(HPT2,(1050,600))
        finestra.blit(EnergiaT2,(1050,650))

        #contador de victories i temps
        TimeCounter = ContadorFont.render(str(int(timer)),1,negre)
        #TimeCounterMins = ContadorFont.render(str(minuts),1,negre)
        PJ2WinsF = ContadorFont.render(str(PJ2Wins),1,negre)
        PJ1WinsF = ContadorFont.render(str(PJ1Wins),1,negre)
        #finestra.blit(ContadorFont.render(':',1,negre),(627,9))
        #finestra.blit(TimeCounterMins,(610,10))
        finestra.blit(TimeCounter,(630,10))
        finestra.blit(PJ1WinsF,(550,10))
        finestra.blit(PJ2WinsF,(700,10))
        if contadortemps == timer:
            contadortemps += 1
        print(map)
        if HP < 1:
            PJ2Wins += 1
            PX = 100
            PY =350
            PX2 = 1100
            PY2 = 350
            map -= 1
            HP = 100
        if map == 0:
            end = True
            gamestart = False
            if PJ2Wins > PJ1Wins:
                winpoints = PJ2Wins
                winner = '2'
            else:
                winpoints = PJ1Wins
                winner = '1'
        if HP > 100:
            HP = 100
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
            map += 1
            HP2 = 100
        if HP2 > 100:
            HP2 = 100
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

        lletralogin = largeTextm.render('Player '+winner+' won  with : '+str(winpoints)+' kills in '+str(int(timer))+' seconds',1,negre)
        finestra.blit(lletralogin,(50,150))

        for event in pygame.event.get():

            if event.type == pygame.QUIT:
                pygame.quit()
                quit()


        pygame.display.flip()
