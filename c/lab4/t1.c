#include<stdio.h>

int main()
{
	int arr[10][10] = {{0}}, size, sum=0, i, j;
	int av[10] = {};
	printf("enter size of arr\n");
	scanf("%d", &size);
	printf("enter array values\n");	
	for(i = 0 ; i < size; i++)
	{
		for(j = 0 ; j < size; j++)
		{
			scanf("%d", &arr[i][j]);
			sum += arr[i][j];
		}
		arr[i][size] = sum;
		sum = 0;
	}
	for(i = 0 ; i < size; i++)
	{
		for(j = 0 ; j < size; j++)
		{
			av[i] += arr[j][i];
		}
	}
	printf("_________________________________________________\n");
	for(i = 0 ; i < size; i++)
	{
		for(j = 0 ; j <= size; j++)
			printf("%d ", arr[i][j]);
		printf("\n");
	}
	for(i = 0 ; i < size; i++)
		printf("%d ", av[i]/size);
	printf("\n");
	return 0;
}
