#include<stdio.h>
#include<conio.h>
#include<string.h>
#include<stdlib.h>

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
	int pos = 0 ;
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
				printf("%s", menu[pos]);
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
