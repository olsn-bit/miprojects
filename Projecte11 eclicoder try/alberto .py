#This project is meant to make a coder for the future game ecliono and make the code private and deny people from copying the code or changing it
#To do this im going to make a class with a encoder decoder and something else with execode
#From the string is going to be converted as a integer and then to bin and store-it to a file, and vice versa
import os
class EcliEncoder(object):
    #To start we have here all the letters that can be used on the string 
    # and its correspondace number that is going to be future converted to bin
    abc = "abcdefghijklmnñopqrstuvwxyz "
    #This number is random buy can't be changed after use to avoid errors
    code = [89,45,65,34,54,87,28,46,95,24,75,85,98,52,53,81,43,56,79,47,32,88,37,50,21,99,12,51]
    def encode(string):
        code = EcliEncoder.code
        abc = EcliEncoder.abc
        #With the string inputed is going to be converted to numbers and then to bin and it will return the bin number
        i = 0
        resultat = []
        for e in string:
            resultat.append(code[abc.index(str(string[i]))])
            i += 1
        return bin(int("".join(str(e) for e in resultat)))
 
    def decode(binary):
        
#         #With the string inputed is going to be converted to string and will return the raw string
        code = EcliEncoder.code
        abc = EcliEncoder.abc
        def split_by_n( seq, n ):
            seq = str(seq)
            while seq:
                yield int(seq[:n])
                seq = seq[n:]
        num = split_by_n(str(int(binary,2)),2)
        resultat = []
        for e in num:
            i = code.index(e)
            resultat.append(abc[i])
        return "".join(resultat)
        #Learn how tf do generators work and yeld and zip and do exercices and "".join(str(e) for e in resultat)
    def writetofile(file,data):
        pass
try1 = EcliEncoder.decode(EcliEncoder.encode("hello fellas"))
print(try1)
