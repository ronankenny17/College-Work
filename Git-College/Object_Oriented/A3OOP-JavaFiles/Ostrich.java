public class Ostrich extends Bird {

    private String name;
    private boolean isTall;
    private boolean has_Thin_legs;
    private boolean has_Long_legs;

    public Ostrich(String name) {
        super();// invoke parent class

        // setting fields
        this.name = name;
        colour= "grey";
        flies = false; // ostriches do not fly
        sings = false;
        isTall = true;
        has_Thin_legs = true;
        has_Long_legs = true;

    }

    public void sing(){
        System.out.println("What noise do ostriches make?");
    }
    @Override
    public String toString(){
        String strng ="";
        strng+= "Ostrich ; ";
        strng+= "name: ";
        strng+= name;
        strng+= "; ";
        strng+= "colour: ";
        strng+= colour;
        strng+= "; ";
        strng+= "does it breathe: ";
        strng+= breathes;
        strng+= "; ";
        strng+= "does it have skin: ";
        strng+= hasSkin;
        strng+= "; ";
        strng+= "does it have feathers: ";
        strng+= hasFeathers;
        strng+= "; ";
        strng+= "does it have wings: ";
        strng+= hasWings;
        strng+= "; ";
        strng+= "does it fly: ";
        strng+= flies;
        strng+= "; ";
        strng+= "does it have long legs: ";
        strng+= has_Long_legs;
        strng+= "; ";
        strng+= "is it tall: ";
        strng+= isTall;
        strng+= "; ";
        strng+= "does it have thin legs: ";
        strng+= has_Thin_legs;
        strng+= "; ";
        strng+= "\n";
        return strng;
    }

    // ostrich fields are name, colour , has wings, flies, has long legs, and is tall,
    @Override
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(obj instanceof Ostrich) {
            Ostrich ostrich2 = (Ostrich) obj;

            if(this.name.equals(ostrich2.name) &&this.colour.equals(ostrich2.colour) && this.isTall == ostrich2.isTall && this.flies == ostrich2.flies && this.has_Long_legs == ostrich2.has_Long_legs) {
                return true;
            }
        }
        return false;
    }
    


}
