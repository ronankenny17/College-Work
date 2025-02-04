

public class TransactionTest
{
    // fields for the two scenarios
        String fName;
        String lName;
        String emailAddress;
        String street; 
        String city;
        String country; 
        String zip;
        
        // card details 
        String cardNo;
        String cardType;//-> will be invalid 
        String bankName;
        String date;
        long id; 
       
   
    public static void main(String[] args)
    {
      TransactionTest test= new TransactionTest();
      System.out.println("-----------------Scenario 1 ----------------");
      test.transaction1();
      System.out.println("-----------------Scenario 2 ----------------");
      test.transaction2();
    }
    
    public void transaction1(){
        // customer details 
        fName = "Ethan";
        lName = "McAndrew";
        emailAddress = "emcandrew@gmail.com";
        street= "Bothar an Stiofan"; 
        city = "Galway";
        country = "Ireland"; 
        zip = "H92HD7I";
        
        // card details 
        cardNo = "0123456789101213";// 16 numbers long
        cardType = "Visa";
        bankName = "BOI";
        date = "15/10/24";
        id = 1000; 
        Order orderTest1 = new Order(id); 
        Payment payment1;
        Email email1;
    
    
        
        
        
        
        // creating an instance of a customer object 
        Customer customerTest1 = new Customer(fName, lName,emailAddress); 
         
        System.out.println("Starting order");
        // creating a shopping cart for customer
        ShoppingCart customerCart1 = new ShoppingCart();
        
        // add three items 
        customerCart1.addItem("Milk",2,0001);
        customerCart1.addItem("Cheese",4,0002);
        customerCart1.addItem("Butter",2,0003);
        
        // close the cart
        customerCart1.closeCart(); 
        
        // testing if item will be added if the cart is closed 
        // if closed then it will display "cannot print item cart is closed"
        customerCart1.addItem("testItem",3,0004);
        
        // finalizing cart and creating order 
        orderTest1 = customerCart1.createOrder(fName,lName,emailAddress);
        // clears cart after finalizing order
        customerCart1.clearCart();
        
        
        // setting the address for the order 
        orderTest1.setAddress(street, city, country , zip); 
        orderTest1.setStatus("Confirmed");
        email1 = new Email(emailAddress, orderTest1); 
        // payment 
        payment1 = new Payment(cardNo,cardType,date,bankName,street, city , country , zip); 
        
        // validatePayment() method is boolean and will be true if the card payment is valid
        if(payment1.validatePayment(cardNo,cardType,date) && orderTest1.getStatus().equals("Confirmed")){
            System.out.println("Card payment Validated");
            System.out.println("Order Confirmed");
            email1.sendSuccessEmail(); 
            
        }
        else{
            System.out.println("CardPayment not validated");
            email1.sendInValidEmail();
        }
        
        
    
        
        
        
        

        
        
        
        
        
    }
    
    public void transaction2(){
          // customer details 
        fName = "Sarah";
        lName = "Cox";
        emailAddress = "sarahc@gmail.com";
        street= "Bothar an tra"; 
        city = "Galway";
        country = "Ireland"; 
        zip = "H93PH9A";
        
        // card details 
        cardNo = "012345678910121";// 15 numbers long -> will be invalid
        cardType = "Wisa";//-> will be invalid 
        bankName = "AIB";
        date = "15/10/27";
        id = 2000; 
        Order orderTest2 = new Order(id); 
        Payment payment2;
        Email email2;
        
        // creating local customer 
        Customer customerTest2 = new Customer(fName, lName,emailAddress);
        
        System.out.println("Starting order");
        // creating a shopping cart for customer
        ShoppingCart customerCart2 = new ShoppingCart();
        
        // add three items 
        customerCart2.addItem("T-Shirt",12,0001);
        customerCart2.addItem("Jeans",25,0002);
        customerCart2.addItem("Shorts",7,0003);
        
        // print cart then total price 
        customerCart2.printCart(); 
        customerCart2.printTotal(); 
        
        // removes the second item from the array 
        customerCart2.removeItem(2);
        
        // reprinting cart and total after removing item 
        customerCart2.printCart(); 
        customerCart2.printTotal(); 
        customerCart2.closeCart(); 
        
        // create the order
         orderTest2 = customerCart2.createOrder(fName,lName,emailAddress);
        // clears cart after finalizing order
        customerCart2.clearCart();
        
        
        // setting the address for the order 
        orderTest2.setAddress(street, city, country , zip); 
        orderTest2.setStatus("Confirmed");
        email2 = new Email(emailAddress, orderTest2); 
        
        payment2 = new Payment(cardNo,cardType,date,bankName,street, city , country , zip); 
        
        // validatePayment() method is boolean and will be true if the card payment is valid
        if(payment2.validatePayment(cardNo,cardType,date) && orderTest2.getStatus().equals("Confirmed")){
            System.out.println("Card payment Validated");
            System.out.println("Order Confirmed");
            orderTest2.setStatus("Confirmed");
            email2.sendSuccessEmail(); 
            
        }
        else{
            System.out.println("CardPayment not validated");
            orderTest2.setStatus("Not confirmed");
            email2.sendInValidEmail();
        }
    }
    

}
