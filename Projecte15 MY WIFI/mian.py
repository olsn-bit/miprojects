import requests
iplist = []
for e in range(1,256):
    for a in range(1,256):
        ip = str(e)+"."+str(a)
        iplist.append(ip)
for e in iplist:
    r = requests.get("http://192.168."+ip)
    rstatus = r.status_code
    if rstatus == 200:
        break
    else:
        pass
