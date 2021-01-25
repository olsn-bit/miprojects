from pygame.locals import*
from pygame import *
import sys,random,pickle,os,pygame
pygame.init()
n1 = 1
n12 = -10
finestra = pygame.display.set_mode((400,400))
pygame.display.set_caption('Test')
def start():
        global n1,n12
        finestra.fill((n1,0,0))
        if n1  > 250:
            n12 = -1
        elif n1 < 2:
            n12 = 1
        n1 += n12
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()
        pygame.display.flip()
while True:
    start()
