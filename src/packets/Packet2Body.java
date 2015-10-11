package packets;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class Packet2Body extends Packet{
	private BodyDef def;
	private FixtureDef fdef;
	private int count;
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
	public void setFixDef(FixtureDef fdef){
		this.fdef = fdef;
	}
	public FixtureDef getFixDef(){
		return this.fdef;
	}
}