import packets.Packet2Body;
import world.WorldUtils;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;


public class ProccessingUtils {
	public static Packet2Body processBody(ConnectionData data){
		
		Packet2Body packet2 = new Packet2Body();
		
		if(data.getLastBody() >= WorldUtils.getGameWorld().bodies().size){
			data.setLastBody(0);
		}
		Body requested = WorldUtils.getGameWorld().bodies().get(data.getLastBody());
		
		packet2.setCount(data.getLastBody());
		data.setLastBody(data.getLastBody() + 1);
		
		BodyDef def = new BodyDef();
		def.active = requested.isActive();
		def.linearVelocity.set(requested.getLinearVelocity());
		def.position.set(requested.getPosition());
		FixtureDef fdef = new FixtureDef();
		fdef.shape = requested.getFixtureList().first().getShape();
		fdef.density = requested.getFixtureList().first().getDensity();
		packet2.setBodyDef(def);
		packet2.setFixDef(fdef);
	
		
		return packet2;
	}
}
