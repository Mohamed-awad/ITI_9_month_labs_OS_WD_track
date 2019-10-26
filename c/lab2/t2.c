#include<stdio.h>
int main() 
{
	int i, x, sum = 0;
	do {
		printf("enter the number\n");
		scanf("%d", &x);
		sum += x;
	}while(sum < 100);
	printf("sum is %d\n", sum);
	
	return 0 ;
}
