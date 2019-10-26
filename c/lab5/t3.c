#include<stdio.h>
#include<string.h>
struct emp {
	int id;
	char name[20];
	float salary;
};
int main()
{
	struct emp arr[5];
	printf("enter information for 3 employees\n");
	for(int i = 0 ; i < 3 ; i++)
	{
		printf("enter information for employee number %d\n", i+1);
		printf("enter your id\n");
		scanf("%d", &arr[i].id);
		printf("enter your name\n");
		scanf("%s", arr[i].name);
		printf("enter your salary\n");
		scanf("%f", &arr[i].salary);
	}
	// print data
	printf("_______________________________________\n\n");
	for(int i = 0 ; i < 3 ; i++)
	{
		printf("information for %d employee is\n", i+1);
		printf("your information is:- \n");
		printf("your id is %d\n", arr[i].id);
		printf("your name is %s\n", arr[i].name);
		printf("your salary is %f\n", arr[i].salary);
		printf("-----------------------------------------------\n");
	}
	return 0;
}
