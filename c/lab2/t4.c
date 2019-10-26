#include<stdio.h>
int main() 
{
	int num1, num2, res, flag=1;
	char op;
	do {		
		printf("enter first number\n");
		scanf("%d", &num1);
		printf("enter second number\n");
		scanf("%d", &num2);
		printf("enter op\n");
		scanf("%c", &op);
		scanf("%c", &op);
		switch(op){
			case '+':
				res = num1 + num2;
				break;
			case '-':
				res = num1 - num2;
				break;
			case '*':
				res = num1 * num2;
				break;
			case '/':
				res = num1 + num2;
				break;
			default:
				flag = 0;
				printf("error op\n");
		}
	}while(!flag);
	printf("the result is %d\n", res);
	return 0 ;
}
