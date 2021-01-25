import clases
game1 = clases.Typer()
game2 = clases.Typer()
game3 = clases.Typer()
game4 = clases.Typer()
game5 = clases.Typer()
world = 1
while True:
    eval("print(game"+str(world)+".updateinterface())")
    a = str(input())
    if a == "buy":
        eval("game"+str(world)+".buypps()")
    elif a == "world+" and world < 5:
        world += 1
    elif a == "world-" and world > 1:
        world -= 1
    else:
        eval("game"+str(world)+".inpclick(\""+str(a)+"\")")
