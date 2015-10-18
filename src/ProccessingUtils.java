import packets.Packet2Body;
import world.WorldUtils;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;

public class ProccessingUtils {
	static int lastBody;
	public static Packet2Body processBody(ConnectionData data){
		
		Packet2Body packet2 = new Packet2Body();
		lastBody = data.getLastBody();
		if(lastBody >= WorldUtils.getGameWorld().bodies().size){
			data.setLastBody(1);
			lastBody = 1;
		}
		if(lastBody == 0){
			lastBody = 1;
		}
		if(lastBody >= WorldUtils.getGameWorld().bodies().size){
			packet2.setCount(-1);
			return packet2;
		}else{
			Body requested = WorldUtils.getGameWorld().bodies().get(lastBody);
			
			packet2.setCount(data.getLastBody());
			data.setLastBody(data.getLastBody() + 1);
			
			BodyDef def = new BodyDef();
			def.linearVelocity.set(requested.getLinearVelocity());
			def.position.set(requested.getPosition());
			packet2.setBodyDef(def);
		}
		
		return packet2;
	}
}
