
public class TimeElapse {
	
	private long startTime;
	
	public TimeElapse(){
		start();
	}
	
	public void start(){
		this.startTime = System.nanoTime();
	}
	
	public void end() {
		float timeDiff = (System.nanoTime() - this.startTime)/1000000;
		System.out.println("Process time spent: [" + timeDiff + "] ms\n");
	}
}
