#bull fer algo que pase un numero a binari i una ltre programa que ho llegeixi
#i poder fer sumes de binari
import os
class EcliEncoder(object):
    def encode(self,string):

    def decode(self,string):
        
    def execode(self,string):

abc = "abcdefghijklmnñopqrstuvwxyz "
numcode = [89,45,65,34,54,87,28,46,95,24,75,85,98,52,53,81,43,56,79,47,32,88,37,50,21,99,12,51]
def bintonum(num):
    resultat = int((str(num)),2)
    return resultat
def lettonum(string):

    i = 0
    resultat = []
    for e in string:
        index = abc.index(str(string[i]))
        resultat.append(numcode[index])
        i += 1
    resultat = "".join(str(e) for e in resultat)

    return resultat
def split_by_n( seq, n ):
    seq = str(seq)
    while seq:
        yield int(seq[:n])
        seq = seq[n:]
def numtolet(num):
    resultat = []
    generado = split_by_n(num,2)
    for e in generado:
        index = numcode.index(e)
        resultat.append(str(abc[index]))
    resultat = "".join(str(e) for e in resultat)
    return resultat
print("Write -help / -h for help")
while True:
    quedius = input(">>>:")
    if quedius == "-help" or quedius == "-h":
        print("\n/////Welcome to the Ecliono Encoder by Alberto Dos Santos \n type -w (to create a new file or overwrite it)\n type -r (to read the file eclicode.txt)\n")
    elif quedius == "-w":
        try:
            openit = open("eclicode.txt","wb")
        except FileNotFoundError:
            os.system("touch eclicode.txt")
            openit = open("eclicode.txt","wb")
        quedius = input("Write the text ut want to encode:")
        print("\n\n Writed Succesfull! \n\n")
        a = lettonum(str(quedius))
        b = bin(a)
        print(b[2:])
        # openit.write(b[2:])
        openit.write("hello")

    else:
        try:
            print(bin(lettonum(quedius)))
        except ValueError:
            print("Write only alphabetical letters with no signs or accents\n")
