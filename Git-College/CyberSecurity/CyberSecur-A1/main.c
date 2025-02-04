#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// 23404724
// Ronan Kenny
// first name in ascii -> 01110010 01101111 01101110 01100001 01101110 00001010
// last name in ascii -> 01101011 01100101 01101110 01101110 01111001 00001010 00001010
void hide(const char *inpFile, const char *outFile, const char *binString);
void retrieve(const char *inpFile);

int main(int argc, char *argv[]) {
    char *arg1, *arg2, *arg3, *arg4;
    // a or e wby.txt output.txt encoded message
    int err = 0;

    if (argc > 2) { // Check for minimum number of arguments
        arg1 = argv[1];
        arg2 = argv[2];

        if (strcmp(arg2, "") == 0) {
            err = 1;
        }
        else if (strcmp(arg1, "A") == 0 && argc > 4) {
            // Add bitstring to text
            arg3 = argv[3];
            arg4 = argv[4];
            if (strcmp(arg3, "") == 0 || strcmp(arg4, "") == 0) {
                err = 1;
            }

            else {
                if (strlen(arg4) % 2 == 1) {
                   strcat(arg4, "0");
                }
                // Hide bitstring
                hide(arg2, arg3, arg4);
            }
        }
        else if (strcmp(arg1, "E") == 0){
            // Extract bitstring from text
            retrieve(arg2);
        }
        else {
            err = 1;
        }
    }
    else {
        err = 1;
    }

    if (err) {
        printf("\nUse: Stegano1P2 <A:E><Input File><OutputFile><Bitstring>\n");
        printf("Example: Stegano1P2 A inp.txt out.txt 0010101\n");
        printf("Example: Stegano1P2 E inp.txt\n");
    }

    return 0;
}


void hide(const char *inpFile, const char *outFile, const char *binString) {
    FILE *reader, *writer;
    int index = 0;
    int len;
    char line[1024]; // Buffer for reading lines

    reader = fopen(inpFile, "r");
    if (!reader) {
        perror("Error opening input file");
        return;
    }
    writer = fopen(outFile, "w");
    if (!writer) {
        perror("Error opening output file");
        fclose(reader);
        return;
    }
        printf("Binstring was: %s\n", binString);
    while (fgets(line, sizeof(line), reader)) {
        // Your code starts here.

        len = strlen(line);
        // to get rid of \n at the end of each line , adds terminator
                if(len !=0 && line[len-1]=='\n')
                {
                    line[len-1]= '\0';
                }

                // adds two bits at the end of each line
                /*----key for encoding -------------
                 *  for 00 -> adds one space
                 *  for 01 -> adds two spaces
                 *  for 10 -> adds three spaces
                 *  for 11 -> adds fours spaces
                 *
                 */

        // for 0 0
        if(binString[index]== '0'&& binString[index+1]=='0')
        {
            strcat(line," ");// if there is 0 0 then adds one space
            strcat(line,"\n");
            index += 2;// then moves forward through two bits in the bitstring
        }
        // for 0 1
        if(binString[index]== '0'&& binString[index+1]=='1')
        {
            strcat(line,"  ");// if there is 0 1 then adds two spaces
            strcat(line,"\n");
            index += 2;// then moves forward through two bits in the bitstring
        }
        // for 1 0
        if(binString[index]== '1'&& binString[index+1]=='0')
        {
            strcat(line,"   ");// if there is 1 0 then adds three spaces
            strcat(line,"\n");
            index += 2;// then moves forward through two bits in the bitstring
        }
        // for 1 1
        if(binString[index]== '1'&& binString[index+1]=='1')
        {
            strcat(line,"    ");// if there is 1 1 then adds four spaces
            strcat(line,"\n");
            index += 2;// then moves forward through two bits in the bitstring
        }


                fputs(line, writer);
            if(index== strlen(binString) )
            {
                fclose(reader);
                fclose(writer);
                break;
            }
        }
        // end of my code

    fclose(reader);
    fclose(writer);

    printf("BitString %s written into file %s and stored in file %s.\n", binString, inpFile, outFile);
}

void retrieve(const char *inpFile) {
    printf("retrieve start\n");
    FILE *reader;
    char line[1024]; // Buffer for reading lines
    char out[1024] = ""; // Output string for the recovered bitstring
    int spaces = 0;// counts number of spaces after end of line



    reader = fopen(inpFile, "r");
    if (!reader) {
        perror("Error opening input file");
        return;
    }

    printf("Starting\n");
    while(fgets(line, sizeof(line), reader)) {
        int len = strlen(line);

        // to check if spaces were added correctly
       // printf("end of string was :%c|%c|%c|%c|\n", line[len - 4], line[len - 3], line[len - 2], line[len-1]);
        // Your code starts here.

        //if statements to count the number of spaces after the end of the line
        if (line[len - 1] == ' ') {
            spaces++;
        }
        if (line[len - 2] == ' ') {
            spaces++;
        }
        if (line[len - 3] == ' ') {
            spaces++;
        }
        if (line[len - 4] == ' ') {
            spaces++;
        }
        if (line[len - 5] == ' ') {
            spaces++;
        }
        // based on the number of spaces it will decide what the encoded bits are
        if (spaces == 1) {
            strcat(out, "00");
        }
        if (spaces == 2) {
            strcat(out, "01");
        }
        if (spaces == 3) {
            strcat(out, "10");
        }
        if (spaces == 4) {
            strcat(out, "11");
        }
        // resetting value of spaces
        spaces = 0;
    }
    fclose(reader);
    printf("Recovered messages from file %s: %s\n", inpFile, out);
}

