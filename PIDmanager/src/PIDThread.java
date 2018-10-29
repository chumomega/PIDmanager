
public class PIDThread extends Thread {
	Application application;
	
	public PIDThread(Application app)
	{
		application =app;
	}
	public void run() {
		try {
			int pid =application.allocate_pid();
			System.out.println("Allocated pid: " + pid);
			int sec = (int) (Math.random()*9000)+1000;
			System.out.println("Thread sleeping for " + sec/1000 + " seconds");
			Thread.sleep(sec);
			System.out.println("Releasing PID " + pid);
			application.release_pid(pid);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
}

