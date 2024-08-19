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
    protected int rooms;
    protected HashMap<Integer, Room> Rooms = new HashMap<>();
    protected HashMap<Integer, Room> availabls_Rooms = new HashMap<>();

    private Scanner sc = new Scanner(System.in);

    public int viewRoom(int guest, double amount) {

        System.out.println();
        System.out.print("Enter number guest: ");
        guest = sc.nextInt();

        for (int i = 1; i <= Rooms.size(); i++) {

            if (guest == 2) {

                if (Rooms.get(i).room_Type == "Double Room") {
                    System.out.println();
                    System.out.println("Room Type: " + Rooms.get(i).room_Type);
                    System.out.println("Price: " + Rooms.get(i).price);
                    rooms = 1;
                    return i;
                }

            } else if (guest > 2) {

                int sum = 0;

                if (Rooms.get(i).room_Type == "Double Room") {

                    System.out.println();

                    if (guest % 2 == 0) {

                        guest = guest / 2;
                        amount = guest * Rooms.get(i).price;
                    } else {

                        guest = guest / 2;
                        amount = guest * Rooms.get(i).price;
                        sum = guest % 2;
                        amount += sum * 400;
                    }

                    System.out.println("Room Type: " + Rooms.get(i).room_Type);
                    System.out.println("Price: " + amount);
                    System.out.println("Rooms: " + guest);
                    rooms = guest;

                    return i;
                }

            } else {

                if (Rooms.get(i).room_Type == "Single Room") {

                    System.out.println();
                    System.out.println("Room Type: " + Rooms.get(i).room_Type);
                    System.out.println("Price: " + Rooms.get(i).price);
                    rooms = 1;
                    return i;
                }
            }

        }

        return 1;
    }
}

class Receptionist extends Hotel {

    protected HashMap<String, Booking> bookings = new HashMap<>();

    private Scanner sc = new Scanner(System.in);
    protected Booking booking = new Booking();

    protected void addBooking(String room_Type, LocalDate check_In_Date, LocalDate check_Out_Date) {

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

        int x = viewRoom(0, 0);

        if (availabls_Rooms.size() < rooms || Rooms.size() < rooms) {

            System.out.println("Sorry the rooms are not availabls!");

        } else if (availabls_Rooms.size() == 0) {

            if (Is_Availabls(check_In_Date, check_Out_Date)) {

                booking.addBooking(Rooms.get(x).room_Type);
                booking.price = Rooms.get(x).price;

                booking.check_In_Date = check_In_Date;
                booking.check_Out_Date = check_Out_Date;
                bookings.put(booking.bookingId, booking);

                System.out.println();
                System.out.println(booking.guest.name + " have successfully booked " + booking.room_Type);
                System.out.println("Booking ID: " + booking.bookingId);

            } else {

                System.out.println("Sorry the room is not availabls in " + check_In_Date);
            }
        } else {

            for (int j = 1; j <= availabls_Rooms.size(); j++) {

                if (availabls_Rooms.get(j).room_Type == Rooms.get(x).room_Type) {

                    availabls_Rooms.remove(j);
                    rooms--;
                    if (rooms == 0) {
                        break;
                    }

                }
            }

            if (rooms == 0) {

                booking.addBooking(Rooms.get(x).room_Type);
                booking.price = Rooms.get(x).price;

                booking.check_In_Date = check_In_Date;
                booking.check_Out_Date = check_Out_Date;
                bookings.put(booking.bookingId, booking);

                System.out.println();
                System.out.println(booking.guest.name + " have successfully booked " + booking.room_Type);
                System.out.println("Booking ID: " + booking.bookingId);

            } else {

                System.out.println("Sorry the rooms are not availabls!");
            }
        }
        return;
    }

    protected void cancelBooking(String bookingId) {

        if (bookings.containsKey(bookingId)) {

            bookings.remove(bookingId);
            System.out.println("Your booking is successfully cancel");
        } else {

            System.out.println("Invalid Bookind ID!, Please try again");
        }

        return;
    }

    protected void getBooking(String bookingId) {

        if (bookings.containsKey(bookingId)) {

            System.out.println();
            System.out.println("Name: " + booking.guest.name);
            System.out.println("Address: " + booking.guest.address);
            System.out.println("Id: " + booking.guest.Id);
            System.out.println("Phone No.: " + booking.guest.phone_NO);
            System.out.println("Booking ID: " + booking.bookingId);
            System.out.println("Room Type: " + booking.room_Type);

        } else {

            System.out.println("Invalid Booking ID, Please try again");
        }
        return;
    }

    protected boolean Is_Availabls(LocalDate check_In_Date, LocalDate check_Out_Date) {

        Set<String> keys = bookings.keySet();

        for (String key : keys) {

            if (bookings.get(key).check_Out_Date.getYear() < check_In_Date.getYear()) {

            } else if (bookings.get(key).check_Out_Date.getDayOfMonth() <= check_In_Date.getDayOfMonth()) {

                if (bookings.get(key).check_Out_Date.getDayOfMonth() <= check_In_Date.getDayOfMonth()) {

                    System.out.println();
                    System.out.println(
                            bookings.get(key).room_Type + " type of room is availabls in " + check_In_Date);
                    System.out.println("You have to check in after 12:00 PM");

                    return true;

                } else {
                    return false;
                }
            }

        }
        return true;
    }
}

class Room {

    protected Integer room_No; // 5
    protected String room_Type; // single = 2 , double = 3
    protected double price; // single = 1500, double = 2500

}

class Booking extends Room {

    protected String bookingId;
    protected Integer person;
    protected Integer guestId;
    protected LocalDate check_In_Date;
    protected LocalDate check_Out_Date;
    Scanner sc = new Scanner(System.in);
    Guest guest = new Guest();

    protected void addBooking(String room_type) {

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

        room_Type = room_type;

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

    public static void menu() {

        System.out.println();
        System.out.println("1. Add Booking");
        System.out.println("2. Cancel Booking");
        System.out.println("3. Get Booking");
        System.out.println("4. Exit");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Receptionist receptionist = new Receptionist();

        receptionist.name = "The Grand Mehfil";
        receptionist.Location = "Camp Rd, next to dayasagar hospital, Maltekdi, Amravati, Maharashtra 444602";

        for (int i = 1; i <= 2; i++) {
            Room room = new Room();

            room.room_No = i;
            room.price = 1500.0;
            room.room_Type = "Single Room";

            receptionist.Rooms.put(room.room_No, room);
        }

        for (int i = 3; i <= 4; i++) {
            Room room = new Room();
            room.room_No = i;
            room.price = 2500.0;
            room.room_Type = "Double Room";

            receptionist.Rooms.put(room.room_No, room);
        }

        receptionist.availabls_Rooms.putAll(receptionist.Rooms);

        System.out.println(
                "===============================*** WELCOME TO HOTEL RESEREVATION SYSYTEM ***===============================\n\n");
        System.out.println("Hotel Name: " + receptionist.name);
        System.out.println("Location: " + receptionist.Location);

        int choise = 0;
        String bookingid;

        while (choise != 10) {

            menu();
            System.out.print("Enter choise: ");
            choise = sc.nextInt();

            sc.nextLine();
            switch (choise) {
                case 1:

                    receptionist.addBooking(null, null, null);

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
