

public class Customer
{
    
     
    private String firstName;
    private String lastName; 
    private String email;
    private final Long customerId; 
    
   

   // Constructor for Customer Class
    public Customer(String firstName, String lastName,String email){
        this.firstName = firstName; 
        this.lastName = lastName;
        this.email= email; 
        customerId  = makeCustomerId();
        
    }
    public void printInfo(){
        System.out.println(firstName+ " " +lastName+ " " +email+ " " +customerId);

    }
    
    public String getFirstName(){
    return firstName; 
    }
    
     public String getLastName(){
    return lastName; 
    }
    
    public String getEmail(){
        return email; 
    }
    
    public long makeCustomerId(){
        long Id =1;        
        return Id; 
    }
  
   
}
