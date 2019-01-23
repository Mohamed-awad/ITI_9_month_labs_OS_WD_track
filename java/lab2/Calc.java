package calc;
public class Calc {
	
	public static boolean isNumeric(String strNum) {
	    return strNum.matches("-?\\d+(\\.\\d+)?");
	}
	public static void main(String [] args)
	{
		boolean flag = true;
		for(int i=0; i < args.length; i++)
		{

            System.out.println(args[i]);
			if(i == 0 || i == args.length-1)
			{
				if(!isNumeric(args[i]))
				{
                    System.out.println("wrong 1");
					flag = false;
					break;
				}
			}
			else
			{
				if(i % 2 != 0)
				{
					if(!(args[i].equals("+") || 
					   args[i].equals("-") ||
					   args[i].equals("*") ||
					   args[i].equals("/")))
					{
                        System.out.println("wrong 2 " + args[i]);
						flag = false;
						break;
					}
				}
				else
				{
					if((isNumeric(args[i]) && i+1 == args.length-1) || !isNumeric(args[i]))
					{
                        System.out.println("wrong 3");
						flag = false;
						break;
					}
				}
			}
		}
		if(!flag)
		{
			System.out.println("wrong expression");
			return;
		}
		int res = Integer.parseInt(args[0]);
		for (int i = 1; i < args.length-1; i++)
		{
			if(args[i].equals("+"))
			{
				res += Integer.parseInt(args[i+1]);
			}
			else if(args[i].equals("-"))
			{
				res -= Integer.parseInt(args[i+1]);
			}
			else if(args[i].equals("*"))
			{
				res *= Integer.parseInt(args[i+1]);
			}
			else if(args[i].equals("/"))
			{
                if(args[i+1].equals("0"))
                   {
                        System.out.println("wrong 4");
						flag = false;
						return;
					}
				res /= Integer.parseInt(args[i+1]);
			}
		}
		System.out.println("result is  " + res);
		
	}
}

