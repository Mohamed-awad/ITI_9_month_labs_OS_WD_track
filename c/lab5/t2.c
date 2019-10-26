#include<stdio.h>
#include<string.h>
struct emp {
	int id;
	char name[20];
	float salary;
};
int main()
{
	struct emp emp1;
	printf("enter your id\n");
	scanf("%d", &emp1.id);
	printf("enter your name\n");
	scanf("%s", emp1.name);
	printf("enter your salary\n");
	scanf("%f", &emp1.salary);

	// print data
	printf("_______________________________________\n");
	printf("your information is:- \n");
	printf("your id is %d\n", emp1.id);
	printf("your name is %s\n", emp1.name);
	printf("your salary is %f\n", emp1.salary);
	return 0;
}
