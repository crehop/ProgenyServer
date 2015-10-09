package packets;

import com.badlogic.gdx.physics.box2d.World;

public class Packet8WorldInfo extends Packet{
	public World world;
	
	public World GetWorld(){
		return this.world;
	}
	public void setWorld(World world){
		this.world = world;
	}
}
