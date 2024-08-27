
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class Hotel {
    protected String name;
    protected String Location;
    protected HashMap<Integer, Room> Rooms = new HashMap<>();

    protected Hotel(String name, String Location) {

        this.name = name;
        this.Location = Location;
    }
}

class Receptionist {

    protected HashMap<String, Booking> bookings = new HashMap<>();

    private Scanner sc = new Scanner(System.in);
    Booking booking = new Booking();
    protected int guest_Total_Rooms;
    private Hotel hotel;

    protected Receptionist(Hotel hotel) {
        this.hotel = hotel;
    }

    protected void addBooking() {

        LocalDate check_In_Date;
        LocalDate check_Out_Date;

        System.out.println();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("NOTE:- Enter a date in the format dd-MM-yyyy\n");

        System.out.print("Enter check in date: ");
        String dateInput = sc.nextLine();

        try {

            check_In_Date = LocalDate.parse(dateInput, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in the format dd-MM-yyyy.");
            return;
        }

        System.out.print("Enter check out date: ");
        String dateinput = sc.nextLine();

        try {

            check_Out_Date = LocalDate.parse(dateinput, formatter);

        } catch (DateTimeParseException e) {

            System.out.println("Invalid date format. Please enter the date in the format dd-MM-yyyy.");
            return;
        }

        int guest;

        System.out.print("Enter number of guests: ");
        guest = sc.nextInt();

        guest_Total_Rooms = (guest / 2) + (guest % 2);
        sc.nextLine();

        if (Is_Availabls(check_In_Date, check_Out_Date)) {

            System.out.println();
            System.out.println("Guest total rooms: " + guest_Total_Rooms);
            System.out.println("Price:- " + total_Amount(0.0, guest));
            booking.addBooking();
            bookings.put(booking.bookingId, booking);

            System.out.println();
            System.out.println(booking.guest.name + " have successfully booked the room");
            System.out.println("Booking ID: " + booking.bookingId);

        } else {

            System.out.println();
            System.out.println("Sorry the rooms not available!");
        }

        return;
    }

    protected void cancelBooking(String bookingId) {

        if (bookings.containsKey(bookingId)) {

            bookings.remove(bookingId);
            System.out.println();
            System.out.println("Your booking is successfully cancel");
        } else {

            System.out.println();
            System.out.println("Invalid Bookind ID!, Please try again");
        }

        return;
    }

    protected void getBooking(String bookingId) {

        if (bookings.containsKey(bookingId)) {

            System.out.println();
            System.out.println("Name: " + bookings.get(bookingId).guest.name);
            System.out.println("Address: " + bookings.get(bookingId).guest.address);
            System.out.println("Id: " + bookings.get(bookingId).guest.Id);
            System.out.println("Phone No.: " + bookings.get(bookingId).guest.phone_NO);
            System.out.println("Booking ID: " + bookings.get(bookingId).bookingId);

        } else {

            System.out.println();
            System.out.println("Invalid Booking ID, Please try again");
        }
        return;
    }

    protected boolean Is_Availabls(LocalDate check_In_Date, LocalDate check_Out_Date) {

        int in_day = check_In_Date.getDayOfMonth();
        int out_day = check_Out_Date.getDayOfMonth();
        int count = 0;

        if (hotel.Rooms.size() < guest_Total_Rooms) {

            return false;

        } else if (bookings.size() != 0) {

            Set<String> keys = bookings.keySet();

            while (in_day != out_day) {

                for (String key : keys) {

                    if (bookings.get(key).check_Out_Date != check_In_Date

                            || bookings.get(key).check_In_Date != check_Out_Date) { // 23-09-2024

                        count++;
                    }

                }

                if (guest_Total_Rooms <= (count - hotel.Rooms.size())) {

                    check_In_Date = LocalDate.of(check_In_Date.getYear(), check_In_Date.getMonthValue(), in_day++);
                } else {

                    return false;
                }

            }
            return true;
        }

        return true;
    }

    protected double total_Amount(double amount, int guest) {

        int sum = 0;

        if (guest >= 3) {

            guest = guest / 2;
            amount = guest * 2500;
            sum = guest % 2;
            amount += sum * 400;
            guest_Total_Rooms = guest;

        }

        return amount;
    }
}

class Room {

    protected Integer room_No; // 5
    protected double price; // single = 1500, double = 2500

}

class Booking {

    protected String bookingId;
    protected Integer person;
    protected Integer guestId;
    protected LocalDate check_In_Date;
    protected LocalDate check_Out_Date;
    Scanner sc = new Scanner(System.in);
    Guest guest = new Guest();
    Room room = new Room();

    protected void addBooking() {

        Random random = new Random();
        System.out.println();
        System.err.print("Entar Name: ");
        guest.name = sc.nextLine();

        System.err.print("Enter Address: ");
        guest.address = sc.nextLine();

        System.err.print("Enter Id: ");
        guest.Id = sc.nextInt();

        System.err.print("Enter Phone No.: ");
        guest.phone_NO = sc.nextInt();

        bookingId = String.valueOf(random.nextInt(1000000000));

        return;
    }

}

class Guest {
    protected String name;
    protected Integer Id;
    protected String address;
    protected Integer phone_NO;

}

public class Hotel_Reserevation_System {
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
    public static final String BOLD = "\u001B[1m";

    public static void menu() {

        System.out.println();
        System.out.println("1. Add Booking");
        System.out.println("2. Cancel Booking");
        System.out.println("3. Get Booking");
        System.out.println("4. Exit");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Hotel hotel = new Hotel("The Grand Mehfil Hotel",
                "Camp Rd, next to dayasagar hospital, Maltekdi, Amravati, Maharashtra 444602");

        System.out.println(BOLD + GREEN +
                "\n===============================*** WELCOME TO HOTEL RESEREVATION SYSYTEM ***===============================\n\n"
                + RESET);
        System.out.println(BOLD + "Name:- " + hotel.name + RESET);
        System.out.println(BOLD + "Location:- " + hotel.Location + RESET);

        Receptionist receptionist = new Receptionist(hotel);
        Room room = new Room();

        for (int i = 1; i <= 4; i++) {

            room.room_No = i;
            room.price = 2500.0;

            hotel.Rooms.put(room.room_No, room);
        }

        int choise = 0;
        String bookingid;

        while (choise != 10) {

            menu();
            System.out.print("Enter choise: ");
            choise = sc.nextInt();

            sc.nextLine();
            switch (choise) {
                case 1:

                    receptionist.addBooking();
                    break;
                case 2:

                    System.out.print("Enter booking Id: ");
                    bookingid = sc.nextLine();

                    receptionist.cancelBooking(bookingid);
                    break;
                case 3:

                    System.out.print("Enter booking Id: ");
                    bookingid = sc.nextLine();

                    receptionist.getBooking(bookingid);

                    break;
                case 4:
                    sc.close();
                    System.out.println("\nTHANK YOU FOR USEING HOTEL RESEREVATION SYSYTEM.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choise, Please try again");
                    break;
            }
        }
    }
}
