import java.util.*;
abstract class Payment{
    public String payment_method;
    public double amount;
    Payment(String payment_method, double amount){
        this.payment_method = payment_method;
        this.amount = amount;
    }
    abstract void processPayment();
}
class Passenger{
    private int passenger_ID;
    public String passenger_name;
    public String passenger_number;
    public String passenger_email;
    Passenger(int passenger_ID, String passenger_name, String passenger_number, String passenger_email){
        this.passenger_ID = passenger_ID;
        this.passenger_name = passenger_name;
        this.passenger_number = passenger_number;
        this.passenger_email = passenger_email;
    }
    public int getPassenger_ID() {
        return passenger_ID;
    }
    public void setPassenger_ID(int passenger_ID) {
        this.passenger_ID = passenger_ID;
    }
}
class Booking{
    private int booking_Id;
    Passenger passenger;
    public String booking_type;
    Date booking_date;
    public String slot;
    int seatcount;
    int limitedseat=100;
    Booking(int booking_Id, Passenger passenger, String booking_type, Date booking_date, String slot, int seatcount){
        this.booking_Id = booking_Id;
        this.passenger = passenger;
        this.booking_type = booking_type;
        this.booking_date = booking_date;
        this.slot = slot;
        this.seatcount = seatcount;
    }
    public int getBooking_Id() {
        return booking_Id;
    }
    public void setBooking_Id(int booking_Id) {
        this.booking_Id = booking_Id;
    }
    public void bookingflight(){
        if(seatcount<=limitedseat) System.out.println("Seats are available. You can Book!");
        else System.out.println("Seats are not available. Wait for the next flight!");
    }
   public void bookingdetails(){
    System.out.println("--------------------Booking Details---------------------------");
    System.out.println("Booking Id: "+booking_Id);
    System.out.println("Passenger ID: "+passenger.getPassenger_ID());
    System.out.println("Passenger Name: "+passenger.passenger_name);
    System.out.println("Passenger Number: "+passenger.passenger_number);
    System.out.println("Passenger Email: "+passenger.passenger_email);
    System.out.println("Booking Type: (Economy class, Business class, First class)"+booking_type);
    System.out.println("Booking Date: "+booking_date);
    System.out.println("Slot: (Morning, Afternoon, Evening)"+slot);
    System.out.println("Seat Count: "+seatcount);
    System.out.println("Your booking is successful");
    System.out.println("--------------------------------------------------------------");
   }
}
class Card extends Payment{
    Booking booking;
    Passenger passenger;
    Card(String payment_method, double amount, Booking booking, Passenger passenger){
        super(payment_method, amount);
        this.booking = booking;
        this.passenger = passenger;
    }
    void processPayment(){
        System.out.println("--------------------Payment Details---------------------------");
        System.out.println("Passenger ID: "+passenger.getPassenger_ID());
        System.out.println("Booking ID: "+booking.getBooking_Id());
        System.out.println("Payment Method: "+payment_method);
        System.out.println("Processing card payment of amount: "+amount+" for passenger: "+passenger.passenger_name);
        System.out.println("Payment successful!");
        System.out.println("--------------------------------------------------------------");
    }
}
class UPI extends Payment{
    Booking booking;
    Passenger passenger;
    UPI(String payment_method, double amount, Booking booking, Passenger passenger){
        super(payment_method, amount);
        this.booking = booking;
        this.passenger = passenger;
    }
    void processPayment(){
        System.out.println("--------------------Payment Details---------------------------");
        System.out.println("Passenger ID: "+passenger.getPassenger_ID());
        System.out.println("Booking ID: "+booking.getBooking_Id());
        System.out.println("Payment Method: "+payment_method);
        System.out.println("Processing UPI payment of amount: "+amount+" for passenger: "+passenger.passenger_name);
        System.out.println("Payment successful!");
        System.out.println("--------------------------------------------------------------");
    }
}
class Cash extends Payment{
    Booking booking;
    Passenger passenger;
    Cash(String payment_method, double amount, Booking booking, Passenger passenger){
        super(payment_method, amount);
        this.booking = booking;
        this.passenger = passenger;
    }
    void processPayment(){
        System.out.println("--------------------Payment Details---------------------------");
        System.out.println("Passenger ID: "+passenger.getPassenger_ID());
        System.out.println("Booking ID: "+booking.getBooking_Id());
        System.out.println("Payment Method: "+payment_method);
        System.out.println("Processing cash payment of amount: "+amount+" for passenger: "+passenger.passenger_name);
        System.out.println("Payment successful!");
        System.out.println("--------------------------------------------------------------");
    }
}
class AirLine{
    public String airline_name;
    public String airline_code;
    AirLine(String airline_name, String airline_code){
        this.airline_name = airline_name;
        this.airline_code = airline_code;
    }
    public void airlinedetails(){
        System.out.println("--------------------Airline Details---------------------------");
        System.out.println("Airline Name: "+airline_name);
        System.out.println("Airline Code: "+airline_code);
        System.out.println("--------------------------------------------------------------");
    }
}
class Flight{
    public String flight_number;
    public String source;
    public String destination;
    public Date departure_time;
    public Date arrival_time;
    Flight(String flight_number, String source, String destination, Date departure_time, Date arrival_time){
        this.flight_number = flight_number;
        this.source = source;
        this.destination = destination;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
    }
    public void flightdetails(){
        System.out.println("--------------------Flight Details---------------------------");
        System.out.println("Flight Number: "+flight_number);
        System.out.println("Source: "+source);
        System.out.println("Destination: "+destination);
        System.out.println("Departure Time: "+departure_time);
        System.out.println("Arrival Time: "+arrival_time);
        System.out.println("--------------------------------------------------------------");
    }
}

