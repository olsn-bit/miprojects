from pygame.locals import*
from pygame import *
import pygame,sys,random
from pygame import time
#Notes de versió
#Primera versió del nostre joc
#Inclou un mapa i dos jugadors
#Cada personatge te la seva habilitat
pygame.init()
##Globals
global movimentenpx
ample=1250
alt=750
finestra = pygame.display.set_mode((ample,alt))
pygame.display.set_caption('SmoSquare pre.alpha-1.0')

##Colors
negre=0,0,0
blanc=255,255,255
roig=255,0,0
verd=0,255,0
blau=0,0,255
groc= 255,164,32
##Imatges
fondo = pygame.image.load('squarefondo.png')
PJ = pygame.image.load('PJ.png')
PJ1 = pygame.image.load('PJ1.png')
PJ2 = pygame.image.load('PJ2.png')
PJA = 1
PJ2x = pygame.image.load('PJ2x.png')
PJ12 = pygame.image.load('PJ12.png')
PJ22 = pygame.image.load('PJ22.png')
PJA2 = 1
#Casillas
PX = 50
PY = 650
PX2 = 1150
PY2 = 50

wetfr = pygame.font.Font(None, 20)
wetf = pygame.font.Font(None, 20)
WET = wetfr.render('You got wet',0,roig)
EnergiaD = 100
HPD = 100
EnergiaD2 = 100
HPD2 = 100
movimentenpx = 50
energiapermoviment = 5
#Habilitats
P2HX = 50
P2HY = 50
PXH = 0
PXH2 = 0
PXH3 = 0
PXH4 = 0
colorultidelp1 = roig
PJH2_Altura = 0
PJH2D = pygame.draw.rect(finestra,(roig),(PX2,PY2,50,PJH2_Altura))

PJH1D = pygame.draw.rect(finestra,(colorultidelp1),(PX,PY,(PXH),50))
PJH1D2 = pygame.draw.rect(finestra,(colorultidelp1),(PX+8,PY+12,25,(PXH2)))
PJH1D3 = pygame.draw.rect(finestra,(colorultidelp1),(PX+8,PY+12,(PXH3),25))
PJH1D4 = pygame.draw.rect(finestra,(colorultidelp1),(PX+8,PY+12,25,(PXH4)))

CuraAva = True
CuraX= 350
CuraY= 100
 #variable per  a calcular el temps
P2H = False
fondoactivat = True
timee =4
CuraSpawn = 10


largeText = pygame.font.SysFont('comicsansms',200)
largeTextm = pygame.font.SysFont('comicsansms',100)
largeTextplaybuttontext = pygame.font.SysFont('comicsansms',70)

textmenu = largeText.render('SmoSquare',0,blau)
#controlbutton = largeTextplaybuttontext.render('Play','')
playbuttontext = largeTextplaybuttontext.render('Play',0,negre)

gamestart = False
intro = True
n1 = 1
n12 = -10
P2HT = 1
clock = pygame.time.Clock()
while intro:

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
        elif n1 < 10:
            n12 = 1
        n1 += n12

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


#while controles:

