
/**
 * 23404724 - Ronan Kenny
 * 
 * this is the main test class 
 * 
 */
public class TravelIreland
{

    public static void main(String[] args){

        // I hard coded some trips to test the functionality
        Trip trip1 = new Trip("Galway","Dublin","19/11/24","14:00","17:00","19/11/24",20 , 1234);
        Trip trip2 = new Trip("Galway","Athlone","19/11/24","10:00","12:00","19/11/24",15,5678);
        Trip trip3 = new Trip("Galway","Cork","19/11/24","23:00","01:00","20/11/24",31 ,9101);
        Trip trip4 = new Trip("Belfast","Cork","10/11/24","20:00","01:00","11/11/24",35 ,4321);
        Trip trip5 = new Trip("Dublin","Galway","22/11/24","08:35","11:15","22/11/24",15 ,9876);
        Trip trip6 = new Trip("Tuam","Galway","2/12/24","12:10","01:30","2/12/24",15 ,1738);

        
        // constructors for three example  bus vendors 
        BusVendor be = new Bus_Eireann();
        BusVendor gb = new Go_Bus();
        BusVendor cl = new City_Link();
        
        
        // adding trips to bus services
        // I only added one to make it more concise, but you can add more to test

       // be.addTrip(trip1);
           be.addTrip(trip2);

       // gb.addTrip(trip3);
           gb.addTrip(trip4);

       // cl.addTrip(trip5);
            cl.addTrip(trip6);

        // displaying all the trips available for each vendor 
        System.out.println(be.getAllTrips());
        System.out.println(gb.getAllTrips());
        System.out.println(cl.getAllTrips());
        System.out.println("======================================");

        // selecting trips for bookings
        // specific trips are chosen based on their ID numbers 
        Trip selectedBE = be.getTrip(5678);
        Trip selectedGB = gb.getTrip(4321);
        Trip selectedCL = cl.getTrip(1738);

        // creating the bookings by passing the chosen trip and the amount of passengers we have 
        Booking bookingBE = new Booking(selectedBE,20);
        Booking bookingGBF= new Booking(selectedGB,61);// should not work as it wants more than 60 seats GBF -> go bus false
        Booking bookingGBT = new Booking(selectedGB,20);// works -> go bus True 
        Booking bookingCL1 = new Booking(selectedCL,40);// works 
        Booking bookingCL2 = new Booking(selectedCL,21);// doesnt work if used with CL1 aswell . Is there to show that if there isnt enough available seats the booking wont be confirmed

       // using the confirm method on the bookings 
       // this method checks if we can confirm the booking based on the availability of seats on the trips
       // arguments are the booking and the bus vendor 
       confirm(bookingBE,be);// -> works
      // confirm(bookingCL1,cl);//-> works
       confirm(bookingCL2,cl);// works
       //confirm(bookingGBT,gb);// -> works
       confirm(bookingGBF,gb);// -> doesn't work as request 61 seats
       
       // prints available trips after booking showing new seat availability 
       System.out.println(be.getAllTrips());
       System.out.println(gb.getAllTrips());
       System.out.println(cl.getAllTrips());
       System.out.println("======================================");




    }

    // method for confirming Bookings and printing messages
    public static void confirm(Booking booking,BusVendor vendor){
        // the specific booking and bus vendor are passed as arguments -> will be Bus eireann Go bus or City Link. 
        // we then use the bus vendors makeBooking method which is the bookingTrips method
        boolean confirmed = vendor.makeBooking(booking);
        if(confirmed){
            System.out.println("=====================================\n");
            System.out.println("----"+vendor.vendor+"-------");
            System.out.println("Booking Confirmed\nBooking info:");
            System.out.println("Number of Passengers: "+booking.getNoPassengers());
            System.out.println("Travelling from ["+booking.getStartLocation()+"] to ["+booking.getEndLocation()+"]");
            System.out.println("Trip ID: "+booking.getTripID());
            System.out.println("Fare: "+booking.getFare());
            System.out.println("Total cost: $"+booking.getTotalCost());
            System.out.println("==============================================\n");
        }
        else {
            System.out.println("----"+vendor.vendor+"-------");
            System.out.println("Booking Failed");
            System.out.println("There isn't enough available seats");
            System.out.println("Available seats: " + booking.getSeats());
            System.out.println("Seats requested: " + booking.getNoPassengers());
            System.out.println("=========================================\n");
        }

    }

}
