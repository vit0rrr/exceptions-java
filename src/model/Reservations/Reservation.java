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

    public String updateDates(Date checkInDate, Date checkOutDate) {
        Date now = new Date();
        if (checkInDate.before(now) || checkOutDate.before(now)) {
            return "Reservation dates for update must be future dates.";
        }
        if (!checkOutDate.after(checkInDate)) {
            return "Check-out date must be after check-in date.";
        } 
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        return null;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + ", check-in: " + sdf.format(checkInDate) + ", check-out: " + sdf.format(checkOutDate);
    }
}