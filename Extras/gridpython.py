def getdata():
    global MPDev,WDev,DDev,LDev,PDev,MPAll,WAll,DAll,LAll,PAll,MPBlit,WBlit,DBlit,LBlit,PBlit,MPCour,WCour,DCour,LCour,PCour,Variables
    dataopen = open("griddata.txt","r")
    initdataread = dataopen.read()
    MPDev = int(initdataread[0])
    WDev = int(initdataread[1])
    DDev = int(initdataread[2])
    LDev = int(initdataread[3])
    PDev = int(initdataread[4])
    MPAll = int(initdataread[5])
    WAll = int(initdataread[6])
    DAll = int(initdataread[7])
    LAll = int(initdataread[8])
    PAll = int(initdataread[9])
    MPBlit = int(initdataread[10])
    WBlit = int(initdataread[11])
    DBlit = int(initdataread[12])
    LBlit = int(initdataread[13])
    PBlit = int(initdataread[14])
    MPCour = int(initdataread[15])
    WCour = int(initdataread[16])
    DCour = int(initdataread[17])
    LCour = int(initdataread[18])
    PCour = int(initdataread[19])
    Variables = [MPDev,WDev,DDev,LDev,PDev,MPAll,WAll,DAll,LAll,PAll,MPBlit,WBlit,DBlit,LBlit,PBlit,MPCour,WCour,DCour,LCour,PCour]
    dataopen.close()
def printtable():
    Titleline = "Team                           | MP |  W |  D |  L |  P"
    TitleSep = "                               |    |    |    |    |   "
    DevLine = "Devastating Donkeys            |  "+str(MPDev)+" |  "+str(WDev)+" |  "+str(DDev)+" |  "+str(LDev)+" |  "+str(PDev)
    AllLine = "Allegoric Alaskans             |  "+str(MPAll)+" |  "+str(WAll)+" |  "+str(DAll)+" |  "+str(LAll)+" |  "+str(PAll)
    BlitLine = "Blithering Badgers             |  "+str(MPBlit)+" |  "+str(WBlit)+" |  "+str(DBlit)+" |  "+str(LBlit)+" |  "+str(PBlit)
    CourLine = "Courageous Californians        |  "+str(MPCour)+" |  "+str(WCour)+" |  "+str(DCour)+" |  "+str(LCour)+" |  "+str(PCour)
    SortedList = sorted([PDev,PAll,PBlit,PCour], key=int, reverse=True)
    DevPrinted = False
    AllPrinted = False
    BlitPrinted = False
    CourPrinted = False
    print(Titleline)
    print(TitleSep)
    if SortedList[0] == PDev:
        if DevPrinted == False:
            print(DevLine)
            DevPrinted = True
        elif AllPrinted == False:
            print(AllLine)
            AllPrinted = True
        elif BlitPrinted == False:
            print(BlitLine)
            BlitPrinted = True
        elif CourPrinted == False:
            print(CourLine)
            CourPrinted = True
    elif SortedList[0] == PAll:
        if DevPrinted == False:
            print(DevLine)
            DevPrinted = True
        elif AllPrinted == False:
            print(AllLine)
            AllPrinted = True
        elif BlitPrinted == False:
            print(BlitLine)
            BlitPrinted = True
        elif CourPrinted == False:
            print(CourLine)
            CourPrinted = True
    elif SortedList[0] == PBlit:
        if DevPrinted == False:
            print(DevLine)
            DevPrinted = True
        elif AllPrinted == False:
            print(AllLine)
            AllPrinted = True
        elif BlitPrinted == False:
            print(BlitLine)
            BlitPrinted = True
        elif CourPrinted == False:
            print(CourLine)
            CourPrinted = True
    elif SortedList[0] == PCour:
        if DevPrinted == False:
            print(DevLine)
            DevPrinted = True
        elif AllPrinted == False:
            print(AllLine)
            AllPrinted = True
        elif BlitPrinted == False:
            print(BlitLine)
            BlitPrinted = True
        elif CourPrinted == False:
            print(CourLine)
            CourPrinted = True
    if SortedList[1] == PDev:
        if DevPrinted == False:
            print(DevLine)
            DevPrinted = True
        elif AllPrinted == False:
            print(AllLine)
            AllPrinted = True
        elif BlitPrinted == False:
            print(BlitLine)
            BlitPrinted = True
        elif CourPrinted == False:
            print(CourLine)
            CourPrinted = True
    elif SortedList[1] == PAll:
        if DevPrinted == False:
            print(DevLine)
            DevPrinted = True
        elif AllPrinted == False:
            print(AllLine)
            AllPrinted = True
        elif BlitPrinted == False:
            print(BlitLine)
            BlitPrinted = True
        elif CourPrinted == False:
            print(CourLine)
            CourPrinted = True
    elif SortedList[1] == PBlit:
        if DevPrinted == False:
            print(DevLine)
            DevPrinted = True
        elif AllPrinted == False:
            print(AllLine)
            AllPrinted = True
        elif BlitPrinted == False:
            print(BlitLine)
            BlitPrinted = True
        elif CourPrinted == False:
            print(CourLine)
            CourPrinted = True
    elif SortedList[1] == PCour:
        if DevPrinted == False:
            print(DevLine)
            DevPrinted = True
        elif AllPrinted == False:
            print(AllLine)
            AllPrinted = True
        elif BlitPrinted == False:
            print(BlitLine)
            BlitPrinted = True
        elif CourPrinted == False:
            print(CourLine)
            CourPrinted = True
    if SortedList[2] == PDev:
        if DevPrinted == False:
            print(DevLine)
            DevPrinted = True
        elif AllPrinted == False:
            print(AllLine)
            AllPrinted = True
        elif BlitPrinted == False:
            print(BlitLine)
            BlitPrinted = True
        elif CourPrinted == False:
            print(CourLine)
            CourPrinted = True
    elif SortedList[2] == PAll:
        if DevPrinted == False:
            print(DevLine)
            DevPrinted = True
        elif AllPrinted == False:
            print(AllLine)
            AllPrinted = True
        elif BlitPrinted == False:
            print(BlitLine)
            BlitPrinted = True
        elif CourPrinted == False:
            print(CourLine)
            CourPrinted = True
    elif SortedList[2] == PBlit:
        if DevPrinted == False:
            print(DevLine)
            DevPrinted = True
        elif AllPrinted == False:
            print(AllLine)
            AllPrinted = True
        elif BlitPrinted == False:
            print(BlitLine)
            BlitPrinted = True
        elif CourPrinted == False:
            print(CourLine)
            CourPrinted = True
    elif SortedList[2] == PCour:
        if DevPrinted == False:
            print(DevLine)
            DevPrinted = True
        elif AllPrinted == False:
            print(AllLine)
            AllPrinted = True
        elif BlitPrinted == False:
            print(BlitLine)
            BlitPrinted = True
        elif CourPrinted == False:
            print(CourLine)
            CourPrinted = True
    if SortedList[3] == PDev:
        if DevPrinted == False:
            print(DevLine)
            DevPrinted = True
        elif AllPrinted == False:
            print(AllLine)
            AllPrinted = True
        elif BlitPrinted == False:
            print(BlitLine)
            BlitPrinted = True
        elif CourPrinted == False:
            print(CourLine)
            CourPrinted = True
    elif SortedList[3] == PAll:
        if DevPrinted == False:
            print(DevLine)
            DevPrinted = True
        elif AllPrinted == False:
            print(AllLine)
            AllPrinted = True
        elif BlitPrinted == False:
            print(BlitLine)
            BlitPrinted = True
        elif CourPrinted == False:
            print(CourLine)
            CourPrinted = True
    elif SortedList[3] == PBlit:
        if DevPrinted == False:
            print(DevLine)
            DevPrinted = True
        elif AllPrinted == False:
            print(AllLine)
            AllPrinted = True
        elif BlitPrinted == False:
            print(BlitLine)
            BlitPrinted = True
        elif CourPrinted == False:
            print(CourLine)
            CourPrinted = True
    elif SortedList[3] == PCour:
        if DevPrinted == False:
            print(DevLine)
            DevPrinted = True
        elif AllPrinted == False:
            print(AllLine)
            AllPrinted = True
        elif BlitPrinted == False:
            print(BlitLine)
            BlitPrinted = True
        elif CourPrinted == False:
            print(CourLine)
            CourPrinted = True
