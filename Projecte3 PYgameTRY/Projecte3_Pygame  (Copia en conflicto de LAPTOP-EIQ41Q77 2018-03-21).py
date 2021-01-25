from pygame.locals import *
from random import randint

import pygame, sys
from random import randint
global suri
global surix
surix = 60
suri = pygame.image.load('zed shurikent.png')
suri = pygame.transform.scale(suri,(surix,60))
Restart = False
color = (32, 66, 120)
coloret = (123, 31, 46)
pygame.init()

GOfont = pygame.font.SysFont("Arial", 100)
GOText = GOfont.render("Game Over",0,(4,100,60))

def Doge():
    global suri
    global surix
    aleatoriX1 = randint(0,90)
    aleatoriY1 = randint(0,350)
    aleatoriX2 = randint(0,100)
    aleatoriY2 = randint(0,400)
    aleatoriX3 = randint(0,100)
    aleatoriY3 = randint(0,400)
    root = pygame.display.set_mode((1000,400))
    pygame.display.set_caption("Dodge the Zed")


    DEG = 20
    DEI = 30
    GO = False

    posX= 500

    posY= 350

    E1X = aleatoriX1
    E1Y = aleatoriY1
    E1V = True

    E2X = aleatoriX2
    E2Y = aleatoriY2
    E2V = True

    E3X = aleatoriX3
    E3Y = aleatoriY3
    E3V = True

    suriv = True

    while True:

        root.fill(coloret)

        recta1 =  pygame.Rect(E1X,E1Y,15,15)
        recta2 =  pygame.Rect(E2X,E2Y,15,15)
        recta3 =  pygame.Rect(E3X,E3Y,15,15)
        pertg = pygame.Rect(posX,posY,1,1)
        obstacles = [recta1,recta2,recta3]
        vel = 2

    #DATA
        Tems = pygame.time.get_ticks()

        DE = pygame.draw.circle(root, (5,200,1), (100,100),DEG)
        DI = pygame.draw.circle(root, color, (800,300),DEI)

        pygame.draw.rect(root, color, pertg)
        pygame.draw.rect(root, (12,54,23), recta1)
        pygame.draw.rect(root, (12,54,23), recta2)
        pygame.draw.rect(root, (12,54,23), recta3)
        #COLISIONS
        if recta1.colliderect(pertg):
            root.blit(GOText, (100,100))
            GO = True
        if recta2.colliderect(pertg):
            root.blit(GOText, (100,100))
            GO = True
        if recta3.colliderect(pertg):
            root.blit(GOText, (100,100))
            GO = True
        if DE.colliderect(pertg):
            root.blit(GOText, (100,100))
            GO = True
        if DI.colliderect(pertg):
            DEG += 1
        #moviment
        if suriv == True:
            if surix < 900:
                surix += vel

            else:
                suriv = False
        elif suriv == False:
            if surix > 0:
                surix -= vel
            else:
                suriv = True

        if E1V == True:
            if E1X < 900:
                E1X += vel

            else:
                E1V = False
        elif E1V == False:
            if E1X > 0:
                E1X -= vel
            else:
                E1V = True

        if E2V == True:
            if E2X < 900:
                E2X += vel

            else:
                E2V = False
        elif E2V == False:
            if E2X > 0:
                E2X -= vel
            else:
                E2V = True

        if E3V == True:
            if E3X < 900:
                E3X += vel
            else:
                E3V = False
        elif E3V == False:
            if E3X > 0:
                E3X -= vel
            else:
                E3V = True

       #TEMPS
        if Tems == 2000:
            Tems = 0
            DEG += 10
        if GO == True:
            root.blit(suri,(60,45))
            root.blit(GOText, (100,100))


        posX,posY = pygame.mouse.get_pos()

    #FINAL
        for event in pygame.event.get():
            if event.type == QUIT:
                pygame.quit()
                sys.exit()





        pygame.display.update()

Doge()
