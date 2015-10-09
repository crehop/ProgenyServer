package packets;

import com.badlogic.gdx.physics.box2d.Body;

public class Packet2Body extends Packet{
	private Body body;
	private int count;
	
	public int getID(){
		return count;
	}
	public Body getBody(){
		return body;
	}
	public int getCount() {
		return 0;
	}
	public void setBody(Body body){
		this.body = body;
	}
	public void setCount(int count){
		this.count = count;
	}
}
