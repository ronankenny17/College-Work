

public class Item
{
    // fields for string item data 
    private String itemName; 
    private int price; 
    private long itemId;
        
    public Item (String itemName,long itemID,int itemPrice){
      this.itemName = itemName;
      this.itemId = itemId; 
      this.price = itemPrice; 
}
    
    // getter / setter methods for fields 
    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price; 
    }
    
    public String getName(){
        return itemName; 
    }
    
    public long getId(){
        
        return itemId;
    }
   
}
