
#include <stdio.h>
#include <stdlib.h>
#include <time.h>



void countSortRadix(int[], int, int);
void radixSort(int[], int);
int findMax(int array[],int size);

void bubbleSort(int bubblearray[], int);

void quickSort(int[], int, int);
int partition(int[], int, int);
int partition2(int[], int, int);
void swap(int*, int*);
int findMin(int array[], int size);

void merge(int[], int, int, int);
void mergeSort(int[], int, int);
int numSwaps=0;
int comparisons =0;
int functionCalls=0;

void insertionSort(int[], int);
void selectionSort(int[], int);


void main()
{
    //23404724
    // Ronan Kenny
    clock_t time= clock();
    double timeTaken;
    int size = 10000;
    int bigArray[size];// array to store numbers from file
    FILE * fptr;
    fptr = fopen( "C:\\Users\\ronan\\Downloads\\file1 (1).txt","r");
    if(fptr == NULL)
    {
        puts("file didnt open");
    }
    for(int k = 0; k < size; k++)
    {
        fscanf_s(fptr,"%d",&bigArray[k]);
    }
    // some algorithms need a max and a min value
  int maxValue =  findMax(bigArray,size);
  int minValue =   findMin(bigArray,size);
   quickSort(bigArray,0,size-1);
   // mergeSort(bigArray,0, size-1);
    fclose(fptr);
    timeTaken = clock() - time;
    printf("Size was %d\n",size);
    printf("Algorithm used was quickSort()\n");
    printf("Time taken was %lf seconds\n",(timeTaken/CLOCKS_PER_SEC));
    printf("%d swaps\n",numSwaps);
    printf("%d comparisons\n",comparisons);
    printf("There was %d function calls",functionCalls);

    // loop to print out sorted numbers to see if they were sorted
    for(int k = 0; k < size; k++)
    {
       // fscanf_s(fptr,"%d",&bigArray[k]);
    // printf(" bigArray[%d] was %d\n",k,bigArray[k]);
    }
}
// ------------------------------------------------
//radix sort
// sort an array of positive integers of size
void radixSort(int arrA[], int size) {

    int exp, i;

    //find maxVal to get number of digits

    int maxVal = findMax(arrA, size);
    printf(" maxVal was %d \n",maxVal);

    // call countSortRadix for each digit: exp = 1 for 1's, exp = 10 for 10's, etc
    for (exp = 1; maxVal / exp > 0; exp *= 10) {
        countSortRadix(arrA, size, exp);
    }

    //print out (or add code to write to file)
    for (i = 0; i < size; i++) {
        printf("\n arrA[%d] is %d", i, arrA[i]);
    }
}

// sort an array of positive integers for radix Sort using countSort
// range of values is 0 - 9
void countSortRadix(int arrA[], int size, int exp) {

    int i, value, count;
    int freqSize = 10;
    int freq[10];

    int* arrB = (int*)calloc(size, sizeof(int));       //create arrB[] same size as arrA[]

    for (i = 0; i < freqSize; i++) {
        freq[i] = 0;
    }

    //count using exp - 1's, 10's, 100's depending on exp
    for (i = 0; i < size; i++) {
        ++freq[(arrA[i] / exp) % 10];
    }
    //get <= in freq[]
    for (i = 1; i < freqSize; i++) {
        freq[i] = freq[i] + freq[i - 1];
    }

    // place values from arrA into arrB; update freq[] - go in opposite order  - start at size-1
    for (i = size - 1; i >= 0; i--) {
        arrB[freq[(arrA[i] / exp) % 10] - 1] = arrA[i];
        --freq[(arrA[i] / exp) % 10];
    } //next value in arrA


    //write back sorted values to arrA[] now that sorting of this digit is finished
    for (i = 0; i < size; i++) {
        arrA[i] = arrB[i];
    }
    free(arrB);
}
int findMax(int array[],int size)
{
    int maxValue = 0;
    for(int j =0; j < size-1 ; j++)
    {
        if(array[j] > maxValue)
        {
            maxValue = array[j];
        }
    }
    return maxValue;
}
int findMin(int array[], int size)
{
    int minValue = 0;
    for(int j =0; j < size-1 ; j++)
    {
        if(array[j] > minValue)
        {
            minValue = array[j];
        }
    }
    return minValue;
}


 // end of radix sort

//----------------------------------------------------
// Bubble sort

