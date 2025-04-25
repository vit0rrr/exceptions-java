package model.Reservations;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    private int roomNumber;
    private Date checkInDate;
    private Date checkOutDate;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(int roomNumber, Date checkInDate, Date checkOutDate) {
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public void updateDates(Date checkInDate, Date checkOutDate) {
        if (!checkOutDate.after(checkInDate)) {
            throw new IllegalArgumentException("Check-out date must be after check-in date.");
        }
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + ", check-in: " + sdf.format(checkInDate) + ", check-out: " + sdf.format(checkOutDate);
    }
}