while gamestart:

    PXHData = 1
    P2HT = 1
    PXH = PXHData
    PXH2 = PXHData
    PXH3 = PXHData
    PXH4 = PXHData
    PJH2_Altura = 0
    def sika():
        global movimentenpx
        finestra.blit(WET,(500,500))
        movimentenpx = 50
    def sika2():
        global movimentenpx
        finestra.blit(WET,(500,500))
        movimentenpx = 50


    timer = pygame.time.get_ticks()/1000

    if int(timer) == timee:
        print(int(timer))
        timee += 1
    if timee > CuraSpawn:
        CuraAva = True
        CuraSpawn += 10


    for e in pygame.event.get():

        if e.type == QUIT:
            pygame.quit()
            sys.exit()
        elif e.type == pygame.KEYDOWN:
            if e.key==K_RIGHT:
                PX += movimentenpx
                EnergiaD +=energiapermoviment
                movimentenpx = 50
            elif e.key==K_LEFT:
                PX -= movimentenpx
                EnergiaD +=energiapermoviment
                movimentenpx = 50
            elif e.key==K_UP:

                PY -= movimentenpx
                EnergiaD +=energiapermoviment
                movimentenpx = 50
            elif e.key==K_DOWN:

                PY += movimentenpx
                EnergiaD +=energiapermoviment
                movimentenpx = 50
            elif e.key ==K_w:

                PY2 -= movimentenpx
                EnergiaD2 +=energiapermoviment
                movimentenpx = 50
            elif e.key ==K_a:
                PX2 -= movimentenpx

                EnergiaD2 +=energiapermoviment
                movimentenpx = 50
            elif e.key ==K_s:

                PY2 += movimentenpx
                EnergiaD2 +=energiapermoviment
                movimentenpx = 50
            elif e.key ==K_d:
                PX2 +=movimentenpx
                EnergiaD2 +=energiapermoviment
                movimentenpx = 50
            elif e.key == K_q:
                if EnergiaD2 < 10:
                    pass
                else:
                    P2HT = 100


            if e.key == K_KP_MULTIPLY:
##                PJH1 =
                if EnergiaD < 30:
                    pass
                else:
                    PXH = 5350
                    PXH2 = 5350
                    PXH3 = -5350
                    PXH4 = -5350
                    EnergiaD -= 30





#Objectes de fondo
    finestra.fill(blau)
    PJO = pygame.draw.rect(finestra,(verd),((PX+10),(PY+10),35,35))
    PJO2 = pygame.draw.rect(finestra,(verd),((PX2+10),(PY2+10),35,35))
    vidaquetellevasurtir = 5
    if PX > 1249:
        PX = 1200
    elif PX2 > 1249:
        PX2 = 1200
    elif PX2 < 1:
        PX2 = 0
    elif PX < 1:
        PX = 0
    elif PY > 749:
        PY = 700
    elif PY2 > 749:
        PY2 = 700
    elif PY2 < 1:
        PY2 = 0
    elif PY < 1:
        PY = 0





##riu

##    riu1 = pygame.draw.rect(finestra, (verd),(100,200,32,32))
        #Rius

    base1 = pygame.draw.rect(finestra,(verd),(0,550,200,200))
    base2 = pygame.draw.rect(finestra,(verd),(1050,0,200,200))
    if PJO.colliderect(base1):
        HPD = 100
        EnergiaD = 100
    if PJO.colliderect(base2):
        HPD = 0
        EnergiaD = 0

    if PJO2.colliderect(base1):
        HPD2 = 0
        EnergiaD2 = 0

    if PJO2.colliderect(base2):
        HPD2 = 100
        EnergiaD2 = 100
    tamanyobjectesriu = 50
    riu1 = pygame.draw.rect(finestra, (verd),(  0,   0,tamanyobjectesriu,tamanyobjectesriu))
    riu2 = pygame.draw.rect(finestra, (verd),(  50,   0,tamanyobjectesriu,tamanyobjectesriu))
    riu3 = pygame.draw.rect(finestra, (verd),(  0,   50,tamanyobjectesriu,tamanyobjectesriu))
    riu4 = pygame.draw.rect(finestra, (verd),(  50,   50,tamanyobjectesriu,tamanyobjectesriu))
    riu5 = pygame.draw.rect(finestra, (verd),(  100,   50,tamanyobjectesriu,tamanyobjectesriu))
    riu6 = pygame.draw.rect(finestra, (verd),( 50,   100,tamanyobjectesriu,tamanyobjectesriu))
    riu7 = pygame.draw.rect(finestra, (verd),(  100,  100,tamanyobjectesriu,tamanyobjectesriu))
    riu8 = pygame.draw.rect(finestra, (verd),( 150,  100,tamanyobjectesriu,tamanyobjectesriu))
    riu9 = pygame.draw.rect(finestra, (verd),( 100,  150,tamanyobjectesriu,tamanyobjectesriu))
    riu10 = pygame.draw.rect(finestra, (verd),( 150,  150,tamanyobjectesriu,tamanyobjectesriu))
    riu11 = pygame.draw.rect(finestra, (verd),( 200,  150,tamanyobjectesriu,tamanyobjectesriu))
