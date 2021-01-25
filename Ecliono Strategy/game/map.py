from .config import *
import pygame
from pygame.locals import *
import sys,random,time,os

class Map:
    def __init__(self):
        self.data = Map.CreateMap()
    def CreateMap(self):
        mapa = []
        for e in range(100):
            mapa.append([])
        for e in mapa:
            for a in range(100):
                e.append(0)
        return mapa
    def checkUserMov(self,vistax,vistay):
        keys = pygame.key.get_pressed()
        if keys[pygame.K_d]:
            vistax -= 10
        if keys[pygame.K_a]:
            vistax += 10
        if keys[pygame.K_w]:
            vistay += 10
        if keys[pygame.K_s]:
            vistay -= 10
        return vistax,vistay
