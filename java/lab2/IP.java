package ip;
public class IP {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String arr = "";
		for (int i = 0; i < args[0].length(); i++)
        {
			if(args[0].charAt(i) == '.')
			{
				System.out.println(arr);
				arr = "";
			}
			else
			{
				arr += args[0].charAt(i);
			}
		}
        System.out.println(arr);
	}

}

