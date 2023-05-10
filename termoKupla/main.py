import time
# import ntptime
import _thread as th
from machine import Pin, I2C, PWM
from max6675 import MAX6675
# ------------------- PIN ASSIGNMENT ------------------ #
PIN_SO = Pin(12, Pin.IN)
PIN_SCK = Pin(14, Pin.OUT)
PIN_CS = Pin(15, Pin.OUT)
# ----------------------------------------------------- #

# MAX6675 CONFIGURATION
max6675 = MAX6675(PIN_SCK, PIN_CS, PIN_SO)

# VARIABLES
setpoint = 100
temperature = 0
pid_error = 0
pid_value = 0
integral = 0
derivative = 0
kp = 1 # <- Proportional value
ki = 0.1 # <- Integral value
kd = 0.01 # <- Derivative value
dt = 1
# ----------------------------------------------------- #

def read_temperature(e):
    while True:
        global temperature
        print("[Sensors] -> Reading temperature...")
        temperature = round(max6675.read(), 1)
        time.sleep(e)
th.start_new_thread(read_temperature, (dt,))

def pid_calculus(e):
    while True:
        global pid_error, pid_value, setpoint, temperature, integral, derivative, kp, ki, kd
        print("[Control] -> Making PID...")
        pid_error = setpoint - temperature
        integral += pid_error * dt
        derivative = (pid_error - derivative) / dt
        pid_value = kp * pid_error + ki * integral + kd * derivative
        temperature += pid_value
        time.sleep(e)
th.start_new_thread(pid_calculus, (dt,))

def main():
    while True:
        # ntptime.settime() # <-- Time synchronization
        # ntptime.host = "2.co.pool.ntp.org"
        global temperature, pid_value
        localTime = time.localtime()
        ISOTime = time.mktime(localTime)
        time.sleep(2)
        
if __name__ == '__main__':
    main()