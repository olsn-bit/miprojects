import pygame
from .config import *
class Habilities(pygame.sprite.Sprite):
    def BasicAtk(finestra,x,y):
        global initTime
        cooldown = 1000
        now = pygame.time.get_ticks()
        if now - initTime >= cooldown:
            initTime = now
            pygame.draw.circle(finestra, roig,(x,y), 150)
    def Ultimate(self):
        #Idea = shots projectiles everywhere
        print("is this working")
        global initTime,projectiles
        alldirections = ["PJimgdown","PJimgright","PJimgleft","PJimgwd","PJimgwa","PJimgsd","PJimgsa","PJimgup"]
        cooldown = 1000
        now = pygame.time.get_ticks()
        if now - initTime >= cooldown:
            initTime = now
            for e in alldirections:
                print("algo")
                projectiles.append(self.hab(self.X,self.Y,5,verd,e,15))
class projectile():
    def __init__(self,x,y,radius,color,facing,vel):
        self.x = x
        self.y = y
        self.radius = radius
        self.color = color
        self.directionx = directiondata[directionsprj.index(str(facing))][0] * vel
        self.directiony = directiondata[directionsprj.index(str(facing))][1] * vel
        self.vel = vel


    def draw(self,finestra):
        if self.x < 1250 and self.x > 0 and self.y < 750 and self.y > 0:
            self.x += self.directionx
            self.y += self.directiony
        else:
            projectiles.pop(projectiles.index(self))
        pygame.draw.circle(finestra, self.color, (self.x,self.y), self.radius)
