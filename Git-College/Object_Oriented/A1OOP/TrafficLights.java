
// Ronan Kenny 23404724
// main TraffficLights class
class TrafficLights {


    // constructors for three light objects passing the three colors as args
    Light light1 = new Light("green");
    Light light2 = new Light("amber");
    Light light3 = new Light("red");

    // sets green light to lit the rest stay off
    public void go(){
        light1.changeState(true);
        light2.changeState(false);
        light3.changeState(false);

    }
    // sets amber light to lit and turns the rest off
    public void prepareToStop(){
        light1.changeState(false);
        light2.changeState(true);
        light3.changeState(false);
    }
    // sets red light to lit and turns the rest off
    public void Stop(){
        light1.changeState(false);
        light2.changeState(false);
        light3.changeState(true);
    }
    // prints the current state
    public void printState(){
        light1.printState();
        light2.printState();
        light3.printState();
    }

}
