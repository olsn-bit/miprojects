import gameclass

pin = gameclass.tresenraya("pipo","pipa")
turn = "X"
print("Instruccions\n1.To put a value use numbers as numeric pad:\n 1 2 3 \n 4 5 6 \n 7 8 9\n")

while gameclass.tresenraya.keepWhile:
    pin.printgrid()
    inp = int(input(turn + " Turn : "))
    pin.placeletter(turn,inp)
    if turn == "X":
        turn = "O"
    else:
        turn = "X"
    pin.checkifwin()
