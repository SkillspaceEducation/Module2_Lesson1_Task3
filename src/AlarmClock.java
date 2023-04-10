public class AlarmClock extends Clock {
    int alarmHour;
    int alarmMinute;

    AlarmClock(int hour, int minute) {
        this.alarmHour = hour;
        this.alarmMinute = minute;
    }

    public String setAlarm(int hour, int minute) {
        String result;
        if (minute < 10) {
            result = "Будильник установлен на время " + hour + " : " + "0" + minute;
        } else {
            result = "Будильник установлен на время " + hour + " : " + minute;
        }
        return result;
    }

    public String checkAlarm(int alrHour, int alrMinute, int curHour, int curMinute) {
        String result = "";
        int deltaHour, deltaMinute;
        if (alrHour == 0) {
            alrHour = 24;
        }
        if (curHour == 0) {
            curHour = 24;
        }
        deltaHour = alrHour - curHour;
        deltaMinute = alrMinute - curMinute;
        // если текущее время и время будильника равны, будильник сработает
        if (alrHour == curHour && alrMinute == curMinute) {
            result = "Будильник сработал";
            // иначе определяем через какое время сработает будильник
        } else {
            if (alrHour == curHour && alrMinute < curMinute) {
                deltaHour = 24 - curHour + alrHour;
                deltaMinute = 60 - curMinute + alrMinute;
                result = "Будильник сработает через " + (deltaHour - 1) + " ч " + deltaMinute + " мин";
            }
            if (alrHour == curHour && deltaMinute > 0) {
                result = "Будильник сработает через " + deltaMinute + " мин";
            } else if (deltaHour == 1) {
                if (deltaMinute < 0) {
                    deltaMinute = 60 - curMinute + alrMinute;
                    result = "Будильник сработает через " + deltaMinute + " мин";
                } else {
                    result = "Будильник сработает через " + deltaHour + " ч " + deltaMinute + " мин";
                }
            } else if (deltaHour > 1) {
                if (deltaMinute >= 0) {
                    result = "Будильник сработает через " + deltaHour + " ч " + deltaMinute + " мин";
                } else {
                    deltaMinute = 60 - curMinute + alrMinute;
                    result = "Будильник сработает через " + (deltaHour - 1) + " ч " + deltaMinute + " мин";
                }
            } else if (deltaHour < 0) {
                deltaHour = 24 - curHour + alrHour;
                if (deltaMinute >= 0) {
                    result = "Будильник сработает через " + deltaHour + " ч " + deltaMinute + " мин";
                } else {
                    deltaMinute = 60 - curMinute + alrMinute;
                    result = "Будильник сработает через " + (deltaHour - 1) + " ч " + deltaMinute + " мин";
                }
            }
        }
        return result;
    }
}
