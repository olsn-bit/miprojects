from .config import *
from .habilities import *
from .player import Player
from .map import *
import pygame
from pygame.locals import *
import sys,random,time,os

pygame.init()
finestra = pygame.display.set_mode((1250,750))
class Ecliono:
    def __init__(self):
        pygame.display.set_caption('Ecliono Reworked')
        pygame.key.set_repeat(10,10)
        self.screen = finestra
        self.fondomenu = pygame.image.load('game/Images/menu.png')
        self.fondopartida = pygame.image.load('game/Images/squarefondo1.1.jpg')
        self.map = Map()
        self.player1 = Player(30,660,finestra,self.map.base1,"wasd")
        self.player2 = Player(300,660,finestra,self.map.base2,"arrows")
        self.menu()
    def menu(self):
        while True:
            exitbutton = pygame.draw.rect(finestra,(verd), ((1050, 5), (192, 38)))
            configbutton = pygame.draw.rect(self.screen,(verd), ((449, 249), (339, 64)))
            charactersbutton = pygame.draw.rect(self.screen,(verd), ((448, 340), (341, 61)))
            storebutton = pygame.draw.rect(self.screen,(verd), ((450, 429), (337, 63)))
            lorebutton = pygame.draw.rect(self.screen,(verd), ((451, 520), (338, 61)))
            playbutton = pygame.draw.rect(self.screen,(verd), ((447, 605), (342, 63)))
            self.screen.blit(self.fondomenu,(0,0))

            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    pygame.quit()
                    quit()
                mouse_posit = pygame.mouse.get_pos()
                if event.type == pygame.MOUSEBUTTONDOWN:
                    mouse_pos = event.pos
                    if liverectmode:
                        Ecliono.liverectdraw(mouse_pos,self.screen,verd,True)
                    if playbutton.collidepoint(mouse_pos):
                        self.start(self.screen)
                    elif lorebutton.collidepoint(mouse_pos):
                        Ecliono.userLore()
                    elif storebutton.collidepoint(mouse_pos):
                        Ecliono.userStore()
                    elif charactersbutton.collidepoint(mouse_pos):
                        Ecliono.userCharacter()
                    elif configbutton.collidepoint(mouse_pos):
                        Ecliono.userConfig()
                    elif exitbutton.collidepoint(mouse_pos):
                        pygame.quit()
                        quit()
            if liverectmode:
                Ecliono.liverectdraw(mouse_posit,self.screen,verd,False)
            pygame.display.update()
    def userConfig():
        pass
    def userCharacter():
        pass
    def userStore():
        pass
    def userLore():
        pass
    def liverectdraw(mousepos,screen,color,click):
        global liverectclickcount,LRmouseData
        if liverectclickcount == 0 and click == True:
            liverectclickcount = 1
            LRmouseData.append(mousepos)
        elif liverectclickcount == 1 and click == True:
            liverectclickcount = 2
            LRmouseData.append(mousepos)
        elif liverectclickcount == 2 and click == False:
            pygame.draw.rect(screen,(color),((LRmouseData[0]),(-(LRmouseData[0][0]-LRmouseData[1][0]),-(LRmouseData[0][1]-LRmouseData[1][1]))))
        elif liverectclickcount == 2 and click == True:
            print("pygame.draw.rect(finestra,(verd),",((LRmouseData[0]),(-(LRmouseData[0][0]-LRmouseData[1][0]),-(LRmouseData[0][1]-LRmouseData[1][1]))))
            liverectclickcount = 0
            LRmouseData = []
    def textCreator(text, size, color, pos_x, pos_y):
        font = pygame.font.Font(None, size)
        finestra.blit(font.render(text,1,color),(pos_x,pos_y))
    def start(self,finestra):

        clock = pygame.time.Clock()
        while True:
            if showfondo:
                self.screen.blit(self.fondopartida,(0,0))
            else:
                self.screen.fill(negre)
            for projectil in projectiles:
                projectil.draw(self.screen)
            if liveshowmapvalue:
                self.map.drawcellvalues(self.screen)
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    pygame.quit()
                    quit()
                if event.type == pygame.MOUSEBUTTONDOWN:
                    mousex,mousey = pygame.mouse.get_pos()
                    if livedrawwallsvar:
                        self.map.livedrawwalls(self.screen,self.map.river,mousex,mousey)
            keys = pygame.key.get_pressed()
            if keys[pygame.K_ESCAPE]:
                self.menu()
            self.player1.update()
            self.map.detectmapcollisions(self.player1)
            self.player2.update()
            self.map.detectmapcollisions(self.player2)

            if displayfps:
                fps = pygame.font.Font(None, 30).render(str(int(clock.get_fps()))+" FPS", True, pygame.Color('white'))
                finestra.blit(fps, (0, 0))

            # for e in projectiles:
            #     if projectiles.x < 500 and projectiles.x > 0:
            #         projectiles.x += projectiles.vel
            #     else:
            #         projectiles.pop(bullets.index(projectiles))
            # pygame.draw.rect(finestra,(roig), ((x_coord, y_coord), (20, 20)))
            clock.tick(60)
            pygame.display.update()

    def end(self):
        pass
