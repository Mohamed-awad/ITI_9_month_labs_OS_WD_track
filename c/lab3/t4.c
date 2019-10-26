#include<stdio.h>
int sum_arr(int arr[])
{
	int i, sum=0;
	for(i = 0 ; i < 5 ; i++)
		sum += arr[i];
	return sum;
}
int max_arr(int arr[])
{
	int i, mx=arr[0];
	for(i = 1 ; i < 5 ; i++)
	{
		if(mx < arr[i])
			mx = arr[i];
	}
	return mx;
}
int main() 
{
	int arr[5], i;
	for(i = 0 ; i < 5; i++)
	{
		printf("enter the %d number in array \n", i+1);
		scanf("%d", &arr[i]);
	}
	printf("\n");
	for(i = 0 ; i < 5; i++)
	{
		printf("%d, ", arr[i]);
	}
	printf("\n");
	printf("sum of array is %d\n", sum_arr(arr));
	printf("max num in array is %d\n", max_arr(arr));
	return 0 ;
}
