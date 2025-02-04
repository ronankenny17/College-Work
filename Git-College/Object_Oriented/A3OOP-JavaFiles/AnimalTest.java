public class AnimalTest {
    // 23404724 
    // Ronan Kenny 
    // assignment 3 

    
    public static void main(String[] args) {
        // creating instance of  animalTest object
        AnimalTest test = new AnimalTest();

        // creating animal array
        Animal[] animalArray = new Animal[4];
        Animal[] animalArray2 = new Animal[6];
        Ostrich moveTest = new Ostrich("Ollie");

        // add animals to the array
        animalArray[0]= new Ostrich("johnny");
        animalArray[1]= new Canary("james");
        animalArray[2]= new Trout("joe");
        animalArray[3]= new Shark("jack");

        // will test the equals method
        
        // two ostriches but still shoudl return false 
        animalArray2[0]= new Ostrich("johnny");
        animalArray2[1]= new Ostrich("Ella");
        
        // should then return true for these two canaries
        animalArray2[2]= new Canary("james");
        animalArray2[3]= new Canary("james");
        
        // will compare objects of a different class
        animalArray2[4]= new Trout("joe");
        animalArray2[5]= new Shark("Emma");

        // pass animal arrays as arguments to the methods
        test.test1(animalArray);
        test.test2(animalArray2);
        
        // testing ostrich move -> fly method
        System.out.println("\n-----------------------------");
        System.out.println("Ostrich Test");
        moveTest.move(4);
        
    }

    public void test1(Animal[] animalArray){

        System.out.println("Test 1 : toString method");
        // for loop to use the toString() method
        for(int i=0 ; i< animalArray.length ; i++){
            System.out.println(animalArray[i]);
        }
    }

    public void test2(Animal[] animalArray){
        System.out.println("------------------------------------------------------");
        System.out.println("Test 2: Equals methods");

        for(int i =0 ; i<4 ; i+=2){
            if(animalArray[i].equals(animalArray[i+1])){
                // i has to be incremented by two as there is pairs of animals
                System.out.println(animalArray[i]+"\n and \n "+ animalArray[i+1]+"\n are equal:)");
            }
            else{
                System.out.println(animalArray[i]+ "\n and \n"+ animalArray[i+1]+"\n are not equal:(");
            }

            // ie animal array[0] and [1] are both ostriches and then [2] and [3] are canaries ect
        }
        // will compare last two objects which are a trout and a shark
        if(animalArray[4].equals(animalArray[5])){
            System.out.println(animalArray[4]+"\n and \n "+ animalArray[5]+"\n are equal!:)");
        }
        else{
            System.out.println(animalArray[4]+ "\n and \n"+ animalArray[5]+"\n are not equal :(");
        }

    }
}
