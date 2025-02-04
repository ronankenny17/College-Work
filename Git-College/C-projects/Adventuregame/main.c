#include <stdio.h>
#include <string.h>
# include <stdbool.h>
#include <ctype.h>

typedef struct {
    char description[100];
    int n, s, e, w, in, out;
    int take,drop,examine, inventory;
} location;
typedef struct {
    char name[100];
    int location;
    char description[100];
}item;


int handleItem(int userLocation,char itemRequest[20]);
void dropItem(int userLocation, char* itemRequest);
int identifyItem(char* itemRequest);

item items[40];
item inventory[3];
location locations[40];
int numLocations = 0;
int numItems = 0;
char locationsFile[] = "C:\\Users\\ronan\\Downloads\\adventure_locations.txt";
char itemsFile[]="C:\\Users\\ronan\\Documents\\school\\CProgramming\\itemlocations.txt";

char commands[][20]={"error","n","s","e","w","in","out","look","help","take","drop","examine","inventory","quit","end"};
char itemslist[][10]={"usb-drive","ice-cream"};
FILE* openFileForReading(char* filename) {
    FILE* file_ptr = fopen(filename, "r");
    if (file_ptr == NULL)
        printf("Could not open %s\n", filename);
    return file_ptr;
}

bool readLocations() {
    FILE* file_ptr = openFileForReading(locationsFile);
    if (file_ptr == NULL)
        return false;

    numLocations = 0;
    int readHeaderLines = 0;
    char line[200];
    while (fgets(line, 99, file_ptr) != NULL) {
        if (readHeaderLines<2)
            readHeaderLines++;
        else {
            numLocations++;
            location l;
            int locNum;
            sscanf(line, "%d\t%d\t%d\t%d\t%d\t%d\t%d\t%[^\t]\n", &locNum, &l.n, &l.s, &l.e, &l.w, &l.in, &l.out, l.description);
            locations[numLocations] = l;
        }
    }
    fclose(file_ptr);
    return true;
}


int identifyCommand(char* txt){
    for (int i=0; i<(int)15; i++) {
        if (strcmp(txt,commands[i])==0)
            return i;
    }
    return 0;
}

// function for identifying the items
// works the same as identify command
int identifyItem(char* itemRequest)
{
    for(int i =0;i<numItems;i++)
    {
        if(strcmp(itemRequest,itemslist[i])==0)
        {
            return i+1;
        }
    }
    return 0;
}


// had a lot of issues scanning in data fom second text file
// mainly that would scan everything in twice
// so that there wil be 2 ice creams and 2 usb-drives stored in the item structure

bool readitems() {
    FILE* fptr2 = fopen("C:\\Users\\ronan\\Documents\\school\\CProgramming\\itemlocations.txt", "r");
    if (fptr2 == NULL){
        printf("Could not open %s\n", itemsFile);
        return false;
    }
    numItems = 0;
    int HeaderLines = 0;
    char line1[200];
   fgets(line1,99,fptr2);
    while(fgets(line1,99,fptr2) !=NULL)
    {
        if (HeaderLines < 1){
            HeaderLines++;
        }
        else{
            numItems++;
            item k;
            sscanf(line1, "%s\t%d\t%[^\t]\n",k.name,&k.location,k.description);
            items[numItems] = k;// the 1st location is 1 (not 0) so we can use 0 to mean 'nothing' in adventure_locations.txt
        }
    }
    fclose(fptr2);
    return true;
}

