import java.util.HashSet;

public class Application {
	public static HashSet<Integer> pidStruct;
	final private static int MIN_PID = 300;
	final private int MAX_PID = 5000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		allocate_map();

	}

	public static int allocate_map() {
		pidStruct = new HashSet<Integer>();

		if (pidStruct == null)
			return -1;
		return 1;

	}

	public int allocate_pid() {
		int pid_no = MIN_PID + pidStruct.size();
		
		if (pid_no < MIN_PID || pid_no > MAX_PID) {
			return -1;
		}
		pidStruct.add(pid_no);
		return 1;
	}

	public void release_pid(int pid) {
		
		if (pidStruct.contains(pid)) {
			pidStruct.remove(pid);
		}

	}

}