##    riu12 = pygame.draw.rect(finestra, (verd),( 150,  200,tamanyobjectesriu,tamanyobjectesriu))
##    riu13 = pygame.draw.rect(finestra, (verd),( 200,  200,tamanyobjectesriu,tamanyobjectesriu))
    riu14 = pygame.draw.rect(finestra, (verd),( 200,  250,tamanyobjectesriu,tamanyobjectesriu))
    riu15 = pygame.draw.rect(finestra, (verd),( 200,  300,tamanyobjectesriu,tamanyobjectesriu))
    riu16 = pygame.draw.rect(finestra, (verd),( 200,  350,tamanyobjectesriu,tamanyobjectesriu))
    riu17 = pygame.draw.rect(finestra, (verd),( 250,  350,tamanyobjectesriu,tamanyobjectesriu))
    riu18 = pygame.draw.rect(finestra, (verd),( 300,  350,tamanyobjectesriu,tamanyobjectesriu))
    riu19 = pygame.draw.rect(finestra, (verd),( 350,  350,tamanyobjectesriu,tamanyobjectesriu))
    riu20 = pygame.draw.rect(finestra, (verd),( 400,  350,tamanyobjectesriu,tamanyobjectesriu))
    riu21= pygame.draw.rect(finestra, (verd),( 450,  350,tamanyobjectesriu,tamanyobjectesriu))
    riu22= pygame.draw.rect(finestra, (verd),( 350,   300,tamanyobjectesriu,tamanyobjectesriu))
    riu23= pygame.draw.rect(finestra, (verd),( 350,   250,tamanyobjectesriu,tamanyobjectesriu))
    riu24= pygame.draw.rect(finestra, (verd),( 350,  400,tamanyobjectesriu,tamanyobjectesriu))
    riu25= pygame.draw.rect(finestra, (verd),( 400,  400,tamanyobjectesriu,tamanyobjectesriu))
    riu26= pygame.draw.rect(finestra, (verd),( 450,  400,tamanyobjectesriu,tamanyobjectesriu))
    riu27= pygame.draw.rect(finestra, (verd),( 550,  400,tamanyobjectesriu,tamanyobjectesriu))
    riu28= pygame.draw.rect(finestra, (verd),( 600,  400,tamanyobjectesriu,tamanyobjectesriu))
    riu29= pygame.draw.rect(finestra, (verd),( 550,  350,tamanyobjectesriu,tamanyobjectesriu))
    riu30= pygame.draw.rect(finestra, (verd),( 600,  350,tamanyobjectesriu,tamanyobjectesriu))
    riu31= pygame.draw.rect(finestra, (verd),( 750,  400,tamanyobjectesriu,tamanyobjectesriu))
