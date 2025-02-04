
/*  CT255 Assignment 3
 *  This class provides functionality to build rainbow tables (with a different reduction function per round) for 8 character long strings, which
    consist of the symbols "a .. z", "A .. Z", "0 .. 9", "!" and "#" (64 symbols in total).
    Properly used, it creates the following value pairs (start value - end value) after 10,000 iterations of hashFunction() and reductionFunction():
          start value  -  end value
          Kermit12        lsXcRAuN
          Modulus!        L2rEsY8h
          Pigtail1        R0NoLf0w
          GalwayNo        9PZjwF5c
          Trumpets        !oeHRZpK
          HelloPat        dkMPG7!U
          pinky##!        eDx58HRq
          01!19!56        vJ90ePjV
          aaaaaaaa        rLtVvpQS
          036abgH#        klQ6IeQJ


 *
 * @author Michael Schukat
 * @version 1.0
 */
public class RainbowTable
{
    /**
     * Constructor, not needed for this assignment
     */

    public RainbowTable() {

    }

    public static void main(String[] args) {
        long res = 0;
        int i;
        String start;// will be start of chain

        if (args != null && args.length > 0) { // Check for <input> value
            start = args[0];

            if (start.length() != 8) {
                System.out.println("Input " + start + " must be 8 characters long - Exit");
            }
            else {
                // Your code for problem 1 starts here
                //
                // Ronan Kenny 23404724
                // problem 1

                int noEntries= 10; // number of entries to the rainbow table
                System.out.println("Starting code");

                String[][] rainbowTable = new String[noEntries][2];// creating an array to be where we would store the passwords and final values
                rainbowTable[0][0] = start;
                String end = ""; // will be end of chain;
                end = generateHashChain(start);// method generated a hash chain of length 10000 and returns the final value
                rainbowTable[0][1] = end;
                System.out.println("Rainbow Table start:"+rainbowTable[0][0]+" end: "+rainbowTable[0][1]);


                // problem 2

                System.out.println("Problem 2 \n");
                //array for the given start passwords
                String[] stringArray = new String[10];
                stringArray[0] = "Kermit12";
                stringArray[1] = "Modulus!";
                stringArray[2] = "Pigtail1";
                stringArray[3] = "GalwayNo";
                stringArray[4] = "Trumpets";
                stringArray[5] = "HelloPat";
                stringArray[6] = "pinky##!";
                stringArray[7] = "01!19!56";
                stringArray[8] = "aaaaaaaa";
                stringArray[9] = "036abgH#";


                // for loop to cycle through the different passwords
                for(int k = 0; k < 10; k++) {
                   // System.out.println("Checking "+stringArray[k]); for fyi
                    findPasswordMatches(stringArray[k]);
                }

            }
        }
        else { // No <input>
            System.out.println("Use: RainbowTable <Input>");
        }
    }

    private static long hashFunction(String s){
        long ret = 0;
        int i;
        long[] hashA = new long[]{1, 1, 1, 1};

        String filler, sIn;

        int DIV = 65536;

        filler = new String("ABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGH");

        sIn = s + filler; // Add characters, now have "<input>HABCDEF..."
        sIn = sIn.substring(0, 64); // // Limit string to first 64 characters

        for (i = 0; i < sIn.length(); i++) {
            char byPos = sIn.charAt(i); // get i'th character
            hashA[0] += (byPos * 17111); // Note: A += B means A = A + B
            hashA[1] += (hashA[0] + byPos * 31349);
            hashA[2] += (hashA[1] - byPos * 101302);
            hashA[3] += (byPos * 79001);
        }

        ret = (hashA[0] + hashA[2]) + (hashA[1] * hashA[3]);
        if (ret < 0) ret *= -1;
        return ret;
    }

    private static String reductionFunction(long val, int round) {  // Note that for the first function call "round" has to be 0,
        String car, out;                                            // and has to be incremented by one with every subsequent call.
        int i;                                                      // I.e. "round" created variations of the reduction function.
        char dat;

        car = new String("0123456789ABCDEFGHIJKLMNOPQRSTUNVXYZabcdefghijklmnopqrstuvwxyz!#");
        out = new String("");

        for (i = 0; i < 8; i++) {
            val -= round;
            dat = (char) (val % 63);
            val = val / 83;
            out = out + car.charAt(dat);
        }

        return out;
    }

    // problem 1
    private static String generateHashChain(String start){
        // initial password is passed as an argument -> start


        long hash;// for storing the hash values between iterations
        String current = start; // for storing the reduced passwords between iterations, is initially set to the starting password

        // loop iterates 10000 times for a chain length of 10000
        for(int j=0; j<10000; j++)
        {
            hash = hashFunction(current);// a hash value is generated for the current password
            current = reductionFunction(hash,j);// this hash value is then reduced
        }
        // after 10000 iterations the final value in the chain is returned
        return current;

    }

    // problem 2
    private static void findPasswordMatches(String start){
        // start is the inital password passed an argument

        // are the four given hash values
        long[] hashArray = new long[4];
        long hash1 = 895210601874431214L;
        long hash2 = 750105908431234638L;
        long hash3 = 111111111115664932L;
        long hash4 = 977984261343652499L;
        // I added them to an array
        hashArray[0] = hash1;
        hashArray[1] = hash2;
        hashArray[2] = hash3;
        hashArray[3] = hash4;
        String current = start;// is the start password passed as an argument
        long hash;



            // outer loop is same as previous part but has added if statement to check if hash value matches
            // the outer loop iterates 10,000 times checks between start and final value in rainbow table
            for (int j = 0; j < 10000; j++) {

                hash = hashFunction(current);
                // loop cycles through the four given hash values
                for(int i = 0 ; i<4 ; i++) {
                    // if statements checks if the hash value generated equals the one we are searching for
                    if (hash == hashArray[i]) {
                        System.out.println("Password Match found!\n");
                        System.out.println("Original password was : " + start + " and hash value: " + hashArray[i]);
                        System.out.println("Current string was: " + current);
                        System.out.println("Current hash was: " + hash);
                    }

                }
                // reduces the hash value to a new password
                current = reductionFunction(hash,j);


            }

    }
}
