from pygame.locals import*
from pygame import *
import pygame,sys
finestra = pygame.display.set_mode((1200,700))
pygame.display.set_caption('Smohex')
fondo = pygame.image.load('hexfondo2.png')
PJ = pygame.image.load('PJ.png')
C1 = 10,23
C2 = 20,43
while True:
    for e in pygame.event.get():
        if e.type == QUIT:
            pygame.quit()
            sys.exit()
        elif e.type == pygame.KEYDOWN:
            if e.key==K_RIGHT:
                C1 = 20,43
            elif e.key==K_RIGHT:
                Pass
    pygame.display.update()
    finestra.blit(fondo,(-30,-20))
    finestra.blit(PJ,C1)
