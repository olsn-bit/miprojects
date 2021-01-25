
import subprocess
try:
	import pyautogui
except ImportError:
	subprocess.call("pip install pyautogui")
import time
string = "This is going to be thirty seconds of typing for you and therefore you should complete this within thirty seconds. I wish you the best of luck! Oops too short"
time.sleep(3)
for c in string:
	pyautogui.typewrite(c)
	time.sleep(0.2)
