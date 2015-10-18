import packets.Packet2Body;
import world.Location;
import world.WorldUtils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;

public class ProccessingUtils {
	static int lastBody;
	public static Packet2Body processBody(ConnectionData data){
		
		lastBody = data.getLastBody();
		if(lastBody >= WorldUtils.getGameWorld().bodies().size){
			data.setLastBody(1);
			lastBody = 1;
		}
		if(lastBody == 0){
			lastBody = 1;
		}
		if(lastBody >= WorldUtils.getGameWorld().bodies().size || WorldUtils.getGameWorld().bodies().get(lastBody).getFixtureList() == null){
			Packet2Body packet2 = new Packet2Body();
			packet2.setLocation(0, 0, 0);
			packet2.setCount(-1);
			return packet2;
		}else{
			Body requested = WorldUtils.getGameWorld().bodies().get(lastBody);
			FixtureDef fdef = new FixtureDef();
			fdef.shape = requested.getFixtureList().first().getShape();
			BodyDef def = new BodyDef();
			def.linearVelocity.set(requested.getLinearVelocity());
			def.position.set(requested.getPosition());
			def.angle = requested.getAngle();
			Packet2Body packet2 = new Packet2Body();
			packet2.setRadius(fdef.shape.getRadius());
			packet2.setLocation(requested.localVector.x,requested.localVector.y,requested.getAngle());
			packet2.setBodyDef(def);
			packet2.setCount(data.getLastBody());
			data.setLastBody(data.getLastBody() + 1);
			return packet2;
		}
	}
}
