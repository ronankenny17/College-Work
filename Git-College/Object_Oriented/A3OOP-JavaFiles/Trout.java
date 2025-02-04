public class Trout extends Fish {

    private boolean hasSpikes;
    private boolean isEdible;
    private boolean laysEggs;
    private boolean swims_Up_River;
    private String name;

    public Trout(String name) {
        super();// invoking parent constructor

        // setting fields
        this.name = name;
        isDangerous = false;
        colour = "brown";
        hasSpikes = true;
        isEdible = true;
        laysEggs = true;
        swims_Up_River = true;

    }

    // have to do to string and equals methods for all leaf classes
    @Override
    public String toString() {
        String strng ="";
        strng+="Trout;";
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
        strng+= "laysEggs: ";
        strng+= laysEggs;
        strng+="; ";
        strng+= "swims_Up_River: ";
        strng+= swims_Up_River;
        strng+="; ";
        strng+= "has spikes: ";
        strng+= hasSpikes;
        strng+="; ";
        strng+= "is edible:";
        strng+= isEdible;
        strng+="\n";

        return strng;
    }


    // trout fields are name, colour, has fins , can swim , is dangerous , has gills , has spikes, is edible , lays eggs, swims up river
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Trout) {
            Trout troutA = (Trout) obj;
            // checking all trout fields
            if (this.name.equals(troutA.name) && this.colour.equals(troutA.colour) && this.hasFins == troutA.hasFins && this.canSwim == troutA.canSwim && this.hasGills == troutA.hasGills && this.isDangerous == troutA.isDangerous && this.hasSpikes == troutA.hasSpikes && this.isEdible == troutA.isEdible && this.laysEggs == troutA.laysEggs && this.swims_Up_River == troutA.swims_Up_River) {
                return true;
            }
        }
        return false;
    }
}

