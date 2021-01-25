# Code to check if left or right mouse buttons were pressed
import win32api
import time
sequence = [""]
sleepbetween = 0.1
while True:
    state_left = win32api.GetKeyState(0x01)  # Left button down = 0 or 1. Button up = -127 or -128
    state_right = win32api.GetKeyState(0x02)  # Right button down = 0 or 1. Button up = -127 or -128
    if state_left < -1:  # Button state changed
        if win32api.GetCursorPos() == (0,0):
            break
        a = win32api.GetCursorPos()
        if "pyautogui.click"+str(a)+"\n" not in sequence[len(sequence)-1]:
            sequence.append("pyautogui.click"+str(a)+"\ntime.sleep("+str(sleepbetween)+")\n")
        state_left = 0
    if state_right < -1:  # Button state changed
        b = win32api.GetCursorPos()
        sequence.append("pyautogui.rightclick"+str(a)+"\n")
        state_right = 0
    time.sleep(0.001)
data = open("scriptdata.py","w+")
data.write("import pyautogui,time\ntime.sleep(4)\n")
data.write("".join(sequence))
