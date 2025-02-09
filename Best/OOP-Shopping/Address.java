

public class Address
{
    // Address fields 
    private String street; 
    private String city ; 
    private String county; 
    private String zip; 
    
    // constructor for Address class
    public Address(String street,String city ,String county,String zip){
        this.street = street; 
        this.city = city;
        this.county = county; 
        this.zip = zip; 
    }
    
    // address setter method 
    public void setAddress(String street, String city , String county, String zip){
        this.street = street; 
        this.city = city;
        this.county = county; 
        this.zip = zip; 
        
        
    }
    
    // getter methods for address fields
    public String getStreet(){
        return street; 
    }
        public String getCity(){
        return city; 
    }
        public String getCounty(){
        return county; 
    }
        public String getZIP(){
        return zip; 
    }
}
