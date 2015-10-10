package world;

import java.util.ArrayList;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class WorldUtils {
	static PolygonShape shape;
	static FixtureDef fdef = new FixtureDef();
	private static int totalChunks;
	private static Body body;
	private static BodyDef def;
	private static GameWorld gameWorld;
	private static boolean isWorldCreated = false;


	public static void GenerateWorldBorder(World world,float x1,float x2,float y1,float y2){
		shape = new PolygonShape();
		def = new BodyDef();
		def.position.set(0,0);
		def.type = BodyType.StaticBody;
		body = world.createBody(def);
		float[] worldBorder = new float[8];
		worldBorder[0] = x1;
		worldBorder[1] = y1;
		worldBorder[2] = x1;
		worldBorder[3] = y2;
		worldBorder[4] = x1 + 2;
		worldBorder[5] = y2;
		worldBorder[6] = x1 + 2;
		worldBorder[7] = y1;
		shape.set(worldBorder);
		fdef.shape = shape;
		body.createFixture(fdef);
		
		worldBorder[0] = x1;
		worldBorder[1] = y1;
		worldBorder[2] = x2;
		worldBorder[3] = y1;
		worldBorder[4] = x2;
		worldBorder[5] = y1 - 2;
		worldBorder[6] = x1;
		worldBorder[7] = y1 - 2;
		shape.set(worldBorder);
		fdef.shape = shape;
		body.createFixture(fdef);		
		worldBorder[0] = x1;
		worldBorder[1] = y2;
		worldBorder[2] = x2;
		worldBorder[3] = y2;
		worldBorder[4] = x2;
		worldBorder[5] = y2 - 2;
		worldBorder[6] = x1;
		worldBorder[7] = y2 - 2;
		shape.set(worldBorder);
		fdef.shape = shape;
		body.createFixture(fdef);
		
		worldBorder[0] = x2;
		worldBorder[1] = y2;
		worldBorder[2] = x2 + 2;
		worldBorder[3] = y2;
		worldBorder[4] = x2 + 2;
		worldBorder[5] = y1;
		worldBorder[6] = x2;
		worldBorder[7] = y1;
		shape.set(worldBorder);
		fdef.shape = shape;
		body.createFixture(fdef);
		body.setSleepingAllowed(false);
	}
	
	public static void GenerateChunks(Integer[][] worldArray,ArrayList<Chunk> worldChunk, float yStrech){
		
		int xScroll = 0;
		int yScroll = 0;
		for(int currentX = 0; currentX < worldArray.length; currentX++){
			for(int currentY = 0; currentY < worldArray[0].length; currentY++){
				Chunk chunk = new Chunk(xScroll, yScroll, 0, worldArray[currentX][currentY]);
				chunk.setID(totalChunks);
				worldChunk.add(chunk);
				yScroll += yStrech;
			}
			xScroll += 1;
			yScroll = 0;
		}
	}

	public static void startPhysics() {
		gameWorld = new GameWorld(WorldCreation.getWorldWidth());
		setWorldCreated(true);
	}

	public static GameWorld getGameWorld() {
		return gameWorld;
	}

	public static void setGameWorld(GameWorld gameWorld) {
		WorldUtils.gameWorld = gameWorld;
	}

	public static boolean isWorldCreated() {
		return isWorldCreated;
	}

	public static void setWorldCreated(boolean worldCreated) {
		isWorldCreated = worldCreated;
	}
}
