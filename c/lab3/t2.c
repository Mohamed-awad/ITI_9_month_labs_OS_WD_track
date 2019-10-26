#include<stdio.h>
int power(int x, int y)
{
	int i, p = x;
	for(i = 1 ; i < y ; i++)
	{
		p *= x;
	}
	return p;
}
int main() 
{
	int x, y;
	printf("enter your number\n");
	scanf("%d", &x);
	printf("enter power\n");
	scanf("%d", &y);
	printf("%d power %d is %d\n", x, y, power(x, y));
	
	return 0 ;
}
