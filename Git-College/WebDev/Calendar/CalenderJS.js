var numdays;
var month = parseInt(document.getElementById("input1").value);

function is_leap(year) {
    var dayYesNo = 0 ;
    if( year % 4 === 0 )
    {
        dayYesNo = 1;
    }
    if(year % 100 ===0)
    {
        dayYesNo = 0;
    }
    if(year %400 === 0 )
    {
        dayYesNo = 1;
    }

    return dayYesNo;
}
function daysOfMonthchecker(month)
{
    var year = parseInt(document.getElementById("txtYear").value);
    var month = parseInt(document.getElementById("input1").value);
    var numOfDays = 31;
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
    if(month === 11)
    {
        numOfDays = 30;
    }
    if(month === 2)
    {

       numOfDays = 28 + (is_leap(year));
    }
    return numOfDays;
}

function checkYear() {
    var txt = document.getElementById("txtYear").value;
    var year = parseInt(txt);
    if (isNaN(year))
        alert(txt + " is not a number!");
    else if (is_leap(year)==1)
        alert(year + " is a leap year");
    else
        alert(year + " is not a leap year");
}
function makerows()
{
    numdays = daysOfMonthchecker(month);
        //parseInt(document.getElementById("input1").value);// variable for number of days in the month
    var dayOfWeek = startDayOfMonth();
        //parseInt(document.getElementById("input2").value);// variable for what day of the week the month starts on
    var counter1=0;// used to counter the number of days after monday the month started
    var weekCounter=0;//used for fixing issues with first week and which day to start on
    var loopLimit=7;// used to know how many blank spots on the calendar and how many with dates
    var rowCounter =5;// variable for how many rows in the calendar
    var daycounter = 1;// variable to print date on individual dates
    var table;// variable will store the string to make the table

    // this is the first line of the calendar which says the days of the week
    var cell = "<tr></tr><td class='words'>Monday</td><td class='words'>Tuesday</td><td class='words'>Wednesday</td><td class='words'>Thursday</td><td class='words'>Friday</td><td class='words'>Saturday</td><td class='words'>Sunday</td></tr><tr>";

    if(dayOfWeek > 6)
    {
        dayOfWeek = dayOfWeek % 7;
    }
    // this loop adds empty boxes for the days before the first day of the month
    for(var e=0 ; e< dayOfWeek;e++)
    {
        cell+="<td class='days'>  </td> "
        counter1++;
    }
    if(dayOfWeek>4){
        rowCounter=6;
    }
    // loops for creating table
    if(dayOfWeek == 5)
    {
        rowCounter -= 1;
    }
    for (var i = 0; i < rowCounter; i++)
    {
        if(weekCounter===0)
        {
        loopLimit -= counter1;

        }
        else
        {
            loopLimit=7;
        }
        for (var j = 0; j < loopLimit ; j++)// can edit this loop
        {
            // this is to leave days greater than the number of days in the month empty
            if (daycounter > numdays || daycounter>31)
            {
                cell += "<td class='days'>  </td>";
            }
            // this loop creates the cells in the table with the dates on it repeats seven times for each
            else {
                cell += "<td class='days'>" + (daycounter) + "</td>";
                daycounter++;
            }
        }
        weekCounter++;
        cell += "<tr>"// adds a new row after each week
    }
    table = cell;
    document.getElementById("table1").innerHTML = table;
}
function startDayOfMonth()
{// need to account for days of the months of same year but previous months
    var month = parseInt(document.getElementById("input1").value);
    var year = parseInt(document.getElementById("txtYear").value);
    var daySum = 0;
    var dayOfWeek;
    var k =0;
    // have to count days since Monday Jan 1rst 1900
    // every year there is 365
    for( var i = 1900 ; i < (year); i++)
    {
        daySum = daySum + 365 + is_leap(year);
    }
    dayOfWeek = daySum % 7;
    return dayOfWeek;
}