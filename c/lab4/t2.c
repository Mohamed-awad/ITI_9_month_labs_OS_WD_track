#include<stdio.h>
#include<string.h>
int main()
{
	char fname[15];
	char lname[15];
	char full_name[40];
	printf("enter first name\n");
	scanf("%s", fname);
	printf("enter last name\n");
	scanf("%s", lname);
	strcpy(full_name, fname);
	strcat(full_name, " ");
	strcat(full_name, lname);
	printf("your full name is %s\n", full_name);
	
	return 0;
}
