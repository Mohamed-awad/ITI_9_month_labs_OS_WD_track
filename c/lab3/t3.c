#include<stdio.h>
int arr[15][15] = {};
void magic_box(int size)
{	int i, row , col;
	if(size % 2 == 0)
		return;
	row = 1;
	col = (size/2)+1;
	arr[row][col] = 1;
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
}
int main() 
{
	int size, i, row , col;
	do{	
		printf("enter odd size of magic box\n");
		scanf("%d", &size);
	}while(size % 2 ==0);
	magic_box(size);
	return 0 ;
}
