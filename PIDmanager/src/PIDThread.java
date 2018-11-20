import java.util.concurrent.Semaphore;

public class PIDThread extends Thread {
	final static Application application = new Application(); // give the threads access to a single PID Data Struct
	static Semaphore semaphore = new Semaphore(1);

	public void run() {
		try {
			semaphore.acquire();
			try {

				int pid = application.allocate_pid();
				System.out.println("Allocated pid: " + pid);

				// Create Random seconds to sleep the thread
				int sec = (int) (Math.random() * 9000) + 1000;
				System.out.println("Thread " + pid + " sleeping for " + sec / 1000 + " seconds");
				Thread.sleep(sec);

				System.out.println("Releasing PID " + pid);
				application.release_pid(pid);
			} finally {
				semaphore.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
