package world;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

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
	
	private static int worldX = 1;
	private static int worldY = 10;
	
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
	private static int floorWaterBottom = 20;
	private static int sandTop = 19;
	private static int sandBottom = 17;
	private static int rockTop = 16;
	private static int rockBottom = 13;
	private static int obsidianTop = 12;
	private static int obsidianBottom = 12;
	private static int lavaTop = 11;
	private static int LavaBottom = 0;
	private static String xy = "00";
	
	private static Integer[][] chunkArray = new Integer[worldX][worldY];
	
	public static void initializeWorld(){
		System.out.println("WORLD GENERATIONS BEGINING \nWorld X size = " + chunkArray.length + "\nWorld Y size = " + chunkArray[0].length);
		for(int x = 0; x < worldX; x++){
			for(int y = 0; y < worldY; y++){
				chunkArray[x][y] = findChunkType(y);
			}
		}
	}
	private static Integer findChunkType(int y){
		return 0;
	}
	
	public static Integer[][] getChunks(){
		return chunkArray;
	}
}
