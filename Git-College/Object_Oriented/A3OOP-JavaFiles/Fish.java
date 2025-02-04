public class Fish extends Animal{
    boolean hasFins;
    boolean canSwim;
    boolean hasGills;
    boolean isDangerous;

    public Fish(){
        super();
        hasFins= true;
        canSwim = true;
        hasGills = true;
    }
    @Override
    public void move(int distance){
            System.out.printf("I swim %d metres \n", distance);
        }

        // getter methods for fish fields
        public boolean hasFins(){
        return hasFins;
        }

        public boolean hasGills(){
        return hasGills;
        }

}



