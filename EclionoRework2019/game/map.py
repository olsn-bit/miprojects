from .config import *
import pygame
from pygame.locals import *
import sys,random,time,os


class Map:
    def __init__(self):
        self.map = map
        self.river = [pygame.Rect(0, 0, 50, 50), pygame.Rect(50, 0, 50, 50), pygame.Rect(0, 50, 50, 50), pygame.Rect(50, 50, 50, 50), pygame.Rect(100, 50, 50, 50), pygame.Rect(50, 100, 50, 50), pygame.Rect(100, 100, 50, 50), pygame.Rect(150, 100, 50, 50), pygame.Rect(100, 150, 50, 50), pygame.Rect(150, 150, 50, 50), pygame.Rect(200, 150, 50, 50), pygame.Rect(150, 200, 50, 50), pygame.Rect(200, 200, 50, 50), pygame.Rect(200, 250, 50, 50), pygame.Rect(350, 250, 50, 50), pygame.Rect(200, 300, 50, 50), pygame.Rect(350, 300, 50, 50), pygame.Rect(200, 350, 50, 50), pygame.Rect(250, 350, 50,     50), pygame.Rect(300, 350, 50, 50), pygame.Rect(350, 350, 50, 50), pygame.Rect(400, 350, 50, 50), pygame.Rect(450, 350, 50, 50), pygame.Rect(500, 350, 50, 50), pygame.Rect(550, 350, 50, 50), pygame.Rect(600, 350, 50, 50), pygame.Rect(350, 400, 50, 50), pygame.Rect(400, 400, 50, 50), pygame.Rect(450, 400, 50, 50), pygame.Rect(500, 400, 50, 50), pygame.Rect(550, 400, 50, 50), pygame.Rect(600, 400, 50, 50), pygame.Rect(650, 400, 50, 50), pygame.Rect(750, 400, 50, 50), pygame.Rect(600, 450, 50, 50), pygame.Rect(650, 450, 50, 50), pygame.Rect(700, 450, 50, 50), pygame.Rect(750, 450,   50, 50), pygame.Rect(800, 450, 50, 50), pygame.Rect(850, 450, 50, 50), pygame.Rect(900, 450, 50, 50), pygame.Rect(700, 500, 50, 50), pygame.Rect(750, 500, 50, 50), pygame.Rect(800, 500, 50, 50), pygame.Rect(850, 500, 50, 50), pygame.Rect(900, 500, 50, 50), pygame.Rect(950, 500, 50, 50), pygame.Rect(1000, 500, 50, 50), pygame.Rect(700, 550, 50, 50), pygame.Rect(750, 550, 50, 50), pygame.Rect(800, 550, 50, 50), pygame.Rect(850, 550, 50, 50), pygame.Rect(900, 550, 50, 50), pygame.Rect(950, 550, 50, 50), pygame.Rect(1000, 550, 50, 50), pygame.Rect(1050, 550, 50, 50),    pygame.Rect(1100, 550, 50, 50), pygame.Rect(650, 600, 50, 50), pygame.Rect(700, 600, 50, 50), pygame.Rect(750, 600, 50, 50), pygame.Rect(800, 600, 50, 50), pygame.Rect(850, 600, 50, 50), pygame.Rect(900, 600, 50, 50), pygame.Rect(950, 600, 50, 50), pygame.Rect(1000, 600, 50, 50), pygame.Rect(1050, 600, 50, 50), pygame.Rect(1100, 600, 50, 50), pygame.Rect(650, 650, 50, 50), pygame.Rect(700, 650, 50, 50), pygame.Rect(750, 650, 50, 50), pygame.Rect(800, 650, 50, 50), pygame.Rect(850, 650, 50, 50), pygame.Rect(900, 650, 50, 50), pygame.Rect(950, 650, 50, 50), pygame.Rect(1000, 650,    50, 50), pygame.Rect(600, 700, 50, 50), pygame.Rect(650, 700, 50, 50), pygame.Rect(700, 700, 50, 50), pygame.Rect(750, 700, 50, 50), pygame.Rect(800, 700, 50, 50), pygame.Rect(850, 700, 50, 50), pygame.Rect(900, 700, 50, 50), pygame.Rect(950, 700, 50, 50)]
        self.resetmap()
        self.base1 = []
        self.base2 = []
    def textCreator(text, size, color, pos_x, pos_y,screen):
        font = pygame.font.Font(None, size)
        screen.blit(font.render(text,1,color),(pos_x,pos_y))
    def resetmap(self):
        for e in range(int(750/50)):
            self.map.append([])
            for i in range(int(1250/50)):
                self.map[e].append(0)
    def drawcellvalues(self,screen):
        ymap = xmap = 0
        for e in map:
            xmap = 0
            for i in e:
                Map.textCreator(str(i),75,negre,xmap*50,ymap*50,screen)
                xmap += 1
            ymap += 1
    def livedrawwalls(self,finestra,list,mousex,mousey):
        self.map[int(mousey/50)][int(mousex/50)] = 1
        ymap = xmap = 0
        for row in map:
            xmap = 0
            for e in row:
                # print(row)
                if e == 1:
                    # print(xmap*50, ymap*50)
                    list.append(pygame.draw.rect(finestra,(verd), ((xmap*50, ymap*50), (50, 50))))
                    e = 2
                xmap += 1
            ymap += 1

    def detectmapcollisions(self,player):
        for e in self.river:
            if e.collidepoint(player.X,player.Y):
                player.speed = 0.8
            else:
                player.speed = 0.16
        for e in self.base1:
            if e.collidepoint(player.X,player.Y):
                if player.base != self.base1:
                    player.HP = 0
        for e in self.base2:
            if e.collidepoint(player.X,player.Y):
                if player.base != self.base2:
                    player.HP = 0
