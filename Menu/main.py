from time import sleep_ms
from machine import I2C, Pin
from esp8266_i2c_lcd import I2cLcd #del modulo esp8266_i2c_lcd, importta la funcion i2clcd

i2c = I2C(0, scl=Pin(1), sda=Pin(0), freq=400000)
lcd = I2cLcd(i2c, 0x27, 2, 16)
cLK = Pin(2, Pin.IN)
dAt = Pin(3, Pin.IN)
bUT = Pin(4, Pin.IN)
back = Pin(5, Pin.IN)
oFF = Pin(6, Pin.OUT)

lST = cLK.value() #variable "Lastclock"
m = p = s = str
vari = [m, p, s]
mENU = ("[MENU]", "PID",  "SYS" )
sYST = ("[SYS] " , "E/A", "TIME" )
pID  = ("[TEMP]" , "REAL", "OBJE" )
n = 0
k = 100
lcd.move_to(0, 0)
lcd.putstr("WELCOME!\nFilament Machine")
sleep_ms(3000)
lcd.clear()

def menu(aP): 
    global vari, m
    global sT
    if aP == 4:
        vari = mENU
        lcd.move_to(5, 0)
        lcd.putstr(vari[0])
        lcd.move_to(2, 1)
        lcd.putstr(vari[1])
        lcd.move_to(11, 1)
        lcd.putstr(vari[2])
        m = 0
    else:
        while True:
            lcd.move_to(5, 0)
            lcd.putstr(vari[0])
            lcd.move_to(2, 1)
            lcd.putstr(vari[1])
            lcd.move_to(11, 1)
            lcd.putstr(vari[2])
            if aP == 1:
                lcd.move_to(0, 1)
                lcd.putstr("  ")
                lcd.move_to(9, 1)
                lcd.putstr("=>")
                aP = 0
                while True:
                    if bUT.value()==True and m==1:
                        menSYS(2)
                        break
                    elif bUT.value()==True and m==0:
                        vari = sYST
                        m = 1
                        break
                    elif bUT.value()==True and m==2:
                        lcd.clear()
                        Temp_RO(2)
                        break
                    elif sT==False and dAt.value()==False:
                        break 
                continue  

            elif aP == 2:
                lcd.move_to(9, 1)
                lcd.putstr("  ")
                lcd.move_to(0, 1)
                lcd.putstr("=>") 
                aP = 0
                while True:
                    if bUT.value()==True and m==1:
                        menSYS(1)
                        break
                    elif bUT.value()==True and m==0:
                        vari = pID
                        m = 2
                        break
                    elif bUT.value()==True and m==2:
                        lcd.clear()
                        Temp_RO(1)
                        break
                    elif sT==False and dAt.value()==False:
                        break
            elif aP==0:
                break


def menSYS(n):
    if n==1:
        if oFF.value()==False:
            oFF.value(True)
            lcd.move_to(2, 1)
            lcd.putstr(vari[1])
            menu(2)

        elif oFF.value()==True:
            oFF.value(False)
            menu(2)
    if n==2:
        lcd.clear()
        while True:
            
            lcd.move_to(5, 0)
            lcd.putstr("TIME")
            lcd.move_to(2, 1)
            lcd.putstr(str(aTIME))


def Temp_RO(warm):
    if warm==1:
        while True:
            lcd.move_to(5,0)
            lcd.putstr("[REAL]")
            lcd.move_to(0,1)
            lcd.putstr("valor :")
            if back.value()==True and m==2:
                lcd.clear()
                vari=pID
                menu(2)
                break
    elif warm==2:
        while True:
            lcd.move_to(5,0)
            lcd.putstr("[OBJE]")
            lcd.move_to(0,1)
            lcd.putstr("valor :")
            lcd.move_to(9,1)
            lcd.putstr(str(k))
            if back.value()==True and m==2:
                lcd.clear()
                vari=pID
                menu(2)
                break
            #Solucionar problema de sumar con encoder
            """wE = cLK.value() 
            elif  wE != lST: 
                if wE != dAt.value(): #giro derecha 
                    k = k+1
                    if k>150:
                        k=150
                    continue
                else:           #giro izquierda
                    k = k-1
                    if k<0:
                        k=0
                    continue
            lST = wE"""
            

        
    
menu(4)

while True:
    if back.value()==True:
        if m==0 or m==1 or m==2:
            lcd.clear()
            vari=mENU
            menu(4)
            continue

    sT = cLK.value()  
    if  sT != lST: 
        if sT != dAt.value(): #giro derecha 
            menu(1)
            continue
        else:           #giro izquierda
            menu(2)
            continue
    lST = sT
    
#Organizar info