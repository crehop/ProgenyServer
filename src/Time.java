
import java.util.Timer;
import java.util.TimerTask;

import world.WorldUtils;

public class Time {
	public static Timer timer = new Timer();
	public static float time = 0;
	private float lastTime;
	private final float ticks = 60.0f;
	private float ns = 1000000000 / ticks;    
	private float delta = 0;	
	private float now;
	public static boolean paused;
	public static long START_TIME;
	public float FPS;
	public Time(){
		START_TIME = System.currentTimeMillis();
		timer.schedule(new TimerTask(){
            public void run() {
            	if(lastTime == 0)lastTime = System.nanoTime();
                now = System.nanoTime();
            	delta = (now - lastTime)/ns;
            	lastTime = now;
            	if(WorldUtils.isWorldCreated())WorldUtils.getGameWorld().update((float) delta);;
            }
        },0, 1*1000/60);
	}
	public static float getTime(){
		return time;
	}
	public static boolean isPaused(){
		if(paused){
			return true;
		}
		return false;
	}
}
