
public class Test {

	public static void main(String[] args) {
		Application app = new Application();
		PIDThread thread;
		for (int i=0; i <10; i ++) {
			 thread= new PIDThread(app);
			 thread.start();
		}
		

	}

}
