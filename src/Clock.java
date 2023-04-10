public class Clock {
    int currentHour;
    int currentMinute;

    Clock() {
        currentHour = currentMinute = 0;
    }

    Clock(int hour, int minutes) {
        this.currentHour = hour;
        this.currentMinute = minutes;
    }

    public String setTime(int hour, int minute) {
        String result;
        if (minute < 10) {
            result = "Текущее время " + hour + " : " + "0" + minute;
        } else {
            result = "Текущее время " + hour + " : " + minute;
        }
        return result;
    }

    public String checkBells(int hour, int minute) {
        String result = "";
        if (hour == 0) {
            hour = 24;
        }
        if (minute == 0) {
            if (hour < 12) {
                result = "Часы просигналят " + hour % 12 + " раз";
            } else if (hour > 12) {
                result = "Часы просигналят " + (hour - 12) + " раз";
            }
        } else if (minute == 15) {
            result = "Часы просигналят 1 раз";
        } else {
            result = "До времени сигнала часов " + (15 - minute % 15) + " мин";
        }
        return result;
    }
}