def inputaction():
    global MPDev,WDev,DDev,LDev,PDev,MPAll,WAll,DAll,LAll,PAll,MPBlit,WBlit,DBlit,LBlit,PBlit,MPCour,WCour,DCour,LCour,PCour,Variables
    input1 = input()
    input1 = input1.replace(";",",")
    inputlist = input1.split(",")
    if inputlist[2] == "win":
        if inputlist[0] == "Devastating Donkeys":
            PDev += 1
            WDev += 1
            MPDev += 1
        elif inputlist[0] == "Allegoric Alaskans":
            PAll += 1
            WAll += 1
            MPAll += 1
        elif inputlist[0] == "Blithering Badgers":
            PBlit += 1
            WBlit += 1
            MPBlit += 1
        elif inputlist[0] == "Couragerous Californians":
            PCour += 1
            WCour += 1
            MPCour += 1
        if inputlist[1] == "Devastating Donkeys":
            LDev += 1
            MPDev += 1
        elif inputlist[1] == "Allegoric Alaskans":
            LAll += 1
            MPAll += 1
        elif inputlist[1] == "Blithering Badgers":
            LBlit += 1
            MPBlit += 1
        elif inputlist[1] == "Couragerous Californians":
            LCour += 1
            MPCour += 1
def updatedata():
    global MPDev,WDev,DDev,LDev,PDev,MPAll,WAll,DAll,LAll,PAll,MPBlit,WBlit,DBlit,LBlit,PBlit,MPCour,WCour,DCour,LCour,PCour
    datawriteopen = open("griddata.txt","w")
    datawrite = datawriteopen.write("".join(str(x) for x in Variables))
    datawriteopen.close()
while True:
    getdata()
    printtable()
    inputaction()
    updatedata()
