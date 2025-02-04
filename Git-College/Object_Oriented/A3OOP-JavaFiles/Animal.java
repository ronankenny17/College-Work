

    public abstract class Animal
    {
        boolean hasSkin;
        boolean breathes;
        String colour;

        /**
         * Constructor for objects of class Animal
         */
        public Animal()
        {
            breathes = true; //all the subclasses of Animal inherit this property and value
            hasSkin = true; // all the subclasses of Animal inherit this property and value
            colour = "grey"; //all the subclasses of Animal inherit this property and value
        }
        /**
         * move method
         * param int distance - the distance the Animal should move
         * All subclasses inherit this method
         */

        /**
         * abstract move method to be implemented  in bird and fish
         */

        public abstract void move(int distance);


        /**
         * getter method for colour field
         * All subclasses inherit this method
         */
        public String getColour(){
            return colour;
        }

        /**
         * 'getter' method for haSkin field
         * All subclasses inherit this method
         */

        public boolean hasSkin(){
            return hasSkin;
        }
    }


