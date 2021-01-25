# aki no sta la data de veritat la bona sta a images aixi ke a ki fe mersa

mousemove = False
mousex = 0
mousey = 0


if e.type == pygame.MOUSEBUTTONUP:
    mousex,mousey= e.pos
    mousemove = True


    if mousemove ==  True:
            if mousex < PX:
                PX -= movimentenpx
            else:
                PX += movimentenpx
            if mousey < PY:
                PY -= movimentenpx
            else:
                PY += movimentenpx
            if mousex in  range(PX-20,PX+20) and mousey in range(PY-20,PY+20):
                mousemove = False
