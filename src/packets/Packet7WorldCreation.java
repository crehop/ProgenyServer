package packets;

public class Packet7WorldCreation extends Packet {
	Integer[][] world;
	private boolean worldRecieved = false;
	public Packet7WorldCreation(Integer[][] world){
		this.world = world;
		this.worldRecieved = true;
	}
	public Packet7WorldCreation(){
		this.worldRecieved = false;
	}
	public Integer[][] getWorld(){
		return world;
	}
	public boolean worldRecieved() {
		return this.worldRecieved;
	}
}
