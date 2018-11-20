
/**
 * This class tests the PIDThreads
 *
 */
public class Test {

	public static void main(String[] args) {
		PIDThread thread;
		for (int i=0; i <=15; i ++) { //create multiple threads
			 thread= new PIDThread();
			 thread.start();
		}
		

	}

}
