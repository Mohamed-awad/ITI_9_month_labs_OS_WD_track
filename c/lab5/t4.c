#include<stdio.h>
#include<conio.h>
#include<string.h>
#include<stdlib.h>
struct emp {
	int id;
	char name[20];
	float salary;
};
void print_menu(char menu[][10], pos) {
	clrscr();
	for(int i = 0 ; i < 3; i ++)
	{
		if(i == pos)
			textattr(0x70);
		cprintf("%s\n", menu[i]);
		textattr(0x07);
	}
}
int main()
{
	struct emp arr[5];
	for(int i = 0 ; i < 5; i++)
		arr[i].id = -1;
	int pos = 0 , pos1;
	char ch;
	int flag = 0;
	char menu[3][10] = {"new", "display", "exit"};
	do {
		print_menu(menu);
		scanf("%c", &ch);
		switch(ch)
		{
			case NULL:
				scanf("%c", &ch);
				switch(ch)
				{
					case 72: // arrow up
						pos--;
						if(pos == -1)
							pos = 2;
						break;
					case 80: //arrow down
						pos++;						
						if(pos == 3)
							pos = 0;
						break;
					case 71: //home
						pos = 0;
						break;
					case 79: //end
						pos = 2;
						break;
				}
				print_menu(menu, pos);
				break;
			case 13:
				clrscr();
				//printf("%s", menu[pos]);
				switch(pos)
				{
					case 0:
						int f = 1;
						do{
							printf("plz enter the position of your new employee from 1 to 5\n");						
							scanf("%d", &pos1);
							pos1--;
							if(arr[pos1].id != -1)
							{
								f = 0;
								printf("error position try again\n");
							}
							else {
								f =1;
								printf("enter your id\n");
								scanf("%d", &arr[pos1].id);
								printf("enter your name\n");
								scanf("%s", arr[pos1].name);
								printf("enter your salary\n");
								scanf("%f", &arr[pos1].salary);
								printf("thank  you\n");
								
							}
						}while(!f)
						break;
					case 1:
						for(int i = 0 ; i < 5 ; i++)
						{
							if(arr[i].id == -1)
								continue;
							printf("information for %d employee is\n", i+1);
							printf("your information is:- \n");
							printf("your id is %d\n", arr[i].id);
							printf("your name is %s\n", arr[i].name);
							printf("your salary is %f\n", arr[i].salary);
							printf("-----------------------------------------------\n");
						}
						break;
				}
				if(pos == 2)
					flag = 1;
				scanf("%c", &ch);
				break;
			case 27:
				flag = 1;
				break;
		}
	}while(!flag);
	return 0;
}
