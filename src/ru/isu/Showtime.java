package ru.isu;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Сергей
 */

public class Showtime implements Runnable {
    /**
     * Количество рядов в зале
     */
    final private int numberOfRows;
    /**
     * Количество мест в ряде
     */
    final private int numberOfSeats;
    /**
     * Свободные места
     */
    private Set<Seat> freeSeats;
    private static final Object lock = new Object();

    /**
     * Конструктор кинозала
     * @param numberOfRows - количетство рядов
     * @param numberOfSeats - количество мест в ряде
     */
    public Showtime(int numberOfRows, int numberOfSeats) {
        this.numberOfRows = numberOfRows;
        this.numberOfSeats = numberOfSeats;
        freeSeats = new HashSet<>();
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfSeats; j++) {
                freeSeats.add(new Seat(i + 1, j + 1));
            }
        }
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    /**
     * Бронирование места
     * @param seat - место, которое хотим забронировать
     * @return true - место удачно забронировали, false - место уже было забронировано
     */
    public boolean bookSeat(Seat seat) {
        if (freeSeats.contains(seat)) {
            seat.setOccupied(true);
            freeSeats.remove(seat);
            System.out.println("booking " + seat.toString());
            return true;
        }
        System.out.println("place is occupied");
        return false;
    }

    /**
     * Бронируем все места
     */
    @Override
    public void run() {
        for (int i = 0; i < getNumberOfRows(); i++) {
            for (int j = 0; j < getNumberOfSeats(); j++) {
                synchronized(lock){
                    bookSeat(new Seat(i + 1, j + 1));
                }
            }
        }
    }
}
