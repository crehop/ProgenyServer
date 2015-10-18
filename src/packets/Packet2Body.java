package packets;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;

public class Packet2Body extends Packet{
	private BodyDef def;
	private int count;
	public Vector2 location;
	private float angle;
	public int getID(){
		return count;
	}
	public BodyDef getBodyDef(){
		return def;
	}
	public void setBodyDef(BodyDef def){
		this.def = def;
	}
	public void setCount(int count){
		this.count = count;
	}
	public void setLocation(float x,float y, float angle){
		this.location = new Vector2(x,y);
		this.angle = angle;
	}
	public float getAngle(){
		return this.angle;
	}
}