import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Scanner scan3 = new Scanner(System.in);
        Scanner scan4 = new Scanner(System.in);
        String sHour, sMinute, sAlarnHour, sAlarmMinute;
        int hour, minute, alarmHour, alarmMinute, error;
        hour = minute = alarmHour = alarmMinute = -1;
        // установка текущего времени и времени будильника
        do {
            System.out.println("Установите текущее время");
            do {
                System.out.println("Введите значение часов");
                sHour = scan1.next();
                try {
                    hour = Integer.parseInt(sHour.trim());
                    error = 0;
                } catch (NumberFormatException nfe) {
                    System.out.println("Error");
                    error = 1;
                }
                if (hour < 0 || hour > 23) {
                    System.out.println("Неверное значение часов");
                    error = 1;
                }
            } while (error == 1);
            do {
                System.out.println("Введите значение минут");
                sMinute = scan2.next();
                try {
                    minute = Integer.parseInt(sMinute.trim());
                    error = 0;
                } catch (NumberFormatException nfe) {
                    System.out.println("Error");
                    error = 1;
                }
                if (minute < 0 || minute > 59) {
                    System.out.println("Неверное значение минут");
                    error = 1;
                }
            } while (error == 1);
            System.out.println("Установите время будильника");
            do {
                System.out.println("Введите значение часов");
                sAlarnHour = scan3.next();
                try {
                    alarmHour = Integer.parseInt(sAlarnHour.trim());
                    error = 0;
                } catch (NumberFormatException nfe) {
                    System.out.println("Error");
                    error = 1;
                }
                if (alarmHour < 0 || alarmHour > 23) {
                    System.out.println("Неверное значение часов");
                    error = 1;
                }
            } while (error == 1);
            do {
                System.out.println("Введите значение минут");
                sAlarmMinute = scan4.next();
                try {
                    alarmMinute = Integer.parseInt(sAlarmMinute.trim());
                    error = 0;
                } catch (NumberFormatException nfe) {
                    System.out.println("Error");
                    error = 1;
                }
                if (alarmMinute < 0 || alarmMinute > 59) {
                    System.out.println("Неверное значение минут");
                    error = 1;
                }
            } while (error == 1);
        } while (error == 1);

        scan1.close();
        scan2.close();
        scan3.close();
        scan4.close();
        // создаем экзампляр часов
        Clock clock = new Clock(hour, minute);
        System.out.println(clock.setTime(clock.currentHour, clock.currentMinute));
        System.out.println(clock.checkBells(clock.currentHour, clock.currentMinute));
        // создаем экземпляр будильника
        AlarmClock alarmClock = new AlarmClock(alarmHour, alarmMinute);
        System.out.println(alarmClock.setAlarm(alarmClock.alarmHour, alarmClock.alarmMinute));
        System.out.println(alarmClock.checkAlarm(alarmClock.alarmHour, alarmClock.alarmMinute,
                clock.currentHour, clock.currentMinute));
    }
}