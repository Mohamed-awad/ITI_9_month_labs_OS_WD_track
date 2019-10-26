#include<stdio.h>
int fact(int x)
{
	int i, f = 1;
	for(i = x ; i>1; i--)
	{
		f *= i;
	}
	return f;
}
int main() 
{
	int x;
	printf("enter num\n");
	scanf("%d", &x);
	printf("facturial of %d is %d \n", x, fact(x));
	
	return 0 ;
}
