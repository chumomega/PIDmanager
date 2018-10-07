
public class Application {
	public static int[] pidStruct;
	final private int MIN_PID = 300;
	final private int MAX_PID = 5000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}
	
	public static int allocate_map() {
		pidStruct = new int[4700];
		
		if(pidStruct==null) {
			return -1;
		}
		else {
			return 1;
		}
	}
	
	
	public int allocate_pid() {
		for(int i=0; i<pidStruct.length; i++) {
			if(pidStruct[i]==0) {
				pidStruct[i]=1;
				return i+300;
			}
		}
		return -1;
	}
	
	
	public void release_pid(int pid) {
		if(pid<this.MIN_PID || pid>this.MAX_PID) {
			return;
		}
		else {
			pidStruct[pid-this.MIN_PID]=0;
		}
		
	}

}
