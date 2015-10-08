package world;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Chunk {
	int type;
	int ID = 0;
	Location location;
	Random Rand = new Random();
	TextureRegion region;
	
	public Chunk(int x, int y, int z, int type){
		this.location = new Location(x,y,z);
		this.type = type;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
	public int getID(){
		return ID;
	}
}
