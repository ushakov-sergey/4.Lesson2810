package ru.isu;

import java.util.Objects;

/**
 * @author Сергей
 */

public class Seat {
    /**
     * номер ряда
     */

    private final int row;
    /**
     * номер места
     */
    private final int seat;
    /**
     * занято ли место
     */
    private boolean isOccupied;

    /**
     * Конструктор модели места в зале
     * @param row - количетство рядов
     * @param seat - количество мест в ряде
     */
    public Seat(int row, int seat) {
        this.row = row;
        this.seat = seat;
        isOccupied = false;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "row=" + row +
                ", seat=" + seat +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat1 = (Seat) o;
        return row == seat1.row &&
                seat == seat1.seat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, seat);
    }
}
