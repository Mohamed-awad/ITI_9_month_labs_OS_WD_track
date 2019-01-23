package stars;

public class Stars {
	public static void main(String [] args)
	{
		int num = Integer.parseInt(args[0]);
		for (int i = 0; i < num; i++)
		{
			for (int j = 0; j <= i; j++)
			{
				System.out.print("*");
			}
			System.out.print("\n");
		}
        System.out.print("\n");
		for (int i = 0; i < num; i++)
		{
			for (int j = num-1-i; j > 0; j--)
			{
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++)
			{
				System.out.print("* ");
			}
            System.out.print("\n");
		}
	}
}

