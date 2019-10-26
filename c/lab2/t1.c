#include<stdio.h>
int main() 
{
	int i, x, sum = 0;
	for(i = 0 ; i < 5; i++)
	{
		printf("enter %d number\n", i+1);
		scanf("%d", &x);
		sum += x;
	}
	printf("sum is %d\n", sum);
	
	return 0 ;
}
