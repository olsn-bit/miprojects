import socket, threading

client = socket.socket()
ipserver = '192.168.223.146'

def connecct():
    global ipserver, client
    client.connect((ipserver, 8888))
    rec = client.recv(1024)
    print(rec)
    nom = str(input(""))
    client.send(nom.encode())

def misageria():
    global user
    while True:
        user = input("")
        client.send(user.encode())

def recepcio():
        rec = client.recv(1024)
        print(rec)

conexio = threading.Thread(target=connecct)
enviar = threading.Thread(target=misageria)
rebre = threading.Thread(target=recepcio)
conexio.start()
enviar.start()
rebre.start()