int main() {

    char play[] = "          ";// variable to store the users input
    int previousLocation=1;// variable to store the past iterations location
    int temp= 0;// variable to help assign the next destination after the user moves
    char itemRequest[20];// the item the user the wants to interact with
    int itemPresent = 0;

    // file check
    if (readLocations()) {
        printf("Successfully read %d locations from file\n", numLocations);
    }
    // reading in items
    if(readitems())
    {
        printf("Successfully read %d items from file\n",numItems);
    }
    // the game
    puts("Welcome to the galway Text-Adventure\n");
    puts("if unsure enter HELP for the list of commands!\n");

    while(strcmp(play,"quit"))
    {
        printf("You are %s\n", locations[previousLocation].description);

        // loop to check if there are items present
        for(int k=1;k<numItems+1; k++)
        {
            if(items[k].location == previousLocation)
            {
                itemPresent = k;
            }
        }

        if(itemPresent>>0){
            for(int e =1;e<itemPresent;e++) {
                printf("Item available here is %s\n",items[itemPresent].name);
                itemPresent = 0;
            }
            }
        else
        {
            printf("there are no items available here\n");
        }
        // play is the variable for the users command
        printf("Enter Command=>");
        scanf_s("%s", play);

        // converts user inputs to lowercase
        for (int i = 0; i < strlen(play); i++)
        {
          play[i]=  tolower(play[i]);
        }
        int commandNumber= identifyCommand(play);

        //all cases follow the same format
        // 1.they get the location of where the user will move which is stored in temp
        // 2. they check if it is possible to move the chosen direction
        // 3.if it is possible the variable storing the past location is set the value of the id of the destination

        switch(commandNumber){
            case 0:
            printf("Error!\n");
            break;
        case 1:
            temp = locations[previousLocation].n;// temporarily storing the destination of where the user will end up
                if(locations[previousLocation].n  ==0 )
                {
                    // this checks if it's possible to move the chosen direction
                    printf("cannot go north\n");
                }
                else {
                    previousLocation = temp;// assigning the destination id to the variable that stores the previous location of the user
                }
                break;
        case 2:
                temp = locations[previousLocation].s;
                if(locations[previousLocation].s  ==0 )
                {
                    printf("cannot go south\n");
                }
                else {
                    previousLocation = temp;
                }
                break;
        case 3:
                temp = locations[previousLocation].e;
                if(locations[previousLocation].e  ==0 )
                {
                    printf("cannot go east\n");
                }
                else {
                    previousLocation = temp;
                }
                break;
            case 4:
                temp = locations[previousLocation].w;// temporarily storing the destination of where the user will end up
                if(locations[previousLocation].w  ==0 )
                {
                    printf("cannot go west\n");
                }
                else {
                    previousLocation = temp;
                }
                break;
            case 5:
                temp = locations[previousLocation].in;// temporarily storing the destination id of where the user will end up
                if(locations[previousLocation].in  ==0 )
                {
                    printf("cannot go inside here\n");
                }
                else {
                    previousLocation = temp;
                }
                break;
            case 6:
                temp = locations[previousLocation].out;
                if(locations[previousLocation].out  ==0 )
                {
                    printf("cannot go outside here\n");
                }
                else {
                    previousLocation= temp;
                }
                break;
            case 7:
                //look
                // is blank as at the start of every loop it says the location and its description
                break;
            case 8:
                //help
                printf("Here is a list of the Commands!\nN\nS\nE\nW\nIN\nOUT\n");
                break;
            case 9 :
                //take
                printf("what item do you want to take?");
                scanf_s("%s",itemRequest);
                // converting command to lowercase
                for (int i = 0; i < strlen(itemRequest); i++)
                {
                    itemRequest[i]=  tolower(itemRequest[i]);
                }
                // calls function to add item to inventory
                handleItem(previousLocation,itemRequest);
                strcpy(itemRequest,"          ");//clears item request to prevent it interfering with future inputs
                break;
            case 10:
                //drop
                printf("what item do you want to drop?");
                scanf_s("%s",itemRequest);
                for (int i = 0; i < strlen(itemRequest); i++)
                {
                    itemRequest[i]=  tolower(itemRequest[i]);
                }
                dropItem(previousLocation,itemRequest);
                strcpy(itemRequest,"          ");
                break;
            case 11:
                // examine
                printf("What item would you like ot examine?");
                scanf_s("%s",itemRequest);
                int itemNumber = identifyItem(itemRequest) *2;
                if(items[itemNumber].location==0)
                printf("%s\n",items[itemNumber].description);
                else
                    printf("item not in inventory!\n");
                break;
            case 12:
                // inventory
                printf("Inventory is currently:\n");
                for(int i =0 ; i<numItems+1; i++) {
                    printf("-%s\n", inventory[i].name);
                }
                previousLocation= previousLocation;
                break;

        }
    }
}
// function to remove item from inventory
void dropItem(int userLocation, char* itemRequest) {
    printf("Dropping item\n");

   int itemNumber = identifyItem(itemRequest) * 2;// have to account for somehow scanning it in twice;will either be 2 or 4
        // is only true if items location is 0 ie is in the user inventory
        if (items[itemNumber].location == 0)
        {
            items[itemNumber].location = userLocation;// the items location is updated to be where the user currently is
            items[itemNumber-1].location = userLocation;// the items scan in twice so
            strcpy(inventory[itemNumber].name,"     ");
            strcpy(inventory[itemNumber-1].name,"     ");
            strcpy(inventory[itemNumber].description , "                        ");
            strcpy(inventory[itemNumber-1].description , "                        ");// clearing out inventory after dropping items
        }
        else
        {
            printf("item not in inventory!\n");
        }

}

int handleItem(int userLocation,char itemRequest[20])
{
    int itemNumber = identifyItem(itemRequest)*2;
    printf("Adding item to inventory\n");
        // is only true if the item the user typed is in the same location as the user
        if (userLocation == items[itemNumber].location) {

            items[itemNumber].location= 0; // 0 means the item is in the users inventory
            items[itemNumber-1].location= 0;
            inventory[itemNumber]= items[itemNumber];
            inventory[itemNumber-1]= items[itemNumber-1];
        }
        else
        {
            printf("error");
        }

    return 0 ;
}
