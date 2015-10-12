
public class ConnectionData {
	private int ID;
	private int lastBody;
	private int duration;
	
	
	public ConnectionData(int ID){
		this.ID = ID;
		this.lastBody = 0;
		this.duration = 0;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getLastBody() {
		return lastBody;
	}
	public void setLastBody(int lastBody) {
		this.lastBody = lastBody;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
