
/**
 * will contain all the info about a trip 
 *
 * 
 */
public class Trip
{
    
    private int tripId;
    private String startLocat;
    private String destination;
    private String departDate; 
    private String departTime;
    private String arriveTime; 
    private String arriveDate;
    private int fare; 
    private String vendor; 
    private int noSeats = 60; // arbitrary chosen is the total number of seats on the bus when it is empty

    /**
     * Constructor for objects of class Trip
     */
    public Trip(String startLocat ,String destination, String departDate, String departTime, String arriveTime,String arriveDate, int fare, int tripId)
    {
        // initialize local fields
        this.startLocat = startLocat;
        this.destination = destination;
        this.departDate = departDate;
        this.departTime = departTime;
        this.arriveTime = arriveTime;
        this.arriveDate = arriveDate;
        this.fare = fare;
        this.tripId = tripId;
        
    }

    // getter and setter methods as part of encapsulation
    public void setId(int Id){
        this.tripId= Id;
    }
    public int getId(){
        return tripId;
    }
    public int getNoSeats(){
        return noSeats;
    }
    // update the number of free seats after they are taken up by customers
    public void setNoSeats(int noSeats){
        this.noSeats = noSeats;
    }

    public void setFare(int fare){
        this.fare = fare;
    }
    public int getFare(){
        return fare;
    }
    public void setVendor(String vendor){
        this.vendor = vendor;
    }
    public String getVendor(){
        return vendor;
    }
    public void setDepartDate(String departDate){
        this.departDate = departDate;
    }
    public String getDepartDate() {
        return departDate;
    }
    public void setDepartTime(String departTime){
        this.departTime = departTime;
    }
    public String getDepartTime() {
        return departTime;
    }
    public void setArriveDate(String arriveDate){
        this.arriveDate = arriveDate;
    }
    public String getArriveDate() {
        return arriveDate;
    }
    public void setArriveTime(String arriveTime){
        this.arriveTime = arriveTime;
    }
    public String getArriveTime() {
        return arriveTime;
    }
    public String getStartLocat() {
        return startLocat;
    }
    public void setStartLocat(String startLocat) {
        this.startLocat = startLocat;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }


}
