#include<stdio.h>
#include<string.h>
int main()
{
	char st[50], st1[] = " ACM ECPC";
	int i = 0 , j=0;
	printf("enter string\n");
	scanf("%s", st);
	printf("I will concat \'ACM ECPC\' to your sting\n");
	while(st[i] != '\0')
		i++;
	while(j < strlen(st1))
	{
		st[i] = st1[j];
		i++;
		j++;
	}
	st[i] = '\0';
	printf("st after concat is %s\n", st);
	
	return 0;
}
