
public class Bird extends Animal
{
    //instance variables (fields)
    boolean hasFeathers;
    boolean hasWings;
    boolean flies;
    boolean sings;

    /**
     * Constructor for objects of class Bird
     */
    public Bird()
    {
        super(); //calls the constructor of its superclass  - Animal
        colour = "black"; //overrides the value of colour inherited from Animal
        hasFeathers = true; //all the subclasses of Bird inherit this property and value
        hasWings = true; //all the subclasses of Bird inherit this property and value
        flies = true; //all the subclasses of Bird inherit this property and value
    }

    /**
     * move method overrides the move method
     * inherited from superclass Animal
     */
    @Override // good programming practice to use @Override to denote overridden methods
    public void move(int distance){

        if(flies) {
            System.out.printf("I fly %d metres \n", distance);
        }
        else {
            // if flies == false the bird doesn't fly
            System.out.println("I am a bird but cannot fly!");
        }
    }

    /**
     * sing method that all birds have
     */
    public void sing(){
        if(sings) {
            System.out.println("tra la la");
        }else{
            System.out.println("I cannot sing!");
        }
    }

    /**
     * 'getter' method for the hasWings field
     */
    public boolean hasWings(){
        return hasWings;
    }

    /**
     * 'getter' method for the hasFeathers field
     */
    public boolean hasFeathers(){
        return hasFeathers;
    }
}

