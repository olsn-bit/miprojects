import pygame
FPS = 60

negre=0,0,0
blanc=255,255,255
roig=255,0,0
verd=0,255,0
blau=0,0,255
groc= 255,164,32

#Developer Tools
liverectmode = False
LRmouseData = []
liverectclickcount = 0
livedrawwallsvar = False
liveshowmapvalue = False
showfondo = True
displayfps = True
############################
projectiles = []
directionsprj = ["PJimgdown","PJimgright","PJimgleft","PJimgwd","PJimgwa","PJimgsd","PJimgsa","PJimgup"]
directiondata = [[0,+1],[+1,0],[-1,0],[+1,-1],[-1,-1],[1,+1],[-1,+1],[0,-1]]
map = []

airmoveerrorckeck = 0
initTime = pygame.time.get_ticks()
