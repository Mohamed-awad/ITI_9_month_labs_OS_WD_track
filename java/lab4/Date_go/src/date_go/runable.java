package date_go;

public class runable extends Thread {

	public static Thread th;
	public Date_go ap;
	public runable(Date_go d)
	{
		this.ap = d;
		th = new Thread(this);
		th.start();
	}
	
	public void run()
	{
		while(true)
		{
			this.ap.repaint();
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //you’ll need to catch an exception here
		}
	}
}
