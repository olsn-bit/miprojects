#8. Write a Python class to reverse a string word by word. - Go to the editor
#Input string : 'hello .py'
#Expected Output : '.py hello'
string = ''
class reverter(object):
    def __init__(self, string):
        stringex = ''
        stringexf = ''
        strlist = []
        revwrite = True
        order = True
        ordstart = 0
        strstart = 0
        strlen = len(string)
        while revwrite:
            strlist.append(string[strstart])
            strstart += 1
            if strstart == strlen:
                revwrite = False
        stringex = stringex.join(strlist)
        stringex = stringex.replace(" ",",")
        stringex = stringex.split(",")
        myorder = []
        for e in range(len(stringex)):
            myorder.append((len(stringex)-e))
        stringex = [stringex[(i-1)] for i in myorder]
        print(" ".join(str(x) for x in stringex))


ex1 = reverter('hola bon dia alberto es molt holito')
