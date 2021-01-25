#So what im going to be doing is a clicker but instead of clicking with inputs and money per second
#we will start doing the interface and then create buy options with inputs but lets create clases and code in diferent docuemtns, this is going to be the
#classes one and the speacking and tutorials and the other is goint to be the funcional one
#this first class is to start setting player vars
class Typer(object):
    #price of buying 1 points per second
    #lets make a interface with all vars
    #new game
    timescalled = 0
    def __init__(self):
        Typer.timescalled += 1
        self.name = "World "+str(Typer.timescalled)
        self.points = points = 0
        self.pps = 0
        self.ppsprice = 100
        self.ptsletter = 1
    #depending on numer u put points ge added to player
    def inpclick(self,clicksmade):
        b = 0
        for e in clicksmade:
            b += 1
        self.points += int((self.ptsletter*b))
    #able to buy mps and show prices and money that u need
    def buypps(self):
        while self.points > self.ppsprice:
            self.points -= self.ppsprice
            self.pps += 1

    def setptsletter(self,newpplvalue):
        newpplvalue = self.ptsletter
    def updateinterface(self):
        interface = ("_"*10+"\n"+ self.name+"  |||  Points:"+str(self.points)+" || PPS : "+str(self.pps))
        return interface
    #upgrade points per letter
