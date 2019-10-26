#include<stdio.h>

void swap(int* a, int* b)
{
	int temp = *a;
	*a = *b;
	*b = temp;
}
int main()
{
	int a, b;
	printf("enter first value\n");
	scanf("%d", &a);
	printf("enter second value\n");
	scanf("%d", &b);
	swap(&a, &b);
	printf("first value is %d\n", a);
	printf("second value is %d\n", b);
	return 0;
}
