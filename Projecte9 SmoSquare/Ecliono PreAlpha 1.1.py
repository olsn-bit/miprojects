from pygame.locals import*
from pygame import *
import pygame,sys,random
from pygame import time
import smodata
import random
pygame.init()
############################################################################################################################
devmode = True
############################################################################################################################
#Notes de la versió 1.1
# Ara la mobilitat no és en quadres
# Les bases s'han fet més gran
# La cura ha sigut arreglada i balacejada
# Fons del mapa ha sigut arreglat
# S'han balancejat algunes dades del mal i rang d'habilitats.
# S'ha afegit energia en decimals.
# També ara el moviment esta arreglat i és més dinàmic.
# El menú i els botons d'ell tenen apariència.

##Colors
negre=0,0,0
blanc=255,255,255
roig=255,0,0
verd=0,255,0
blau=0,0,255
groc= 255,164,32

##Globals
global movimentenpx
#Variables
P1HNotAct = 0
ample=1250
alt=750
PJA = 1
PJA2 = 1
PX = 50
PY = 650
PX2 = 1150
PY2 = 50
Energia = 100
HP = 100
Energia2 = 100
HP2 = 100
movimentenpx = 10
movimentenpx2 = 15
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

#INICIADORS SMOSQUARE

finestra = pygame.display.set_mode((ample,alt))
pygame.display.set_caption('SmoSquare alpha1.1')
pygame.key.set_repeat(10,10)
clock = pygame.time.Clock()

#Imatges
#fondomenu = pygame.image.load('fondomenu.png')
#botomenu = pygame.image.load('botomenu.png')
fondo = pygame.image.load('squarefondo1.1.jpg')
PJ = pygame.image.load('PJ.png')
PJ1 = pygame.image.load('PJ1.png')
PJ2 = pygame.image.load('PJ2.png')
PJ2x = pygame.image.load('PJ2x.png')
PJ12 = pygame.image.load('PJ12.png')
PJ22 = pygame.image.load('PJ22.png')
#Fonts
wetfont = pygame.font.Font(None, 20)
HPEfont = pygame.font.Font(None, 20)
WET = wetfont.render('You got wet',0,roig)
largeText = pygame.font.SysFont('comicsansms',200)
largeTextm = pygame.font.SysFont('comicsansms',100)
largeTextplaybuttontext = pygame.font.SysFont('comicsansms',70)
textmenu = largeText.render(' SmoSquare',0,blau)
playbuttontext = largeTextplaybuttontext.render('Play',0,negre)

#Objectes

PJ2H = pygame.draw.rect(finestra,(roig),(PX2,PY2,50,PJH2_Altura))

PJH1D = pygame.draw.rect(finestra,(colorultidelp1),(PX,PY,(PXH),50))
PJH1D2 = pygame.draw.rect(finestra,(colorultidelp1),(PX+8,PY+12,25,(PXH2)))
PJH1D3 = pygame.draw.rect(finestra,(colorultidelp1),(PX+8,PY+12,(PXH3),25))
PJH1D4 = pygame.draw.rect(finestra,(colorultidelp1),(PX+8,PY+12,25,(PXH4)))



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
            finestra.blit(textmenu,(30,112))
            finestra.blit(playbuttontext,(555,405))
            easteregg = pygame.draw.rect(finestra,(groc),((1,740),(1,1)))

            if event.type == pygame.MOUSEBUTTONDOWN:
                mouse_pos = event.pos
                if playbutton.collidepoint(mouse_pos):
                    intro = False
                    gamestart = True
            pygame.display.flip()
    while gamestart:
        PXH = P1HNotAct
        PXH2 = P1HNotAct
        PXH3 = P1HNotAct
        PXH4 = P1HNotAct
        clock = pygame.time.Clock()
        clock.tick(30)
        movimentenpx = 10
        P1HNotAct = 0.1
        P2HT = 1

        PJH2_Altura = 0

        timer = pygame.time.get_ticks()/1000

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
                P2HT = 150
                Energia2 -= 10
        if pygame.key.get_pressed()[pygame.K_q]:
                if Energia < 30:
                    pass
                else:
                    PXH = 1200
                    PXH2 = 1200
                    PXH3 = -1200
                    PXH4 = -1200
                    Energia -= 30

        for e in pygame.event.get():
            if e.type == QUIT:
                pygame.quit()
                sys.exit()
            if e.type == pygame.KEYDOWN:
                pass






    #Objectes de fondo
        finestra.fill(blau)
        PJO = pygame.draw.rect(finestra,(verd),((PX+10),(PY+10),35,35))
        PJO2 = pygame.draw.rect(finestra,(verd),((PX2+10),(PY2+10),35,35))
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
            finestra.blit(fondo,(0,0))
        if PJO2.colliderect(PJH1D):
            HP2 -= 50
        if PJO2.colliderect(PJH1D2):
            HP2 -= 50
        if PJO2.colliderect(PJH1D3):
            HP2 -= 50
        if PJO2.colliderect(PJH1D4):
            HP2 -= 50



        P2HV = pygame.draw.circle(finestra, roig,(PX2+20,PY2+20), P2HT)
        Cura = pygame.draw.rect(finestra,(blau),(CuraX,CuraY,50,50))
        if PJO.colliderect(P2HV):
            HP -= 33
        if CuraAva == True:
            CuraX= 350
            CuraY= 100
        if CuraAva == False:
            CuraX = -50
            CuraY = -50
        if PJO.colliderect(Cura):
            HP += 10
            Energia += 50
            CuraAva = False
        if PJO2.colliderect(Cura):
            HP2 += 10
            Energia2 += 50
            CuraAva = False




        PJH1D = pygame.draw.rect(finestra,(roig),(PX+8,PY+12,(PXH),25))
        PJH1D2 = pygame.draw.rect(finestra,(roig),(PX+8,PY+12,25,(PXH2)))
        PJH1D3 = pygame.draw.rect(finestra,(roig),(PX+8,PY+12,(PXH3),25))
        PJH1D4 = pygame.draw.rect(finestra,(roig),(PX+8,PY+12,25,(PXH4)))

        #text de dewn temporal



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

    ##    print(timer)
    ## Barres de vida
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

        if HP < 1:
            winingplayer = 'Player 2'
            textofinal = largeTextm.render(winingplayer + ' Wins !!!',0,roig)
            finestra.blit(textofinal,(30,200))
            PX = 50
            PY = 650



        if HP > 100:
            HP = 100
        if Energia > 100:
            Energia = 100
        if Energia < 1:
            Energia = 0

        if HP2 < 1:
            winingplayer = 'Player 1'
            textofinal = largeTextm.render(winingplayer + ' Wins !!!',0,roig)
            finestra.blit(textofinal,(30,200))
            PX2 = 1150
            PY2 = 50



        if HP2 > 100:
            HP2 = 100
        if Energia2 > 100:
            Energia2 = 100
        if Energia2 < 1:
            Energia2 = 0

        pygame.display.update()
