# from .player import *
# from .map import *
from .config import *
from .map import *
import pygame
from pygame.locals import *
import sys,random,time,os

pygame.init()
screen = pygame.display.set_mode((screenWidth,screenHeight))
class Ecliono:
    def __init__(self):
        pygame.display.set_caption('Ecliono Strategy')
        self.map = Map()
        self.fondo = pygame.image.load("game/Images/squarefondo.png")
        self.start()

    def textCreator(finestra,text, size, color, pos_x, pos_y):
        font = pygame.font.Font(None, size)
        finestra.blit(font.render(text,1,color),(pos_x,pos_y))

    def start(self):
        tamany = 80
        vistax = 0
        vistay = 0
        while True:
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    pygame.quit()
                    quit()
            screen.fill(negre)
            screen.blit(self.fondo,(0+vistax,0+vistay))
            vistax,vistay = self.map.checkUserMov(vistax,vistay)
            pygame.display.update()

# for e in range(1,100):
#     if (screenWidth % e) == 0 and (screenHeight % e) == 0:
#         print(e)
