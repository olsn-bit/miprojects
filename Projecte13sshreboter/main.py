import os
import subprocess
# subprocess.Popen("python","autoalumnescript.py")
clase = 2
command = ["nmap","-p","22","--open","-sV",'192.168.22'+str(clase)+'.*']
p = subprocess.Popen(command, stdout=subprocess.PIPE)
text = p.stdout.read()
text = str(text)
text2 = "192.168.22"+str(clase)+"."
text = text.replace('192.168.22'+str(clase)+'.1\n'," ")
dosveg = 0
while True:
    find = text.find("192")
    # print("esto a buscao")
    if find == -1:
        break
    print(text)
    print(text[find+12]+text[find+13]+text[find+14])
    seguen = str(text[find+12]+text[find+13]+text[find+14])
    print(seguen)
    print(find)
    os.system("ssh alumne@192.168.22"+str(clase)+"."+seguen)
    text = text.replace(text2+text[find+12]+text[find+13]+text[find+14],"xx")
