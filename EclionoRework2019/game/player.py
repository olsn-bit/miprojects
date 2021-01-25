import pygame
from .config import *
from .habilities import *
PJimgup = pygame.image.load('game/Images/PJimgup.png')
PJimgdown = pygame.image.load('game/Images/PJimgdown.png')
PJimgright = pygame.image.load('game/Images/PJimgright.png')
PJimgleft = pygame.image.load('game/Images/PJimgleft.png')
PJimgwd = pygame.image.load('game/Images/PJimgwd.png')
PJimgwa = pygame.image.load('game/Images/PJimgwa.png')
PJimgsd = pygame.image.load('game/Images/PJimgsd.png')
PJimgsa = pygame.image.load('game/Images/PJimgsa.png')
class Player(pygame.sprite.Sprite):
    """A player that will move freely across the screen"""
    def __init__(self,X,Y,finestra,base,keys):
        pygame.sprite.Sprite.__init__(self)
        self.image = PJimgup
        self.base = base
        self.X = X
        self.Y = Y
        self.keys = keys
        self.xVel = 0
        self.yVel = 0
        self.rect = self.image.get_rect()
        self.HP = 100
        self.screen = finestra
        self.facing = "PJimgdown"
        self.speed = 0.32
        self.accelerationloss = 0.12 #Has to be a divisor without rest to avoid errors with the substraction
        self.directions = ["up","down","right","left"]
        self.movement = [[0,-self.speed],[0,+self.speed],[+self.speed,0],[-self.speed,0]]
        self.basic = Habilities.BasicAtk
        self.hab = projectile
        self.ulti = Habilities.Ultimate
    def airmove(self,direction):
        global airmoveerrorckeck
        if direction != None:
            self.xVel += self.movement[self.directions.index(direction)][0]
            self.yVel += self.movement[self.directions.index(direction)][1]
            airmoveerrorcheck += 1
        if direction == None:
            airmoveerrorcheck = 0
        if airmoveerrorcheck == 9:
            raise EnvironmentError("Must call airmove(None) on player update !")
        if self.xVel > 0:
            self.xVel -= self.accelerationloss
        if self.yVel > 0:
            self.yVel -= self.accelerationloss
        if self.xVel < 0:
            self.xVel += self.accelerationloss
        if self.yVel < 0:
            self.yVel += self.accelerationloss
        if (self.X + self.xVel) < 1200 and (self.X + self.xVel) > +10:
            self.X += self.xVel
        if (self.Y + self.yVel) < 700 and (self.Y + self.yVel) > +10:
            self.Y += self.yVel
    def move(self,direction):
            speed = 5
            directions = ["up","down","right","left"]
            movement = [[0,-speed],[0,+speed],[+speed,0],[-speed,0]]
            if direction != None:
                if (self.X + movement[directions.index(direction)][0]) < 1250 and (self.X + movement[directions.index(direction)][0]) > -10:
                    self.X += movement[directions.index(direction)][0]
                if (self.Y + movement[directions.index(direction)][1]) < 750 and (self.Y + movement[directions.index(direction)][1]) > -10:
                    self.Y += movement[directions.index(direction)][1]
    # def drawstats(self,)
    def update(self):
        global initTime
        # self.drawstats()
        # self.airmove(None)
        keys = pygame.key.get_pressed()
        if self.keys == "wasd":
            if keys[pygame.K_d]:
                self.move("right")
                self.image = PJimgright
                self.facing = "PJimgright"
            if keys[pygame.K_a]:
                self.move("left")
                self.image = PJimgleft
                self.facing = "PJimgleft"
            if keys[pygame.K_w]:
                self.move("up")
                self.image = PJimgup
                self.facing = "PJimgup"
            if keys[pygame.K_s]:
                self.move("down")
                self.image = PJimgdown
                self.facing = "PJimgdown"
            if keys[pygame.K_d] and keys[pygame.K_s]:
                self.image =PJimgsd
                self.facing ="PJimgsd"
                # self.move("down")
                # self.move("right")
            if keys[pygame.K_a] and keys[pygame.K_w]:
                self.image = PJimgwa
                self.facing = "PJimgwa"
                # self.move("up")
                # self.move("left")
            if keys[pygame.K_w] and keys[pygame.K_d]:
                self.image =PJimgwd
                self.facing ="PJimgwd"
                # self.move("up")
                # self.move("right")
            if keys[pygame.K_s] and keys[pygame.K_a]:
                self.image =PJimgsa
                self.facing ="PJimgsa"
                # self.move("down")
                # self.move("left")
            if keys[pygame.K_q]:
                self.basic(self.screen,self.X,self.Y)
            if keys[pygame.K_SPACE]:
                cooldown = 1000
                now = pygame.time.get_ticks()
                if now - initTime >= cooldown:
                    initTime = now
                    projectiles.append(self.hab(self.X,self.Y,5,verd,self.facing,25))
            if keys[pygame.K_b]:
                Habilities.Ultimate
        if self.keys == "arrows":
            if keys[pygame.K_RIGHT]:
                self.move("right")
                self.image = PJimgright
                self.facing = "PJimgright"
            if keys[pygame.K_LEFT]:
                self.move("left")
                self.image = PJimgleft
                self.facing = "PJimgleft"
            if keys[pygame.K_UP]:
                self.move("up")
                self.image = PJimgup
                self.facing = "PJimgup"
            if keys[pygame.K_DOWN]:
                self.move("down")
                self.image = PJimgdown
                self.facing = "PJimgdown"
            if keys[pygame.K_RIGHT] and keys[pygame.K_DOWN]:
                self.image =PJimgsd
                self.facing ="PJimgsd"
                # self.move("down")
                # self.move("right")
            if keys[pygame.K_LEFT] and keys[pygame.K_UP]:
                self.image = PJimgwa
                self.facing = "PJimgwa"
                # self.move("up")
                # self.move("left")
            if keys[pygame.K_UP] and keys[pygame.K_RIGHT]:
                self.image =PJimgwd
                self.facing ="PJimgwd"
                # self.move("up")
                # self.move("right")
            if keys[pygame.K_DOWN] and keys[pygame.K_LEFT]:
                self.image =PJimgsa
                self.facing ="PJimgsa"
                # self.move("down")
                # self.move("left")
            if keys[pygame.K_q]:
                self.basic(self.screen,self.X,self.Y)
            if keys[pygame.K_SPACE]:
                # global initTime
                cooldown = 1000
                now = pygame.time.get_ticks()
                if now - initTime >= cooldown:
                    initTime = now
                    projectiles.append(self.hab(self.X,self.Y,5,verd,self.facing,25))
            if keys[pygame.K_b]:
                Habilities.Ultimate
        self.screen.blit(self.image,(self.X-25,self.Y-25))
