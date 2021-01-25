from pygame import *

import pygame, sys
from random import randint

coloret = (123, 31, 46)
pygame.init()



root = pygame.display.set_mode((1000,400))
pygame.display.set_caption("MAIN ZED")

Mi_imagen = pygame.image.load("Mob1.png")
posX= 500
posY= 350

vel = 1
suka = True

recta =  pygame.Rect(200,350,100,50)

while True:
    root.fill(coloret)
    root.blit(Mi_imagen,(posX,posY))

#DATA

    pygame.draw.rect(root, (12,54,23), recta)
    if recta.colliderect(Mi_imagen):
        posY = 100

#FINAL
    for event in pygame.event.get():
        if event.type == QUIT:
            pygame.quit()
            sys.exit()
        elif event.type == pygame.KEYDOWN:
            if event.key==K_LEFT:
                suka = False
            elif event.key==K_RIGHT:
                suka = True

    if suka==True:
        if posX<975:
            posX+=vel
        else:
            suka=False
    else:
        if posX>1:
            posX-=vel
        else:
            suka=True



    pygame.display.update()
