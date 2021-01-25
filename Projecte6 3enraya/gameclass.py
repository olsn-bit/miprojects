class tresenraya(object):
    keepWhile = True
    def __init__(self,xplayer,oplayer):
        self.xplayer = xplayer
        self.oplayer = oplayer
        self.grid1,self.grid2,self.grid3,self.grid4,self.grid5,self.grid6,self.grid7,self.grid8,self.grid9 = (" "*9)
    def printgrid(self):
        grid1,grid2,grid3,grid4,grid5,grid6,grid7,grid8,grid9 = self.grid1,self.grid2,self.grid3,self.grid4,self.grid5,self.grid6,self.grid7,self.grid8,self.grid9
        self.grid =  grid1 +'  |  '+ grid2 +'  |  '+ grid3+'\n--------------\n'+ grid4 +'  |  '+ grid5 +'  |  '+ grid6+'\n--------------\n'+ grid7 +'  |  '+ grid8 +'  |  '+ grid9
        return print(self.grid)
    def placeletter(self,letter,pos):
        if eval("self.grid"+str(pos)) != " ":
            pass
            print("Place not empty!!")
        else:
            exec("self.grid"+str(pos)+" = \""+letter+"\"")
    def checkifwin(self):
        g1,g2,g3,g4,g5,g6,g7,g8,g9 = self.grid1,self.grid2,self.grid3,self.grid4,self.grid5,self.grid6,self.grid7,self.grid8,self.grid9
        if g1 and g2 and g3 == "X":
            self.end("X")
        if g4 and g5 and g6 == "X":
            self.end("X")
        if g7 and g8 and g9 == "X":
            self.end("X")
        if g1 and g4 and g7 == "X":
            self.end("X")
        if g2 and g5 and g8 == "X":
            self.end("X")
        if g3 and g6 and g9 == "X":
            self.end("X")
        if g1 and g5 and g9 == "X":
            self.end("X")
        if g3 and g5 and g7 == "X":
            self.end("X")

        if g1 and g2 and g3 == "O":
            self.end("O")
        if g4 and g5 and g6 == "O":
            self.end("O")
        if g7 and g8 and g9 == "O":
            self.end("O")
        if g1 and g4 and g7 == "O":
            self.end("O")
        if g2 and g5 and g8 == "O":
            self.end("O")
        if g3 and g6 and g9 == "O":
            self.end("O")
        if g1 and g5 and g9 == "O":
            self.end("O")
        if g3 and g5 and g7 == "O":
            self.end("O")
    def end(self,winnerletter):
        if winnerletter == "X":
            print("Player "+self.xplayer+" won the game !")
        else:
            print("Player "+self.oplayer+" won the game !")
        tresenraya.keepWhile = False
