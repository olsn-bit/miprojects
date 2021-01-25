import os
def randint(firstNum,lastNum):
    if firstNum >= lastNum:
        raise ValueError("range not correct")
    randData = [os.times()]
    print(randData[0][4][1:3])
# list = ["Thing one","Thing two","Thing three","Thing four"]
# firstHalf = list[0:int(len(list)/2)]
# secondHalf = list[int(len(list)/2):int(len(list))]
# print(firstHalf,secondHalf)
randint(1,12);
