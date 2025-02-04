public class Shark extends Fish{

    private boolean canBite;
    private String name;

    public Shark(String name){
        super();// invoking parent constructor

        //setting fields
        this.name = name;
        isDangerous= true;
        canBite= true;
        colour = "grey";
    }

// have to do tostring and equals methods
    @Override
    public String toString(){
        String strng ="";
        strng+="Shark;";
        strng+= "name: ";
        strng+= name;
        strng+="; ";
        strng+= "colour: ";
        strng+= colour;
        strng+="; ";
        strng+= "can swim ";
        strng+= canSwim;
        strng+="; ";
        strng+= "has gills: ";
        strng+= hasGills;
        strng+="; ";
        strng+= "has fins: ";
        strng+= hasFins;    
        strng+="isDangerous: ";
        strng+= isDangerous;
        strng+="; ";
        strng+="canBite: "+canBite;
        strng+="; ";
        strng+="\n";

        return strng;
    }

    // Shark fields are name, colour , has fins, can swim , has gills , is dangerous and can bite
    @Override
    public boolean equals(Object obj){
        if(obj==null)
        {
            return false;
        }
        if (obj instanceof Shark){
            Shark sharkA = (Shark)obj;
            // checking all shark fields
            if(this.name.equals(sharkA.name)&& this.colour.equals(sharkA.colour)&& this.canSwim==sharkA.canSwim &&this.canBite == sharkA.canBite && this.hasFins==sharkA.hasFins && this.hasGills==sharkA.hasGills && this.isDangerous==sharkA.isDangerous){
                return true;
            }
        }
        return false;
    }

}