##    riu32 = pygame.draw.rect(finestra, (verd),( 850,  400,tamanyobjectesriu,tamanyobjectesriu))
##    riu33 = pygame.draw.rect(finestra, (verd),( 593,  301,tamanyobjectesriu,tamanyobjectesriu))
##    riu34 = pygame.draw.rect(finestra, (verd),( 551,  302,tamanyobjectesriu,tamanyobjectesriu))
##    riu35 = pygame.draw.rect(finestra, (verd),( 618,  340,tamanyobjectesriu,tamanyobjectesriu))
##    riu36 = pygame.draw.rect(finestra, (verd),( 659,  341,tamanyobjectesriu,tamanyobjectesriu))
##    riu37= pygame.draw.rect(finestra, (verd),( 639,  385,tamanyobjectesriu,tamanyobjectesriu))
##    riu38= pygame.draw.rect(finestra, (verd),( 619,  423,tamanyobjectesriu,tamanyobjectesriu))
##    riu39= pygame.draw.rect(finestra, (verd),( 659,  425,tamanyobjectesriu,tamanyobjectesriu))
    riu40= pygame.draw.rect(finestra, (verd),( 1100,  550,tamanyobjectesriu,tamanyobjectesriu))
    riu41 = pygame.draw.rect(finestra, (verd),( 1050,  550,tamanyobjectesriu,tamanyobjectesriu))
    riu42 = pygame.draw.rect(finestra, (verd),( 1000,  550,tamanyobjectesriu,tamanyobjectesriu))
    riu43 = pygame.draw.rect(finestra, (verd),( 950,  550,tamanyobjectesriu,tamanyobjectesriu))
    riu44 = pygame.draw.rect(finestra, (verd),( 900,  550,tamanyobjectesriu,tamanyobjectesriu))
    riu45 = pygame.draw.rect(finestra, (verd),( 850,  550,tamanyobjectesriu,tamanyobjectesriu))
    riu46 = pygame.draw.rect(finestra, (verd),( 800,  550,tamanyobjectesriu,tamanyobjectesriu))
    riu47 = pygame.draw.rect(finestra, (verd),( 750,  550,tamanyobjectesriu,tamanyobjectesriu))
    riu48 = pygame.draw.rect(finestra, (verd),( 700,  550,tamanyobjectesriu,tamanyobjectesriu))
    riu49 = pygame.draw.rect(finestra, (verd),( 1100,  600,tamanyobjectesriu,tamanyobjectesriu))
    #Mes exteriors
    riu50 = pygame.draw.rect(finestra, (verd),( 1050,  600,tamanyobjectesriu,tamanyobjectesriu))
    riu51 = pygame.draw.rect(finestra, (verd),( 1000,  600,tamanyobjectesriu,tamanyobjectesriu))
    riu52 = pygame.draw.rect(finestra, (verd),( 950,  600,tamanyobjectesriu,tamanyobjectesriu))
    riu53 = pygame.draw.rect(finestra, (verd),( 900,  600,tamanyobjectesriu,tamanyobjectesriu))
    riu54 = pygame.draw.rect(finestra, (verd),( 850,  600,tamanyobjectesriu,tamanyobjectesriu))
    riu55 = pygame.draw.rect(finestra, (verd),( 800,  600,tamanyobjectesriu,tamanyobjectesriu))
    riu56 = pygame.draw.rect(finestra, (verd),( 750,  600,tamanyobjectesriu,tamanyobjectesriu))
    riu57 = pygame.draw.rect(finestra, (verd),( 700,  600,tamanyobjectesriu,tamanyobjectesriu))
    riu58 = pygame.draw.rect(finestra, (verd),( 650,  600,tamanyobjectesriu,tamanyobjectesriu))
    riu59 = pygame.draw.rect(finestra, (verd),( 1000,  650,tamanyobjectesriu,tamanyobjectesriu))
    riu60 = pygame.draw.rect(finestra, (verd),(950,  650,tamanyobjectesriu,tamanyobjectesriu))
    riu61= pygame.draw.rect(finestra, (verd),(900,  650,tamanyobjectesriu,tamanyobjectesriu))
    riu62 = pygame.draw.rect(finestra, (verd),(850,  650,tamanyobjectesriu,tamanyobjectesriu))
    riu63 = pygame.draw.rect(finestra, (verd),(800,  650,tamanyobjectesriu,tamanyobjectesriu))
    riu64 = pygame.draw.rect(finestra, (verd),(750,  650,tamanyobjectesriu,tamanyobjectesriu))
    riu65 = pygame.draw.rect(finestra, (verd),(700,  650,tamanyobjectesriu,tamanyobjectesriu))
    riu66 = pygame.draw.rect(finestra, (verd),(650,  650,tamanyobjectesriu,tamanyobjectesriu))
    riu67 = pygame.draw.rect(finestra, (verd),(650,  650,tamanyobjectesriu,tamanyobjectesriu))
    riu68 = pygame.draw.rect(finestra, (verd),(950,  700,tamanyobjectesriu,tamanyobjectesriu))
    riu69 = pygame.draw.rect(finestra, (verd),(900,  700,tamanyobjectesriu,tamanyobjectesriu))
    riu70 = pygame.draw.rect(finestra, (verd),(850,  700,tamanyobjectesriu,tamanyobjectesriu))
    riu71 = pygame.draw.rect(finestra, (verd),(800,  700,tamanyobjectesriu,tamanyobjectesriu))
    riu72 = pygame.draw.rect(finestra, (verd),(750,  700,tamanyobjectesriu,tamanyobjectesriu))
    riu73 = pygame.draw.rect(finestra, (verd),( 700,  700,tamanyobjectesriu,tamanyobjectesriu))
    riu74 = pygame.draw.rect(finestra, (verd),( 650,  700,tamanyobjectesriu,tamanyobjectesriu))
    riu75 = pygame.draw.rect(finestra, (verd),( 600,  700,tamanyobjectesriu,tamanyobjectesriu))
    riu78 = pygame.draw.rect(finestra, (verd),( 700,  500,tamanyobjectesriu,tamanyobjectesriu))
    riu79 = pygame.draw.rect(finestra, (verd),( 750,  500,tamanyobjectesriu,tamanyobjectesriu))
    riu80 = pygame.draw.rect(finestra, (verd),( 800,  500,tamanyobjectesriu,tamanyobjectesriu))
    riu81 = pygame.draw.rect(finestra, (verd),( 850,  500,tamanyobjectesriu,tamanyobjectesriu))
    riu82 = pygame.draw.rect(finestra, (verd),( 900,  500,tamanyobjectesriu,tamanyobjectesriu))
    riu83 = pygame.draw.rect(finestra, (verd),( 950,  500,tamanyobjectesriu,tamanyobjectesriu))
    riu84 = pygame.draw.rect(finestra, (verd),( 1000,  500,tamanyobjectesriu,tamanyobjectesriu))
    riu85 = pygame.draw.rect(finestra, (verd),( 600,  450,tamanyobjectesriu,tamanyobjectesriu))
    riu86 = pygame.draw.rect(finestra, (verd),( 650,  450,tamanyobjectesriu,tamanyobjectesriu))
    riu87 = pygame.draw.rect(finestra, (verd),( 700,  450,tamanyobjectesriu,tamanyobjectesriu))
    riu88 = pygame.draw.rect(finestra, (verd),( 750,  450,tamanyobjectesriu,tamanyobjectesriu))
    riu89 = pygame.draw.rect(finestra, (verd),( 800,  450,tamanyobjectesriu,tamanyobjectesriu))
    riu90 = pygame.draw.rect(finestra, (verd),( 850,  450,tamanyobjectesriu,tamanyobjectesriu))
    riu91 = pygame.draw.rect(finestra, (verd),( 900,  450,tamanyobjectesriu,tamanyobjectesriu))
