#include<stdio.h>
#include<stdlib.h>
void gotoxy(int x, int y){
	printf("%c[%d;%df", 0x1B,y, x);
}
int main() 
{
	int size, i, row , col;
	int arr[15][15]={};	
	printf("enter size of magic box\n");
	scanf("%d", &size);
	row = 1;
	col = (size/2)+1;
	arr[row][2] = 1;
	for(i = 2 ; i <= size * size; i++)
	{
		if((i-1) % size != 0)
		{
			col--;
			row--;
		}
		else
			row++;
		if(col == 0)
			col = size;
		if(row ==0)
			row = size;
		if(row == size+1)
			row = 1;
		arr[row][col] = i;
	}
	for(i=1;i<=size;i++)
	{
		for(int j = 1; j <= size; j++)
			printf("%d ", arr[i][j]);
		printf("\n");
	}
	return 0 ;
}
