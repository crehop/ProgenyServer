package world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class GameWorld {
	public static int PPM = 100;
	ArrayList<Chunk> worldChunk; 
	private float every60 = 0;
	private boolean created = false;
	Random rand = new Random();
	Integer[][] worldChunks;
	int width;
	private float gravity = -9.8f;
	private int yStrech = 650;
	private World world = new World(new Vector2(0,gravity), false);
	private Array<Body> bodies = new Array<Body>();
	//CREATURE 
	public GameWorld(int width) {
		this.width = width;
		WorldUtils.GenerateWorldBorder(getWorld(), 0, 23000, 7142, 34500);
		this.created = true;	 
		new Creature(getWorld(), new Location(2000,7000,0));
		new Creature(getWorld(), new Location(2000,7010,0));
		new Creature(getWorld(), new Location(2000,7020,0));
		new Creature(getWorld(), new Location(2000,7030,0));
		new Creature(getWorld(), new Location(2000,7040,0));
		new Creature(getWorld(), new Location(2000,7050,0));
		new Creature(getWorld(), new Location(2000,7060,0));
		new Creature(getWorld(), new Location(2000,7070,0));
		new Creature(getWorld(), new Location(2000,7080,0));
		new Creature(getWorld(), new Location(2000,7090,0));
		new Creature(getWorld(), new Location(2000,7100,0));
		new Creature(getWorld(), new Location(2000,7110,0));
		new Creature(getWorld(), new Location(2000,7120,0));
		new Creature(getWorld(), new Location(2000,7130,0));
	}
	public ArrayList<Chunk> getChunks(){
		return worldChunk;
	}
	public float getWidth() {
		return width;
	}
	public float getYStrech() {
		return this.yStrech;
	}
	public void update(float dt){
		every60 += dt;
		if(every60 > 60){
			every60 = 0;
			this.getWorld().getBodies(bodies);
		}
		this.getWorld().step(dt, 6, 2);
	}
	public World getWorld() {
		return world;
	}
	public void setWorld(World world) {
		this.world = world;
	}
	public Array<Body> bodies(){
		return this.bodies;
	}
}
