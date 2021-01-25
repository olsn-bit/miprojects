from datetime import datetime
#So what im going to be doing is a clicker but instead of clicking with inputs and money per second
#we will start doing the interface and then create buy options with inputs but lets create clases and code in diferent docuemtns, this is going to be the
#classes one and the speacking and tutorials and the other is goint to be the funcional one
#this first class is to start setting player vars
class Typer(object):
    #price of buying 1 points per second
    #timescalled is to see all the times init has been called
    timescalled = 0
    def __init__(self):
        Typer.timescalled += 1
        self.name = "World "+str(Typer.timescalled)
        self.points = points = 0
        self.pps = 0
        self.ppsprice = 100
        self.ptsletterupgprice = 200
    #points per letter writen
        self.ptsletter = 1
    #give str and get ptsletter value for every letter
    def inpclick(self,clicksmade):
        b = 0
        for e in clicksmade:
            b += 1
        self.points += int((self.ptsletter*b))
        self.points += self.addpps()
    #able to buy mps every ppsprice difined
    def buypps(self):
        while self.points > self.ppsprice:
            self.points -= self.ppsprice
            self.pps += 1
#this changes pts per letter
    def setptsletter(self,newpplvalue):
        newpplvalue = self.ptsletter
            #this makes an easy interface shoing points and pps
    def updateinterface(self):
        interface = ("_"*80+"\n"+ self.name+"  |||  Points:"+str(self.points)+" || PPS : "+str(self.pps))
        return print(interface)
    #upgrade points per letter
    def ptsletterupg(self):
        while self.points > self.ptsletterupgprice:
            self.points -= self.ptsletterupgprice
            self.ptsletter += 1
    def initialtime():
        global start
        now = datetime.now()
        starting_time = now.strftime("%H  %M  %S")
        hour,min,sec = int(starting_time[0:2]),int(starting_time[3:6]),int(starting_time[7:len(starting_time)])
        start = hour*3600+min*60+sec
    def addpps(self):
        now = datetime.now()
        starting_time = now.strftime("%H  %M  %S")
        hour,min,sec = int(starting_time[0:2]),int(starting_time[3:6]),int(starting_time[7:len(starting_time)])
        end = hour*3600+min*60+sec
        total = self.pps*(end - start)
        print("\nYou made "+str(total)+" while afk.\n")
        return total
