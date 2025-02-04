
// sets payment details and validates payment 
public class Payment
{
    
    // fields for payment data 
    private String cardType; 
    private String cardNo; 
    private String date; 
   // private int amount;
    private Address paymentAddress;
    private String bankName; 
    private boolean isValid; // for validating the payments . is set to true initially and set to false if any values arent valid
    
    // Constructor for Payment class
    public Payment(String cardNo, String cardType,String date,String bankName,String street,String city ,String country,String zip)
    {
       paymentAddress = new Address(street, city , country ,zip);// creates payment address
       isValid = true; 
    }
    
    // method checks if the payement info is valid 
    // returns a boolean value true if card is validated and false if it isnt 
    // is the same as isValid() 
    public boolean validatePayment(String cardNo,String cardType, String date){
        // check if card no has correct amount of numbers 
        if(cardNo.length() != 16){
            System.out.println("Card number invalid");
            isValid = false; 
        }
        else{
        System.out.println("Card number valid");
        }
        
        // checks if card type is valid
        if(cardType.equals("Visa") || cardType.equals("Mastercard")){
            
            System.out.println("Card type valid");
        }
        else{
            System.out.println("Card type invalid");
            isValid = false; 
        }
        
        return isValid; 
    }

    
   
}