#Objectes de 1
    if fondoactivat == True:
        finestra.blit(fondo,(0,0))
    if PJO2.colliderect(PJH1D):
        HPD2 -= 50
    if PJO2.colliderect(PJH1D2):
        HPD2 -= 50
    if PJO2.colliderect(PJH1D3):
        HPD2 -= 50
    if PJO2.colliderect(PJH1D4):
        HPD2 -= 50



    P2HV = pygame.draw.circle(finestra, roig,(PX2+20,PY2+20), P2HT)
    Cura = pygame.draw.rect(finestra,(blau),(CuraX,CuraY,50,50))
    if PJO.colliderect(P2HV):
        HPD -= 33
    if CuraAva == True:
        CuraX= 350
        CuraY= 100
    elif CuraAva == False:
        CuraX = -50
        CuraY = -50
    if PJO.colliderect(Cura):
        HPD += 10
        CuraAva = False
    if PJO2.colliderect(Cura):
        HPD2 += 50
        CuraAva = False


##    if PJH1 == True:
##        PJH1D = pygame.draw.rect(finestra,(roig),(PX,PY,(PXH),50))
##        PJH1 = False

    PJH1D = pygame.draw.rect(finestra,(roig),(PX+8,PY+12,(PXH),25))
    PJH1D2 = pygame.draw.rect(finestra,(roig),(PX+8,PY+12,25,(PXH2)))
    PJH1D3 = pygame.draw.rect(finestra,(roig),(PX+8,PY+12,(PXH3),25))
    PJH1D4 = pygame.draw.rect(finestra,(roig),(PX+8,PY+12,25,(PXH4)))

    #text de dewn temporal
    if PJO.colliderect(riu1):
        sika()
    elif PJO.colliderect(riu2):
        sika()
    elif PJO.colliderect(riu3):
        sika()
    elif PJO.colliderect(riu4):
        sika()
    elif PJO.colliderect(riu5):
        sika()
    elif PJO.colliderect(riu6):
        sika()
    elif PJO.colliderect(riu7):
        sika()
    elif PJO.colliderect(riu8):
        sika()
    elif PJO.colliderect(riu9):
        sika()
    elif PJO.colliderect(riu10):
        sika()
    elif PJO.colliderect(riu11):
        sika()
