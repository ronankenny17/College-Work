
// light class
class Light {

    // field to for the color passed as an arg
    private String color;
    // feild for if the light is lit same as in TrafficLights class tue = lit false = off
    private boolean lit = false;

    // light method that assigns the color in the argument to the field and sets the lit variable to true
    public  Light(String lightColor) {
       color = lightColor;
    }
    
    // mutator set method that changes the boolean value of the field lit ie turning the light on or off 
    public void changeState(boolean newState){
        lit = newState;
    }
    
    // is an accessor method that returns the boolean value of wether or not the light is on or off (true or false)
    public boolean returnOnOff(){
        return lit;
    }
    
    // method to print the current state of the light ie if its on or off
    public void printState() {
        if (!lit) {
            System.out.println("    =OFF=");
        }
        if (lit) {
            System.out.println("    "+color);
        }
    }

}