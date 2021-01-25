from playsound import playsound
var = 0
varBool = True
while True:
    var = 0
    varBool = True
    word = ""
    word = input()

    word = word.replace(" ","")
    while varBool:
        wordlist = list(word)

        wordp = wordlist[var] + '.wav'

        playsound(wordp)
        var += 1

        if var == (len(wordlist)):
            varBool = False