##    elif PJO.colliderect(riu12):
##        sika()
##    elif PJO.colliderect(riu13):
##        sika()
    elif PJO.colliderect(riu14):
        sika()
    elif PJO.colliderect(riu15):
        sika()
    elif PJO.colliderect(riu16):
        sika()
    elif PJO.colliderect(riu17):
        sika()
    elif PJO.colliderect(riu18):
        sika()
    elif PJO.colliderect(riu19):
        sika()
    elif PJO.colliderect(riu20):
        sika()
    elif PJO.colliderect(riu21):
        sika()
    elif PJO.colliderect(riu22):
        sika()
    elif PJO.colliderect(riu23):
        sika()
    elif PJO.colliderect(riu24):
        sika()
    elif PJO.colliderect(riu25):
        sika()
    elif PJO.colliderect(riu26):
        sika()
    elif PJO.colliderect(riu27):
        sika()
    elif PJO.colliderect(riu28):
        sika()
    elif PJO.colliderect(riu29):
        sika()
    elif PJO.colliderect(riu30):
        sika()
    elif PJO.colliderect(riu31):
        sika()
##    elif PJO.colliderect(riu32):
##        sika()
##    elif PJO.colliderect(riu33):
##        sika()
##    elif PJO.colliderect(riu34):
##        sika()
##    elif PJO.colliderect(riu35):
##        sika()
##    elif PJO.colliderect(riu36):
##        sika()
##    elif PJO.colliderect(riu37):
##        sika()
##    elif PJO.colliderect(riu38):
##        sika()
##    elif PJO.colliderect(riu39):
##        sika()
    elif PJO.colliderect(riu40):
        sika()
    elif PJO.colliderect(riu41):
        sika()
    elif PJO.colliderect(riu42):
        sika()
    elif PJO.colliderect(riu43):
        sika()
    elif PJO.colliderect(riu44):
        sika()
    elif PJO.colliderect(riu45):
        sika()
    elif PJO.colliderect(riu46):
        sika()
    elif PJO.colliderect(riu47):
        sika()
    elif PJO.colliderect(riu48):
        sika()
    elif PJO.colliderect(riu49):
        sika()
    elif PJO.colliderect(riu50):
        sika()
    elif PJO.colliderect(riu51):
        sika()
    elif PJO.colliderect(riu52):
        sika()
    elif PJO.colliderect(riu53):
        sika()
    elif PJO.colliderect(riu54):
        sika()
    elif PJO.colliderect(riu55):
        sika()
    elif PJO.colliderect(riu56):
        sika()
    elif PJO.colliderect(riu57):
        sika()
    elif PJO.colliderect(riu58):
        sika()
    elif PJO.colliderect(riu59):
        sika()
    elif PJO.colliderect(riu60):
        sika()
    elif PJO.colliderect(riu61):
        sika()
    elif PJO.colliderect(riu62):
        sika()
    elif PJO.colliderect(riu63):
        sika()
    elif PJO.colliderect(riu64):
        sika()
    elif PJO.colliderect(riu65):
        sika()
    elif PJO.colliderect(riu66):
        sika()
    elif PJO.colliderect(riu67):
        sika()
    elif PJO.colliderect(riu68):
        sika()
    elif PJO.colliderect(riu69):
        sika()
    elif PJO.colliderect(riu70):
        sika()
    elif PJO.colliderect(riu71):
        sika()
    elif PJO.colliderect(riu72):
        sika()
    elif PJO.colliderect(riu73):
        sika()
    elif PJO.colliderect(riu74):
        sika()
    elif PJO.colliderect(riu75):
        sika()


    elif PJO2.colliderect(riu1):
        sika2()
    elif PJO2.colliderect(riu2):
        sika2()
    elif PJO2.colliderect(riu3):
        sika2()
    elif PJO2.colliderect(riu4):
        sika2()
    elif PJO2.colliderect(riu5):
        sika2()
    elif PJO2.colliderect(riu6):
        sika2()
    elif PJO2.colliderect(riu7):
        sika2()
    elif PJO2.colliderect(riu8):
        sika2()
    elif PJO2.colliderect(riu9):
        sika2()
    elif PJO2.colliderect(riu10):
        sika2()
    elif PJO2.colliderect(riu11):
        sika2()
