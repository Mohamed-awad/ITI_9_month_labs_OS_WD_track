#include<stdio.h>
#include<string.h>
int main()
{
	char sh[15];
	int i = 0;
	printf("enter string\n");
	scanf("%s", sh);
	while(sh[i] != '\0')
		i++;
	printf("len of string is %d\n", i);
	
	return 0;
}
