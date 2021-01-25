from pygame.locals import*
import pygame, sys

pygame.init()

pygame.display.set_mode((400,300))
pygame.display.set_caption("XXX")

while True:
    pygame.fill()
    for e in pygame.event.get():
        if e.type == QUIT:
            pygame.quit()
            sys.exit()
    pygame.display.update()
#CODI BASE#CODI#CODI BASE BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE
#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE
#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE#CODI BASE
nomfinestra.fill(nom colo)

#formes

pygame.draw.line(root,Colors(12, 12),(12, 12))
pygame.draw.circle(root,Colors,(60,80),100)
pygame.draw.rect(x,x,x)#color,(x,x,x,x)
    pygame.draw.polygon(root,Colors,(aki dins posa totes les coordenades del objecte))


#POLLA
pygame.draw.circle(root,Colors,(150,300),70)
pygame.draw.circle(root,Colors,(250,300),70)
pygame.draw.rect(root,Colors,(150,300,100,-250))
pygame.draw.circle(root,Colors,(200,50),50)

#Carregar imatges

Mi_imagen = pygame.image.load("ICONW.png")
posX,posY= 130,70

root.blit(Mi_imagen,(posX,posY))#la blit es pa posar la !!!!!!!!!dins del while trrue

#Pa crear numeros aleatoris
from random import randint

variable= randint(numero minim,numero maxim)

#fer ke se mogue algo

vel = 5
suka = True

#aixo va dins de lo de while true pero fora del FOR
   if suka==True:
        if posX<850:
            posX+=vel
        else:
            suka=False
    else:
        if posX>50:
            posX-=vel
        else:
            suka=True

#que se mogue algo en los botons amb suka previament alertada

       # if event.type == QUIT:
           # pygame.quit()
            #sys.exit()
        elif event.type == pygame.KEYDOWN:
            if event.key==K_LEFT:
                suka = False
            elif event.key==K_RIGHT:
                suka = True

#fer que lo cursor pugue fer algo
                posX,posY = pygame.mouse.get_pos()
    #posX = posX - 100
    # posY = posY - 50

#que pasa cuan algo se choca

if objecte.colliderect(altre onb):
    coses que pasen
#crear rectangles

rectangle = pygame.rect(0,0,100,50)#100 i 50 es lo tamany del rect en este cas
                                                        #i 0,0 seria la posició en que apareix
pygame.draw.rect(root,colo, dades rectangul)


per fer coses en la posX i posY del rectanfgle es
posX = objecte.left
posY = objecte.top


#fer lletra (fora del while)
primer de tot creem la font

nom = pygame.font.Font(nom archiu en lfont o None,tamany lletra)      o font.SysFont
texte = nomdefont.render("text", 0'antialias',colo)#extra(colo de fondo de la lletra)
#pa dibuixaru u tenim (dins del while)
root.blit(texte, [posicio])

#cronometro

tems = pygame.time.get_ticks()

if exemple == Tiempo:
    aux += 1
    print Tiempo
