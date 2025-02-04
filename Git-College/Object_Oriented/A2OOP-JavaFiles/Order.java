import java.util.ArrayList;

/*
 * order takes the finalized items from the cart and creates the order 
 * it has data about the customer , the items , its status and its id
 * has methods to add this data to the order(setter) and getter methods
 * it has a method to print the order once it has been fully created
 */
public class Order
{
   
    private ArrayList<Item> itemArray = new ArrayList<>();// an arraylist to store the items in the order
    // data for the customer 
    private String fName; 
    private String lName; 
    private String email; 
    private Address customerAddress; //instance of the address object for the delivery address
    // fields for the order data 
    private long orderNo ; 
    private String orderStatus;
    // local instance of Item object used to add items to array list 
    private Item newItem;
    
    
    
    // constructor for Order class
    public Order(long id){
        orderNo = id;
        orderStatus = "Order Placed";// Status initially set as-> Placed 
    }
    
    
    // method to create the customer for the order 
    public void setCustomer(String firstName, String lastName,String email){
        fName = firstName; 
        lName = lastName; 
        this.email = email; 
    }
    
    // method for setting the address
    public void setAddress(String street, String city , String country, String zip){
        customerAddress= new Address(street, city , country, zip); 
    }
    
    
    
    // method to add an item to the order 
    public void addItem(String itemName, int price , long itemId){
        // method to add items to the array list of the items 
        newItem = new Item(itemName, itemId, price); 
        itemArray.add(newItem); 
    }
    
    // getter method to return the total price. is used when printing order
    public int getTotalCost(){
        int sum=0; 
        for(int i =0 ; i<itemArray.size() ; i++)
        {   
            Item current = itemArray.get(i);
            sum += current.getPrice();
        }
        return sum; 
    }
    
    
    // getter method for items 
    public Item getItems(int i){
        return itemArray.get(i);
    }
    
    // print order method used for email 
    // prints the customers name , email ,the items they ordered and the price in total 
    public void printOrder(){
        
        System.out.println("Name:"+fName +"  "+ lName);
        System.out.println("Email:"+email);
        System.out.println("-----------Items-----------");
        
        for(int i=0; i<itemArray.size(); i++){
            Item current = itemArray.get(i);
            String currentName = current.getName();
            System.out.println(currentName);
            
        }
        System.out.println("Total was: $"+getTotalCost());
        
    }
    

    // for setting the status of the order 
    // when the order is finalized / confirmed
    public void setStatus(String newStatus){
        orderStatus = newStatus; 
    }
    
    // getter method for first name field . used when printing the email 
    public String getName(){
        return fName; 
    }
    
    // returns the orderStatus of the order
    public String getStatus(){
        return orderStatus; 
    }

   
    
}
