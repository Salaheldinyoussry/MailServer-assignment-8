#include <stdio.h>
int main(){

    int x, y, z;
    printf("Enter x:\n");
    scanf("%d", &x);
    printf("Enter y:\n");
    scanf("%d", &y);
    printf("Enter z:\n");
    scanf("%d", &z);
    y+=x;
    x+=z;
    z+=y;
    z-=x;
       y-=z;
       x-=y;
        printf("x = %d\ny = %d\nz = %d\n", x, y, z);
         return 0;
          }
