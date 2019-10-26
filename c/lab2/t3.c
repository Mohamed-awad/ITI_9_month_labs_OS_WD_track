#include<stdio.h>
int main() 
{
	int degree;
	printf("enter your degree\n");
	scanf("%d", &degree);
	if(degree >= 85)
		printf("your degree is A+\n");
	else if (degree >= 75)
		printf("your degree is B\n");
	else if (degree >= 65)
		printf("your degree is C\n");
	else if(degree >= 50)
		printf("your degree is D\n");
	else
		printf("your fail\n");
	
	return 0 ;
}
