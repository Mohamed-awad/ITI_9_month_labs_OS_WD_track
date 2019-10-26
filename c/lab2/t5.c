#include<stdio.h>
int main() 
{
	int flag=1, i = 0;
	char ch='x';
	
	do {
		switch(ch){
			case 'n':
			case 'N':
				printf("new is selected\n");
				break;
			case 'd':
			case 'D':
				printf("display is selected\n");
				break;
			case 'e':
			case 'E':
			case 27:
				flag = 0;
				printf("exit is selected\n");
				break;
		}
		if(!flag)
			break;
		printf("enter one of there characters n or d or e\n");
		printf("New\nDisplay\nExit\n");
		if(i){
			scanf("%c", &ch);
		}
		i=1;
		scanf("%c", &ch);
		//printf("enter one of there characters n or d or e\n");
		//printf("New\nDisplay\nExit\n");
	}while(flag);
	
	return 0 ;
}
