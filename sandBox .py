def minion_game(string):
    vow = ['a', 'e', 'i', 'o', 'u']
    kevname = "Kevin"
    stuname = "Stuart"
    cons = ["b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w","x","y","z"]
    conslist = []
    vowlist = []
    stupoints = 0
    kevpoints = 0
    for e in string:
        if e in cons:
            if e in conslist:
                pass
            else:
                conslist.append(e)
        if e in vow:
            if e in vowlist:
                pass
            else:
                vowlist.append(e)
    start = 1
    for e in conslist:
        conslist.append(string[string.index(e):string.index(e)+int(start)])
        if start < len(string):
            start += 0.5
        else:
            break
    start = 1
    for e in vowlist:
        vowlist.append(string[string.index(e):string.index(e)+int(start)])
        if start < len(string):
            start += 0.5
        else:
            break
    var = 0
    for e in conslist:
        b = [index for index, value in enumerate(conslist) if value == e]
        if len(b) > 1:
            conslist[var] = ""
        var += 1
    var = 0
    for e in vowlist:
        b = [index for index, value in enumerate(vowlist) if value == e]
        if len(b) > 1:
            vowlist[var] = ""
        var += 1
    while "" in vowlist:
        vowlist.remove("")
    while  "" in conslist:
        conslist.remove("")

    print(conslist,vowlist)
minion_game("banana")
