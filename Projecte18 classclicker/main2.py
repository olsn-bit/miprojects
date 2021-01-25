from classes2 import *
##
# from datetime import datetime
# now = datetime.now()
# current_minute = now.strftime("%M")
# current_second = now.strftime("%S")
# print(current_minute,current_second)
##
game1 = Typer()
game2 = Typer()
game3 = Typer()
game4 = Typer()
game5 = Typer()
worlds = [game1,game2,game3,game4,game5]
# for e in worlds:
#     e.ptsletterupg(1)

world = 1
def typinginp(worlder):
    Typer.initialtime()
    global world
    a = str(input())
    if a == "buypps":
        eval("game"+str(worlder)+".buypps()")
    elif a == "world+" and worlder < 5:
        world += 1
    elif a == "world-" and worlder > 1:
        world -= 1
    elif a == "buyppl":
        eval("game"+str(worlder)+".ptsletterupg()")
    else:
        eval("game"+str(worlder)+".inpclick(\""+str(a)+"\")")
while True:
    Typer.updateinterface(eval("game"+str(world)))
    typinginp(world)
