package packets;

public class Packet3RequestBody extends Packet{
	private int ID = 0;

	public int requestedID(){
		return this.ID;
	}
	public void setID(int ID){
		this.ID = ID;
	}
}
