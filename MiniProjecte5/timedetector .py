import time
import keyboard
global numero
global secs
numero = 0
secs = 0
def detec():
    global numero
    global secs
    numero = numero + 1
while True:
    detec()
    time.sleep(0.01)
    if numero == 99:
        secs += 1
        numero = 0
    if keyboard.is_pressed('space') == True:
        detec()
        print(str(secs) + '.'+ str(numero))
        numero = 1
        secs = 0
        time.sleep(0.1)
