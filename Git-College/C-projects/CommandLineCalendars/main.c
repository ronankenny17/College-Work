#include <stdio.h>
#include <stdlib.h>

// 23404724
// RONAN KENNY
// 12/3/24

int is_leap(int year);
int new_years_day(int year);
int no_of_days(int year, int month);
int first_day(int year, int month);
void print_month(int firstday, int noofdays);
void printMonthName(int month);

int main(int argc, char *argv[]) {
// the command line arguements are passed in as an array of strings so had to convert them to ints
    int yearInput = atoi(argv[1]);
    int monthInput = atoi(argv[2]);
    int numDays = no_of_days(yearInput,monthInput);
    int firstDayOfMonth = first_day(yearInput,monthInput);

    printMonthName(monthInput);// I created a function to print the name of the month to display above the dates
    print_month(firstDayOfMonth,numDays);
    // this is to account for if the input more than one month
    if(argc>>2)
    {
        for(int k =3 ; k< (argc); k++ )
        {
            int month2Input = atoi(argv[k]);
            firstDayOfMonth = first_day(yearInput, month2Input);
            numDays = no_of_days(yearInput, month2Input);
            printMonthName(month2Input);
            print_month(firstDayOfMonth, numDays);
        }
    }
}
// function to add an extra day if there is a leap year
int is_leap(int year) {
    if (year % 400 == 0)
        return 1;
    if (year % 100 == 0)
        return 0;
    if (year % 4 == 0)
        return 1;
    return 0;
}
// function checks what day of the week the first day of the year is
int new_years_day(int year) {
    int daynumber = 1;
    for (int i=1900; i<year; i++)
        daynumber+=365+is_leap(i);
    return (daynumber % 7);
}
// function that returns the number of days in the month that is passed into it
int no_of_days(int year, int month)
{
    int numOfDays = 31;
    if(month == 9)
    {
        numOfDays = 30;
    }
    if(month == 4)
    {
        numOfDays = 30;
    }
    if(month == 6)
    {
        numOfDays = 30;
    }
    if(month == 11)
    {
        numOfDays = 30;
    }
    if(month == 2)
    {

        numOfDays = 28 + (is_leap(year));
    }
    return numOfDays;
}
// function to return the day of the week the first of the month passed in is
int first_day(int year, int month)
{
    int daynumber = new_years_day(year);
    for (int i=1; i<month; i++)
    {
        daynumber += no_of_days(year, i);
    }
    daynumber %= 7;
    return daynumber;
}

// function to print our calendar

void print_month(int firstday, int noofdays)
{
    // switched to tab spaces as the numbers and days were not lining up
    printf("\nSun\tMon\tTue\tWed\tThu\tFri\tSat\n");
    int weekcounter=0;// variable to move to next line when you have completed a full week
    int date = 1;// variable to print the date
    // loop for printing the empyt spaces before the first day of the month
    for(int i = 0 ; i< firstday;i++)
    {
        weekcounter++;
        printf("\t");
    }
    for(int j = 0; j < noofdays; j++)
    {
        printf("%d\t",date);
        weekcounter++;
        date++;
        if(weekcounter == 7) {
            printf("\n");
            weekcounter=0;
        }
    }
}

// fucntion that prints the name of the month number that's passed into it
void printMonthName(int month)
{
    puts("\n");
    if(month == 0)
    {
        printf("\t there is no 0th month!");
    }
    if(month == 1)
    {
        printf("\t January\n");
    }
    if(month == 2)
    {
        printf("\t February\n");
    }
    if(month == 3)
    {
        printf("\t March\n");
    }
    if(month == 4)
    {
        printf("\t April\n");
    }
    if(month == 5)
    {
        printf("\t May\n");
    }
    if(month == 6)
    {
        printf("\t June\n");
    }
    if(month == 7)
    {
        printf("\t July\n");
    }
    if(month == 8)
    {
        printf("\t August\n");
    }
    if(month == 9)
    {
        printf("\t September\n");
    }
    if(month == 10)
    {
        printf("\t October\n");
    }
    if(month == 11)
    {
        printf("\t November\n");
    }
    if(month == 12)
    {
        printf("\t December\n");
    }
    if(month>12)
    {
        printf("there are only 12 months!");
    }

}

