import javax.print.attribute.HashPrintServiceAttributeSet;

/**
 *
 * contains all the info of a booking
 * vendor , passengers, the cost and what trip they want to book
 *
 */
public class Booking
{


    private String vendor; // the bus company
    private int noPassengers;// how many seats they want to buy
    private Trip newTrip;// will store the trip info
    private int totalCost;// is calculated -> fare * number of passengers


// constructor
    public Booking(Trip trip,int noPassengers)
    {
        // initializing local fields
        this.newTrip = trip;
        this.noPassengers = noPassengers;
        totalCost = setTotalCost();// method calculated the total cost associated with the booking
    }


    public int setTotalCost(){
        int price = getTrip().getFare();
        return price * noPassengers;
    }

    public int getTotalCost(){
        return totalCost;
    }


    // setter and getter methods as part of encapsulation
    public Trip getTrip(){
        return newTrip;
    }
    public void setTrip(Trip trip){
        newTrip = trip;
    }
    public void setArriveTime(String arriveTime){
        newTrip.setArriveTime(arriveTime);
    }
    public String getArriveTime(){
        return newTrip.getArriveTime();
    }
    public void setDepartTime(String departTime){
        newTrip.setDepartTime(departTime);
    }
    public String getDepartTime(){
        return newTrip.getDepartTime();
    }
    public int getNoPassengers(){
        return noPassengers;
    }
    public void setNoPassengers(int noPassengers){
        this.noPassengers = noPassengers;
    }

    public int getSeats(){
        return newTrip.getNoSeats();
    }
    public void setSeats(int seats){
        newTrip.setNoSeats(seats);
    }

    public String getVendor(){
        return vendor;
    }

    public void setVendor(String vendor){
        this.vendor = vendor;
    }
    public String getStartLocation(){
        return getTrip().getStartLocat();
    }
    public void setStartLocation(String startLocat){
        this.newTrip.setStartLocat(startLocat);
    }
    public void setEndLocation(String endLocat){
        this.newTrip.setDestination(endLocat);
    }
    public String getEndLocation(){
        return getTrip().getDestination();
    }
    public int getTripID(){
        return getTrip().getId();
    }
    public void setTripID(int tripID){
        getTrip().setId(tripID);
    }
    public void setFare(int fare){
        this.newTrip.setFare(fare);
    }
    public int getFare(){
        return newTrip.getFare();
    }


    
}
