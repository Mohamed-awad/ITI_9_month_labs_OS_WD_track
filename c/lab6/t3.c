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
	struct emp* ptr_emp = &emp1;
	printf("enter your id\n");
	scanf("%d", &(ptr_emp->id));
	printf("enter your name\n");
	scanf("%s", (ptr_emp->name));
	printf("enter your salary\n");
	scanf("%f", &(ptr_emp->salary));

	// print data
	printf("_______________________________________\n");
	printf("your information is:- \n");
	printf("your id is %d\n", ptr_emp->id);
	printf("your name is %s\n", ptr_emp->name);
	printf("your salary is %f\n", ptr_emp->salary);
	return 0;
}
