import pygame
from pygame.locals import*
from pygame import rect
import sys
global ample, alt, blauclar
ample = 1250
alt = 750
blauclar =  0, 255, 255
negre = 0,0,0
pygame.init()
pygame.mixer.init()
finestra = pygame.display.set_mode((ample,alt))
pygame.display.set_caption('The Zed Game')
Playerimage = pygame.image.load('minishuriken.png')

## Victimas
soraka = pygame.image.load('soraka.png')
ashe = pygame.image.load('ashe.jpg')
 ##Sounds
zedkill = pygame.mixer.music.load('zedsound.wav')



while True:
    PX,PY = pygame.mouse.get_pos()
    PY -= 70
    PX -= 70

    for e in pygame.event.get():
        if e.type == QUIT:
            pygame.quit()
            sys.exit()
        pygame.display.update()

    finestra.fill(blauclar)
    finestra.blit(Playerimage,(PX,PY))
    finestra.blit(soraka, (199,212))
    finestra.blit(ashe,(488,321))
