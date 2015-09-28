package packets;

public class Packet {
	private int priority;
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
		if(this.priority > 10){
			this.priority = 10;
		}
		if(this.priority < 0){
			this.priority = 0;
		}
	}
}