public class FlightBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Passesnger ID:");
        int passenger_ID = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Passenger Name:");
        String passenger_name = sc.nextLine();
        System.out.println("Enter Passenger Number:");
        String passenger_number = sc.nextLine();
        System.out.println("Enter Passenger Email:");
        String passenger_email = sc.nextLine();
        Passenger passenger = new Passenger(passenger_ID, passenger_name, passenger_number, passenger_email);
        System.out.println("Enter Booking ID:");
        int booking_Id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Booking Type: (Economy class, Business class, First class)");
        String booking_type = sc.nextLine();
        System.out.println("Enter Booking Date (dd/MM/yyyy):");
        Date booking_date = new Date();
        System.out.println("Enter Slot: (Morning, Afternoon, Evening)");
        String slot = sc.nextLine();
        System.out.println("Enter Seat Count:");
        int seatcount = sc.nextInt();
        Booking booking = new Booking(booking_Id, passenger, booking_type, booking_date, slot, seatcount);
        System.out.println("Enter Payment Method: (Card, UPI, Cash)");

        String payment_method = sc.next();
        System.out.println("Enter Payment Amount:");
        double amount = sc.nextDouble();
        Card card = new Card(payment_method, amount, booking, passenger);
        UPI upi = new UPI(payment_method, amount, booking, passenger);
        Cash cash = new Cash(payment_method, amount, booking, passenger);
        System.out.println("Enter Airline Name:");
        String airline_name = sc.next();
        System.out.println("Enter Airline Code:");
        String airline_code = sc.next();
        AirLine airline = new AirLine(airline_name, airline_code);
        System.out.println("Enter Flight Number:");
        String flight_number = sc.next();
        System.out.println("Enter Source:");
        String source = sc.next();
        System.out.println("Enter Destination:");
        String destination = sc.next();
        System.out.println("Enter Departure Time (dd/MM/yyyy HH:mm):");
        Date departure_time = new Date();
        System.out.println("Enter Arrival Time (dd/MM/yyyy HH:mm):");
        Date arrival_time = new Date();
        Flight flight = new Flight(flight_number, source, destination, departure_time, arrival_time);
        System.out.println("Enter the Choice : 1. Add Passenger 2. Add Booking 3. Add Payment 4. Add Airline 5. Add Flight");
        int choice = sc.nextInt();
        switch(choice){
            case 1: 
                passenger = new Passenger(passenger_ID, passenger_name, passenger_number, passenger_email);
                System.out.println("--------------------Passenger Details---------------------------");
                System.out.println("Passenger ID: "+passenger.getPassenger_ID());
                System.out.println("Passenger Name: "+passenger.passenger_name);
                System.out.println("Passenger Number: "+passenger.passenger_number);
                System.out.println("Passenger Email: "+passenger.passenger_email);
                System.out.println("Passenger added successfully!");
                System.out.println("--------------------------------------------------------------");
                break;
            case 2:
                System.out.println("----------------------------------------------------------");
                booking.bookingflight();
                booking.bookingdetails();
                break;
            case 3:
                if(payment_method.equals("Card")) card.processPayment();
                else if(payment_method.equals("UPI")) upi.processPayment();
                else if(payment_method.equals("Cash")) cash.processPayment();
                break;
            case 4:
                airline.airlinedetails();
                break;
            case 5:
                flight.flightdetails();
                break;
            default:
                System.out.println("Invalid Choice!");
        }
    
        sc.close();
    }
    
}