##    elif PJO2.colliderect(riu12):
##        sika2()
##    elif PJO2.colliderect(riu13):
##        sika2()
    elif PJO2.colliderect(riu14):
        sika2()
    elif PJO2.colliderect(riu15):
        sika2()
    elif PJO2.colliderect(riu16):
        sika2()
    elif PJO2.colliderect(riu17):
        sika2()
    elif PJO2.colliderect(riu18):
        sika2()
    elif PJO2.colliderect(riu19):
        sika2()
    elif PJO2.colliderect(riu20):
        sika2()
    elif PJO2.colliderect(riu21):
        sika2()
    elif PJO2.colliderect(riu22):
        sika2()
    elif PJO2.colliderect(riu23):
        sika2()
    elif PJO2.colliderect(riu24):
        sika2()
    elif PJO2.colliderect(riu25):
        sika2()
    elif PJO2.colliderect(riu26):
        sika2()
    elif PJO2.colliderect(riu27):
        sika2()
    elif PJO2.colliderect(riu28):
        sika2()
    elif PJO2.colliderect(riu29):
        sika2()
    elif PJO2.colliderect(riu30):
        sika2()
    elif PJO2.colliderect(riu31):
        sika2()
##    elif PJO2.colliderect(riu32):
##        sika2()
##    elif PJO2.colliderect(riu33):
##        sika2()
##    elif PJO2.colliderect(riu34):
##        sika2()
##    elif PJO2.colliderect(riu35):
##        sika2()
##    elif PJO2.colliderect(riu36):
##        sika2()
##    elif PJO2.colliderect(riu37):
##        sika2()
##    elif PJO2.colliderect(riu38):
##        sika2()
##    elif PJO2.colliderect(riu39):
##        sika2()
    elif PJO2.colliderect(riu40):
        sika2()
    elif PJO2.colliderect(riu41):
        sika2()
    elif PJO2.colliderect(riu42):
        sika2()
    elif PJO2.colliderect(riu43):
        sika2()
    elif PJO2.colliderect(riu44):
        sika2()
    elif PJO2.colliderect(riu45):
        sika2()
    elif PJO2.colliderect(riu46):
        sika2()
    elif PJO2.colliderect(riu47):
        sika2()
    elif PJO2.colliderect(riu48):
        sika2()
    elif PJO2.colliderect(riu49):
        sika2()
    elif PJO2.colliderect(riu50):
        sika2()
    elif PJO2.colliderect(riu51):
        sika2()
    elif PJO2.colliderect(riu52):
        sika2()
    elif PJO2.colliderect(riu53):
        sika2()
    elif PJO2.colliderect(riu54):
        sika2()
    elif PJO2.colliderect(riu55):
        sika2()
    elif PJO2.colliderect(riu56):
        sika2()
    elif PJO2.colliderect(riu57):
        sika2()
    elif PJO2.colliderect(riu58):
        sika2()
    elif PJO2.colliderect(riu59):
        sika2()
    elif PJO2.colliderect(riu60):
        sika2()
    elif PJO2.colliderect(riu61):
        sika2()
    elif PJO2.colliderect(riu62):
        sika2()
    elif PJO2.colliderect(riu63):
        sika2()
    elif PJO2.colliderect(riu64):
        sika2()
    elif PJO2.colliderect(riu65):
        sika2()
    elif PJO2.colliderect(riu66):
        sika2()
    elif PJO2.colliderect(riu67):
        sika2()
    elif PJO2.colliderect(riu68):
        sika2()
    elif PJO2.colliderect(riu69):
        sika2()
    elif PJO2.colliderect(riu70):
        sika2()
    elif PJO2.colliderect(riu71):
        sika2()
    elif PJO2.colliderect(riu72):
        sika2()
    elif PJO2.colliderect(riu73):
        sika2()
    elif PJO2.colliderect(riu74):
        sika2()
    elif PJO2.colliderect(riu75):
        sika2()



