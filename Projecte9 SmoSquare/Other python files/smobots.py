#BOT player one###################################
print(PX,PY,PX2,PY2)

if PY2 > PY:
    PY += 5
if PX < (PX2-350):
    PX += 5
elif PX > (PX2-350):
    PX -= 5
if PY2 < PY:
    PY -= 5
if PY2 == PY:
    if Energia >= 20:
        Energia -= 20
        PXH += 1200
        PXH2 += 1200
        PXH3 += -1200
        PXH4 += -1200


    elif Energia < 20:


        PXH = 1
        PXH2 = 1
        PXH3 = -1
        PXH4 = -1
else:
    PXH = 1
    PXH2 = 1
    PXH3 = -1
    PXH4 = -1
Energia += 1

PJ1HBOT = [PXH,PXH2,PXH3,PXH4]

if PX < (PX2-350):
    PX += 10
elif PX > (PX2-350):
    PX -= 10
#BOt player 2
if PY2 > PY:
    PY2 -= 10
if PX2 < PX:
    PX2 += 10
elif PX2 > PX:
    PX2 -= 10
if PY2 < PY:
    PY2 += 10
if PY2 == PY:

    if PY2 < 100:
        PY2 += 50
    PY2 += random.choice([+50,-50])
if PX2 < (PX+100):
    P2HT = 150
if PY2 > 350:
    PY2 -= 50
#BOt s'ha acabat################
