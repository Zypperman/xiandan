import datetime
import os

StartDate = datetime.date(2025, 5, 3)
Today = datetime.date.today()
Now = datetime.datetime.now()
current_hour, current_min = [int(i) for i in Now.strftime("%H %M").split()]
EndOfDay = datetime.timedelta(hours=22, minutes=00)

LoggedDate = Today.strftime("%d %b %Y")
Opentime = Now.strftime("%H :%M")
Logfilename = Today.strftime("%y%m%d.md")

# get number of weeks since start date


def get_week_number():
    return (Today - StartDate).days // 7 + 1


def time_left():
    current_time = datetime.timedelta(hours=current_hour, minutes=current_min)
    remaining_time = (EndOfDay - current_time).seconds
    hours = remaining_time // 3600
    mins = (remaining_time % 3600) // 60 - 1
    return [hours, mins]


hours, mins = time_left()
currentWeek = get_week_number()

logtext = f"""# {LoggedDate}

- Opened VSC at {Opentime}. ({hours} hours and {mins} minutes left to 10pm)
"""

folder_path = f"00 Devlogs/W{currentWeek}"
os.makedirs(folder_path, exist_ok=True)

with open(folder_path + "/" + Logfilename, "w") as file:
    file.write(logtext)
