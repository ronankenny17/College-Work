import java.util.ArrayList;
/*
 * shopping cart class handles adding and removing items to the cart 
 * it handles finalizing the cart and creating an order 
 * the instance of the order object is within the shopping cart object and is then returned to the transaction test
 */



public class ShoppingCart
{
    private long cartId ;// id of the cart 
    private ArrayList<Item> itemArray = new ArrayList<>();// item array list to store the items 
    private Order order1;// local instance of the order . once it is created it is returned to the transaction test 
    private Item newItem; // is used to add items to the items arraylist 
    public boolean closed; // boolean variable to lock the cart 
    private long idNOs = 0; // is used for creating id numbers . will simply be incremented every time a new id is needed and that new number will be the new id
    
    // constructor for ShoppingCart class
    public ShoppingCart(){
    
        // instantiating private intance variables  
        cartId = makeId(); 
        closed= false; 
        order1 = new Order(cartId);// orderID will be same as cart id
        
        
    }
    
    
    // mutator method to add items to the cart 
    public void addItem(String itemName, int price , long itemId){
        // method to add items to the array list of the items 

        //if closed = true then the cart is closed and cant add more items
        if(closed==true){
            System.out.println("Cannot add to cart, cart is closed");
        }
        else{
        System.out.println("Adding to cart");
        newItem = new Item(itemName,itemId,price); 
        //newItem.setPrice(price);
        itemArray.add(newItem); 
        }
    }
    
    // mutator method to remove items .is is position in item array of item ie if i 1 then it removes the first item ect; 
    public void removeItem(int i){
        
        System.out.println("Removing item...");
        Item local = itemArray.get(i-1);
        itemArray.remove(local);  
    }
    
    // accessor method to get the total price
    public int getTotalCost(){
        int sum=0; 
        for(int i =0 ; i<itemArray.size() ; i++)
        {   
            Item current = itemArray.get(i);
            sum += current.getPrice();
        }
        return sum; 
    }
    
    public void printTotal(){
        
        System.out.println("Total:"+getTotalCost());
        
    }
    
    
    // accessor method that returns an item based on the position in the array 
    public Item getItems(int i){
        // i being the number / position of the item in the array 
        // ie if i was 1 then itd be the 2nd item in the array 
        return itemArray.get(i);
    }
    
    // mutator method that clears the cart 
    public void clearCart(){
        itemArray.clear(); 
    }
    
    // method to finalize the cart and create the order
    // returns an object of class Order
    public Order createOrder(String fName, String lName, String email){
        Item current; 
        String itemName; 
        int price; 
        long id; 
        
        System.out.println("Confirming Order...");
        order1.setCustomer(fName, lName, email);
        
    // adding items to order 
        for(int i = 0; i<itemArray.size() ; i++){
            current = itemArray.get(i);
            itemName = current.getName();
            price = current.getPrice(); 
            id = current.getId();
            order1.addItem(itemName, price, id);
        }
        return order1; 
    }
    
   // method for printing the cart
    public void printCart(){
        Item current2; 
        String currentName; 
        System.out.println("Cart is :");
         for(int i=0; i<itemArray.size(); i++){
            current2 = itemArray.get(i);
            currentName = current2.getName();
            System.out.println(currentName);
            
        }
    }
    
    //mutator method to lock / close the cart 
    public void closeCart(){
        closed = true; 
        System.out.println("Closing cart");
    }
    
    // method for making the id of the cart
    public long makeId(){
        idNOs++; 
        
        return idNOs;
    }
}
