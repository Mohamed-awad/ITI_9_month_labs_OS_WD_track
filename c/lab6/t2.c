#include<stdio.h>

int main()
{
	int arr[5], i=0;
	for(i = 0; i < 5; i++)
	{
		printf("enter value of number %d:  ", i+1);
		scanf("%d", arr+i);
	}
	printf("__________________________________________\n\n");
	for(i = 0; i < 5; i++)
		printf("number %d is:  %d\n", i+1, *(arr+i));
	return 0;
}
