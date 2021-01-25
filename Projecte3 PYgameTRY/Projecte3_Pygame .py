#colliderect
#randint
#pygame.event.get()
#display set mode i set caption

from pygame.locals import *

import pygame, sys
from random import randint

coloret = (123, 31, 46)
pygame.init()



root = pygame.display.set_mode((1000,400))
pygame.display.set_caption("MAIN ZED")

Mi_imagen = pygame.image.load("Mob1.png")
posX= 500
posY= 350
posF= 500
posG= 350

vel = 1
suka = True

while True:

    root.fill(coloret)
    root.blit(Mi_imagen,(posF,posG))

#DATA
    posX,posY = pygame.mouse.get_pos()
    rect1 = pygame.draw.rect(root, (12,54,23), (posX, posY,100,50))
    rect2 = pygame.draw.rect(root, (12,54,23), (200,350,100,50))

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

    if suka==True:34
        if posF<975:
            posF+=vel
        else:
            suka=False
    else:
        if posF>1:
            posF-=vel
        else:
            suka=True

    if rect1.colliderect(rect2):
        rect1 = pygame.draw.rect(root, (127,52,203), (posX, posY,100,50))
    elif rect1.colliderect(Mi_imagen):
        print("ola")


    pygame.display.update()