##    finestra.blit(PJ,(PX,PY))  elif PJO2.colliderect(riu76):



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
    Energia = pygame.draw.rect(finestra,(groc),(50,100,EnergiaD,30))
    HP = pygame.draw.rect(finestra,(verd),(50,50,HPD,30))
    HPB = wetf.render(str(HPD)+'HP',0,negre)
    EnergiaB = wetf.render(str(EnergiaD)+'E',0,negre)
    finestra.blit(HPB,(50,50))
    finestra.blit(EnergiaB,(50,100))

    Energia2 = pygame.draw.rect(finestra,(groc),(1050,650,EnergiaD2,30))
    HP2 = pygame.draw.rect(finestra,(verd),(1050,600,HPD2,30))
    HPB2 = wetf.render(str(HPD2)+'HP2',0,negre)
    EnergiaB2 = wetf.render(str(EnergiaD2)+'E2',0,negre)
    finestra.blit(HPB2,(1050,600))
    finestra.blit(EnergiaB2,(1050,650))

    if HPD < 1:
        winingplayer = 'Player 2'
        textofinal = largeTextm.render(winingplayer + ' Wins !!!',0,roig)
        finestra.blit(textofinal,(30,200))

    if HPD > 100:
        HPD = 100
    if EnergiaD > 100:
        EnergiaD = 100
    elif EnergiaD < 1:
        EnergiaD = 0

    if HPD2 < 1:
        winingplayer = 'Player 1'
        textofinal = largeTextm.render(winingplayer + ' Wins !!!',0,roig)
        finestra.blit(textofinal,(30,200))


    elif HPD2 > 100:
        HPD2 = 100
    elif EnergiaD2 > 100:
        EnergiaD2 = 100
    elif EnergiaD2 < 1:
        EnergiaD2 = 0

    pygame.display.update()
