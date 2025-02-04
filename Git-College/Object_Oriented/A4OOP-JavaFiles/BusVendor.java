import java.util.ArrayList;

/**
 *busVendor is an abstract class that will be implemented by the concrete classes representing the actual companies
 *
 *it has methods for adding the hardcoded trips, for getting all the information about the trips and for making bookings
 *the method for bookings checks if there is enough seats available before confirming the booking
 */
public abstract class BusVendor
{
    ArrayList<Trip> tripArray = new ArrayList<>();// creating an array of the trips 
    String vendor= " ";// is updated in the subclasses -> bus eireann , city link and go bus

    // empty constructor
    public BusVendor()
    {

    }

    // setter method for adding trips to the bus companies for hard coding the trips
    public void addTrip(Trip trip){
        // trip object is passed as an arg and then added to the array
        trip.setVendor(vendor);
        tripArray.add(trip);
    }

    // method for making bookings
    // checks if there's enough free seats
    // returns a boolean-> true if there is free seats and false if not
    public boolean makeBooking(Booking booking){
        // checks if there's enough seats available before booking
        if(booking.getNoPassengers() < 0 || booking.getNoPassengers() > booking.getSeats()){
            return false;
        }
        else{
            booking.setSeats(booking.getSeats() - booking.getNoPassengers());// updates amount of seats remaining
            return true;
        }

    }
    
    // method that returns a String that contains all the info for each of the bus company's trips
    public String getAllTrips(){
        System.out.println("======================================");
        System.out.println("Available trips:");
        StringBuilder strng= new StringBuilder();// info is all added to this String which is then returned to be printed

        // loops through each trip in the array and adds it's info to the string
        for(Trip current : tripArray) {
            //current = tripArray.get();
            strng.append("Company: "+current.getVendor());
            strng.append("\n");
            strng.append("Trip ID: "+current.getId());
            strng.append("\n");
            strng.append("Origin: "+current.getStartLocat());
            strng.append("\n");
            strng.append("Destination: "+current.getDestination());
            strng.append("\n");
            strng.append("leaves at: "+current.getDepartTime());
            strng.append("\t");
            strng.append("on: "+current.getDepartDate());
            strng.append("\n");
            strng.append("Arrives at:"+current.getArriveTime());
            strng.append("\t");
            strng.append("on "+current.getArriveDate());
            strng.append("\n");
            strng.append("Fare: $"+current.getFare()+"pp");
            strng.append("\n");
            strng.append("No. seats: "+current.getNoSeats());
            strng.append("\n");
            strng.append("-----------------");
            strng.append("\n");

        }
        return strng.toString();
 
    }

    // finds a trip from the array of trips based on its id
    public Trip getTrip(int tripId){
        for (Trip trip : tripArray) {
            if (trip.getId() == tripId) {
                return trip;
            }
        }
        System.out.println("Trip not found");
        return null;
    }


}
