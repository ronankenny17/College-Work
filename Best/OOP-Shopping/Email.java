
// email class in charge of storing information for, and printing the confirmation email
public class Email
{    
    // email fields 
    
    private String email ; 
    private Order orderLocal; // local order object used for storing and printing the order data using the email object 
    
    // constructor for Email class
    public Email(String email, Order orderArg){
        this.email = email; 
        orderLocal = orderArg; 
    }
    
    // method for printing confirmation email if payment was valid 
    public void sendSuccessEmail(){
         System.out.println("To:@"+email);
        System.out.println("Hi "+orderLocal.getName()+ " your order has successfully been placed!");// gets the first name from the order
         System.out.println("Here's a summary of what you ordered:");
          orderLocal.printOrder(); 
        
    }
    
    //method for printing email if payment was invalid 
    public void sendInValidEmail(){
         System.out.println("To:@"+email);
         System.out.println("Hi "+orderLocal.getName()+" your card payment was invalid and your ordered was not confirmed");

    }

    
}
