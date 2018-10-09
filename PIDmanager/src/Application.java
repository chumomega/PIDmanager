import java.util.HashMap;
import java.util.Map;

public class Application {
	// Data structure to keep track of the PIDs in use
	public static Map<Integer, Integer> pidStruct;

	// Range of the PIDs
	final static private int MIN_PID = 300;
	final static private int MAX_PID = 5000;

	public static void main(String[] args) {
		// Test the functions
		allocate_map();
		if (allocate_map() == 1) {
			System.out.println("The structure to contain the PID number has been created");
		} else if (allocate_map() == -1) {
			System.out.println("The structure to contain the PID number has not been created");
		}
		int first = allocate_pid(), second = allocate_pid(), third = allocate_pid();

		System.out.println("Allocating 3 PID numbers... They are " + first + ", " + second + ", " + third);
		System.out.println("Releasing the PID numbers " + first + ", " + second + ", " + (third) + "....done");
		release_pid(first);
		release_pid(second);
		release_pid(third);

	}

	/**
	 * Creates and initializes a data structure for representing PIDs
	 * 
	 * @return -1 if unsuccessful and 1 if successful
	 */
	public static int allocate_map() {
		pidStruct = new HashMap<Integer, Integer>();

		// add the numbers within the range of MAX and MIN PIDs with default value 0
		for (int i = MIN_PID; i <= MAX_PID; i++) {
			pidStruct.put(i, 0);
		}
		if (pidStruct == null)
			return -1;
		return 1;

	}

	/**
	 * Allocates and returns a PID
	 * 
	 * @return -1 if if unable to allocate a PID (all PIDs are in use) otherwise,
	 *         the PID is returned
	 */
	public static int allocate_pid() {
		
		// allocate the "first" available PID
		for (int i : pidStruct.keySet()) {
			if (pidStruct.get(i) == 0) {
				pidStruct.put(i, 1);
				return i;
			}
		}

		return -1;
	}

	/**
	 * Releases a PID that has already been allocated.
	 * 
	 * @param pid holds the value of the PID to be released
	 */
	public static void release_pid(int pid) {

		if (pidStruct.containsKey(pid)) {
			pidStruct.remove(pid);
		}

	}

}
