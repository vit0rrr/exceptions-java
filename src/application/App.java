package application;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.Reservations.Reservation;



public class App {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkInDate = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOutDate = sdf.parse(sc.next());


        if(!checkOutDate.after(checkInDate)){
            System.out.println("Error in reservation: Check-out date must be after check-in date.");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkInDate, checkOutDate);
            System.out.println("Reservation: " + reservation);
        
            System.err.println();
            System.err.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkInDate = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOutDate = sdf.parse(sc.next());

            reservation.updateDates(checkInDate, checkOutDate);
            System.out.println("Reservation: " + reservation);

            
        }

    }
}
