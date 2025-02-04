
class TestTrafficLight{
    public static void main(String[] args) {
    
        System.out.println("------ Start -----");
    TrafficLights tl = new TrafficLights();
        for(int i =1; i<=5 ; i++){
    
        System.out.println("------ iteration "+i+"-------");
        System.out.println("----Go----");
        tl.go();
        tl.printState();
        System.out.println("-----------");

        System.out.println("----Prepare to Stop----");
        tl.prepareToStop();
        tl.printState();
        System.out.println("-----------");

        System.out.println("---Stop---");
        tl.Stop();
        tl.printState();
        System.out.println("-----------");
        System.out.println("------ End -----");
    }
    }


}
