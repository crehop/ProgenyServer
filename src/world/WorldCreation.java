package world;

import com.badlogic.gdx.physics.box2d.World;

public class WorldCreation {
	private static final int AIR = 0;
	private static final int TOP_WATER_LAYER = 1;
	private static final int SHALLOW_WATER = 2;
	private static final int WATER = 3;
	private static final int DEEP_WATER = 4;
	private static final int FLOOR_WATER = 5;
	private static final int SAND = 6;
	private static final int DIRT = 7;
	private static final int ROCK = 8;
	private static final int OBSIDIAN = 9;
	private static final int LAVA = 10;
	
	private static int worldY = 100;
	private static int worldX = 27500;
	
	private static int airTop = 100;
	private static int airBottom = 90;
	private static int topWaterTop = 89;
	private static int topWaterBottom = 80;
	private static int shallowWaterTop = 79;
	private static int shallowWaterBottom = 70;
	private static int waterTop = 69;
	private static int waterBottom = 60;
	private static int deepWaterTop = 59;
	private static int deepWaterBottom = 45;
	private static int floorWaterTop = 44;
	private static int floorWaterBottom = 21;
	private static int sandTop = 20;
	private static int sandBottom = 18;
	private static int dirtTop = 17;
	private static int dirtBottom = 16;
	private static int rockTop = 15;
	private static int rockBottom = 4;
	private static int obsidianTop = 3;
	private static int obsidianBottom = 1;
	private static int lavaTop = 0;
	private static int lavaBottom = 0;
	
	private static Integer[][] chunkArray = new Integer[1][worldY];
	
	public static void initializeWorld(){
		for(int y = 0; y < chunkArray[0].length; y++){
			chunkArray[0][y] = findChunkType(y);
		}
		WorldUtils.startPhysics();
	}
	private static Integer findChunkType(int y){
		if(y <= airTop &&  y >= airBottom){
			return AIR;
		}else if(y <= topWaterTop && y >= topWaterBottom){
			return TOP_WATER_LAYER;
		}else if(y <= shallowWaterTop && y >= shallowWaterBottom){
			return SHALLOW_WATER;
		}else if(y <= waterTop && y >= waterBottom){
			return WATER;
		}else if(y <= deepWaterTop && y >= deepWaterBottom){
			return DEEP_WATER;
		}else if(y <= floorWaterTop && y >= floorWaterBottom){
			return FLOOR_WATER;
		}else if(y <= sandTop && y >= sandBottom){
			return SAND;
		}else if(y <= dirtTop && y >= dirtBottom){
			return DIRT;
		}else if(y <= rockTop && y >= rockBottom){
			return ROCK;
		}else if(y <= obsidianTop && y >= obsidianBottom){
			return OBSIDIAN;
		}else if(y <= lavaTop && y >= lavaBottom){
			return LAVA;
		}
		return AIR;
	}
	
	public static Integer[][] getChunks(){
		return chunkArray;
	}
	public static int getWorldWidth() {
		return worldX;
	}
}
