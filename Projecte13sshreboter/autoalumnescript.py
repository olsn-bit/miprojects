import pyautogui,random,time
contres = ["alumne","123","1234","12345","asfd","alumne123"]
contres = ["alumne"]
while True:
    img = pyautogui.locateCenterOnScreen(image="paswimg")
    print("no detected")
    if img != None:
        p = random.choice(contres)
        pyautogui.click(img)
        pyautogui.typewrite(p)
        pyautogui.press("enter")
        print(p)
        print("detected")
    time.sleep(0.5)
