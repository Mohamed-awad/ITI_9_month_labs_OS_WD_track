#include<stdio.h>
int main() {
	int num1;
	printf("enter your number\n");
	scanf("%d", &num1);
	printf("result char\n");
	printf("\n%c\n", num1);	
	printf("result octal\n");
	printf("\n%o\n", num1);	
	printf("result hex\n");
	printf("\n%x\n", num1);
	return 0;
}
