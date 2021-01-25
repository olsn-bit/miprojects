
def dobling(numbers):
    global luhnlist
    length = len(numbers)
    secdigit = 2

    luhnlist = []
    while secdigit <= length:
        luhnlist.insert(0,int((numbers[length-secdigit]))*2)
        secdigit += 2
    return luhnlist
def replacing(dobled,default):
    defaultlist = list(str(default))
    defvar = len(defaultlist)-2
    dobvar = len(dobled)-1
    lastlist = []

    for e in dobled:

        defaultlist[defvar] = dobled[dobvar]
        defvar -= 2
        dobvar -= 1
        if defvar < 0:
            break

    for e in defaultlist:
        lastlist.append(int(e))
    return lastlist
def plusing(listnumbers):
    sume = 0
    for e in listnumbers:
        sume += e
    return sume
while True:
    try:
        initialinp = int(input('Insert Credit Card Number: '))
    except:
        print("That's not valid!!")
        break
    print(plusing(replacing(dobling(str(initialinp)),initialinp)) /10)
    if type(int(plusing(replacing(dobling(str(initialinp)),initialinp))) /10) == int:
        print('Password correct!')
    else:
        print("This password doesn't exist")
