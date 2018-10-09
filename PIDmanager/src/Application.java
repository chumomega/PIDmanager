import java.util.HashSet;

public class Application {
	public static HashSet<Integer> pidStruct;
	final static private int MIN_PID = 300;
	final static private int MAX_PID = 5000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		allocate_map();
		if(allocate_map()== 1) {
			System.out.println("The structure to contain the PID number has been created");
		}
		else if (allocate_map()== -1) {
			System.out.println("The structure to contain the PID number has not been created");
		}
		int first = allocate_pid(), second = allocate_pid(), third = allocate_pid();
		
		System.out.println("Allocating 3 PID numbers... They are " + first + ", " + second + ", " + third);
		System.out.println("Releasing the PID numbers " + first + ", " + second + ", " + (third) + "....done");
		release_pid(first);
		release_pid(second);
		release_pid(third);

	}

	public static int allocate_map() {
		pidStruct = new HashSet<Integer>();

		if (pidStruct == null)
			return -1;
		return 1;

	}

	public static int allocate_pid() {
		int pid_no = MIN_PID + pidStruct.size();
		
		if (pid_no < MIN_PID || pid_no > MAX_PID) {
			return -1;
		}
		
		pidStruct.add(pid_no);
		
		return pid_no;
	}

	public static void release_pid(int pid) {
		
		if (pidStruct.contains(pid)) {
			pidStruct.remove(pid);
		}

	}

}
