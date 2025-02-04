#include <stdio.h>
#include <stdlib.h>

void main ()
{
    float  prA ,prB,  prC,  prD,  prE;
    float prevA, prevB, prevC, prevD, prevE;
    //prA = prB =prC = prD = prE = 1.0/5.0;
    prA= 0.2 ;//(1.0/5.0);
    prB = 0.2 ;//(1.0/5.0);
    prC = 0.2 ;//(1.0/5.0);
    prD = 0.2 ; // (1.0/5.0);
    prE = 0.2 ;//  (1.0/5.0);
/*
    prevA = 0.2;
    prevB = 0.2 ;
    prevC = 0.2 ;
    prevD = 0.2 ;
    prevE = 0.2 ;
*/
   double cA = 1.0;
   double cB = 2.0;
   double cC = 2.0;
   double cD = 3.0;
   double cE = 2.0;

    for(int i=0; i < 13; i++)
    {

        prevA = prA;
        prevB = prB;
        prevC = prC;
        prevD = prD;
        prevE = prE;

        prA = 0.03 + (0.85*(prevE/cE));
        prB = 0.03 + (0.85*(prevA/cA + prevD/cD));
        prC = 0.03 + (0.85*(prevA/cA + prevD/cD));
        prD = 0.03 + (0.85*((prevC/cC) + (prevB/cB) + prevE/cE));
        prE = 0.03 + (0.85*(prevB/cB +prevA/cA));
    }

    printf("page rank A was %0.3f\n",prA);
    printf("page rank B was %0.3f\n",prB);
    printf("page rank C was %0.3f\n",prC);
    printf("page rank D was %0.3f\n",prD);
    printf("page rank E was %0.3f\n",prE);
}