void bubbleSort(int arrA[], int size)
{
    int swaps = 0;
    int comps =0;
    int i, k, temp;

    for (k = 0; k < size; k++) {
        for (i = 0; i < size - 1 - k; i++) {
            comps++;
            if (arrA[i] > arrA[i+1]) {
                //out of order so swap
                temp = arrA[i];
                arrA[i] = arrA[i + 1];
                arrA[i + 1] = temp;
                swaps++;
            }
        } //end inner i for
    }
    /*
    for(int j =0; j<size-1; j++)
    {
        printf("arrA[%d] was %d\n",j,arrA[j]);
    }
    */
    printf("%d swaps\n",swaps);
    printf("%d comparisons\n",comps);
}

// end of bubble sort
//------------------------------------------------
// start of quick sort
void quickSort(int arrA[], int startval, int endval) {
    functionCalls++;
    if ((endval - startval) >= 1)
    {

        int k = partition2(arrA, startval, endval);
        //now sort the two sub-arrays
        quickSort(arrA, startval, k - 1);  //left partition
        quickSort(arrA, k + 1, endval);   //right partition
        comparisons++;
    }
}

// pivot at startval as before
int partition2(int arrA[], int startval, int endval)
{   functionCalls++;
    int j;
    int pivot = arrA[startval];
    int k = startval;

    for (j = startval + 1; j <= endval; j++) { // j keeps incrementing to the end
        if (arrA[j] <= pivot) {
            k++;   // k only increments when there is a new value to add to the <= portion
            comparisons++;
            if (k != j) {
                swap(&arrA[k], &arrA[j]);
                comparisons++;
            }
        }
    }
    swap(&arrA[k], &arrA[startval]);  // put pivot in correct location i
    return(k);
}

// call with  ... swap(&arrA[i], &arrA[j]) to swap the values at positions i and j
void swap(int* a, int* b)
{
    functionCalls++;
    ++numSwaps;
    int temp = *a;
    *a = *b;
    *b = temp;
}
// Selection Sort: integer array arrA [] of size
void selectionSort(int arrA[], int size) {

    int i, j, min, temp;

    for (i = 0; i < size - 1; i++) {
        min = i;
        //find next smallest
        for (j = min + 1; j < size; j++) {
            if (arrA[min] > arrA[j]) {
                min = j;
                comparisons++;
            }
        } // end j for loop

        //swap values at locations i and min, if i != min
        if (i != min) {
            temp = arrA[i];
            arrA[i] = arrA[min];
            arrA[min] = temp;
            numSwaps++;
        }
    } //end outer i for loop
}


// Insertion Sort: integer array arrA [] of size
void insertionSort(int arrA[], int size)
{
    int i, j, curr;

    for(i = 1; i < size; i++)
    {
        curr  = arrA[i];

        for(j = i - 1; j >= 0 && curr < arrA[j]; j--) {   //compare
            //make room ...
            arrA[j + 1] = arrA[j];
            comparisons++;

        }

        if (i != j + 1) // if not at the correct position already
            arrA[j + 1] = curr;
                numSwaps++;
    } // end outer i for

} //return

// mergeSort to sort values in an integer array arrA[]
// lb = 0 and ub = size - 1 for the first call
void mergeSort(int arrA[], int lb, int ub) {

    int mid;
    //printf("\n _mergeSort()_ call with lb = %d and ub = %d", lb, ub);
    comparisons++;
    if (lb < ub) {
        mid = (int)((lb + ub) / 2);
        mergeSort(arrA, lb, mid);
        mergeSort(arrA, mid + 1, ub);
        merge(arrA, lb, mid, ub);
        functionCalls +=3;
    }
}


// merge two sorted portions of an integer array arrA[]:
// portions are lb to mid and mid+1 to ub
void merge(int arrA[], int lb, int mid, int ub) {

    int i, j, k;
    int size = ub - lb + 1;
    int* arrC = (int*) calloc(size, sizeof(int)); //create arrC[] to be of size needed for current merge

    i = lb;
    j = mid + 1;
    k = 0;

    while (i <= mid && j <= ub) {
        if (arrA[i] <= arrA[j]) {
            arrC[k] = arrA[i];
            i++;
            comparisons++;
            numSwaps++;
        }
        else {
            arrC[k] = arrA[j];
            j++;
            numSwaps++;
            comparisons++;
        }
        k++;
    } //end while

    // write out anything left in i part
    while (i <= mid) {
        arrC[k] = arrA[i];
        i++;
        k++;
    }
    // write out anything left in j part
    while (j <= ub) {
        arrC[k] = arrA[j];
        j++;
        k++;
    }

    //write back from arrC to arrA so correct values are in place for next merge
    i = lb;
    k = 0;
    while (i <= ub) {
        arrA[i] = arrC[k];
        i++;
        k++;
    }
    free(arrC);
}
