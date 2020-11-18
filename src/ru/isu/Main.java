package ru.isu;

public class Main {

    public static void main(String[] args) {
        Showtime showtime = new Showtime(50, 50);
        Thread thread1 = new Thread(showtime);
        Thread thread2 = new Thread(showtime);

        thread1.start();
        thread2.start();
    }
}
