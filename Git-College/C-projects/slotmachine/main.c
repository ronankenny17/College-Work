#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

// slot machine
// will need function to return random number
// will; need to manage balances + - increasing based on different win outcomes ect
// is it possible to make certain numbers have higher outcomes?

float randomnumbergenerator(float balance);
void main()
{   //variables
    srand(time(NULL));
    float balance;
    char choice[9] = "yes";
    float winnings;

    puts("Welcome to the Slot Machine Game!\n it costs 10-euro per spin!");
    puts("please enter your account balance:");
    scanf_s("%f",&balance);
    printf("your balance is %f\n",balance);

    while(balance > 9)
    {
    puts("would you like to play?\n");
    scanf_s("%s",choice,9);
    while (strcmp(choice, "yes") == 0)
        {
       winnings = randomnumbergenerator(1);
        balance = balance - 10;
        balance = balance + winnings;
        printf("your new balance is %f\n", balance);
            if(balance <10){
                break;
            }
        puts("would you like to play again?");
        scanf_s("%s", choice, 9);
        }
    }
    puts("your too broke - GAME OVER!");
}

float randomnumbergenerator(float balance)
{
    int random[3];
    int similarity;
    int what = 0;// number of wins
    int winners[3];
    int multiplier;
    int winnings = 0;

        // random number generator
        for (int i = 0; i < 3; i++) {
            random[i] = rand()%5;
        }
        //printing numbers
        for (int a = 0; a < 3; a++) {
            printf("%d\t", random[a]);
        }
        puts("\n------------------------");

        if (random[0] == random[1] && random[1] == random[2])
        {
            similarity = 3;// to trigger winning loop
            puts("you won!");
            for(int h =0; h <3; h++)
            {
               winners[h] = random[h];
            }
        }
        if (random[0] == random[1] && random[1] != random[2]) {
            puts("you were close!");
        }
        if (random[0] == random[2] && random[1] != random[2]) {
            puts("you were close!");
        }
        if (random[0] != random[1] && random[1] == random[2]) {
            puts("you were close");
        }
        if (random[0] != random[1] && random[1] != random[2] && random[2] != random[0]) {
            puts("hard luck! none of your numbers matched");
        }

if(similarity == 3 )
{

    puts("your winning numbers were:\n");
   // for(int g =0; g<what ; g++)

        for(int f = 0 ; f<3 ; f ++)
        {
            printf("%d\t",winners[f]);
        }
        puts("\n");

    multiplier = winners[1];
    winnings = multiplier * 10;
    printf(" your winnings are 10 x %d = %d\n", multiplier , winnings);
    //balance = balance + winnings;

}
    // 3 all equal , 2 2 equal , 1 all diff
    return winnings;
}