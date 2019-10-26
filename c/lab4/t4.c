#include<stdio.h>
#include<string.h>
int main()
{
	char sh[15], cp[15]="mmmmm";
	int i = 0;
	printf(" the cp string is %s\n", cp);
	printf("enter string\n");
	scanf("%s", sh);
	while(sh[i] != '\0')
	{
		cp[i] = sh[i];
		i++;
	}
	cp[i] = '\0';
	printf("new cp string is %s\n", cp);
	
	return 0;
}
