package packets;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class Packet2Body extends Packet{
	private BodyDef def;
	private float radius;
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
	public void setRadius(float radius) {
		this.radius = radius;		
	}
	public float getRaidus(){
		return this.radius;
	}
}