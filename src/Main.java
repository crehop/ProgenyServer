
import gui.Terminal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import neuralNetwork.NeuralNet;
import packets.Packet;
import packets.Packet1Connect;
import packets.Packet2Body;
import packets.Packet3RequestBody;
import packets.Packet7WorldCreation;
import packets.Packet8WorldInfo;
import world.WorldCreation;
import world.WorldUtils;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;


public class Main {
	static int packets = 0;
	static Packet1Connect packet1;
	static Packet2Body packet2;
	static Packet3RequestBody packet3;
	static Packet8WorldInfo packet8;
	static Packet8WorldInfo packet82;

	static Packet7WorldCreation packet7;
	static String password = "password";
	static String username = "crehop";

	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.start();

		//TCP PORT 54555 CONFIRMED PACKAGE (GARUNTEED DELIVERY)
		//UDP PORT 54777 SEND AND FORGET GETS SENT NO CONFIRMATION
		//server.bind(TCP,UDP)
		server.bind(54555,54777);
		
		//REGISTER THE CLASS!
		server.getKryo().register(Packet.class);
		server.getKryo().register(Packet1Connect.class);
		server.getKryo().register(Packet2Body.class);
		server.getKryo().register(Body.class);
		server.getKryo().register(Packet3RequestBody.class);
		server.getKryo().register(Packet8WorldInfo.class);
		server.getKryo().register(Packet7WorldCreation.class);
		server.getKryo().register(Integer[][].class);
		server.getKryo().register(Integer[].class);
		
		//INITIATE THE GUI
		Terminal terminal = new Terminal();
		Time time = new Time();
		//NeuralNet asimov = new NeuralNet();
		//asimov.activateNetwork();
		WorldCreation.initializeWorld();
		
		//WHEN PACKET SENT, THIS FUNCTION RUNS
	    server.addListener(new Listener() {
	        public void received (Connection connection, Object object) {
	        	if(object instanceof Packet){
	        		if(object instanceof Packet1Connect){
	        			packet1 = (Packet1Connect)object;
	        			packet1.logout(true);
	    	        	confirmLogin(packet1.getUsername(), packet1.getPassword());
	        			System.out.println(packet1.getUsername());
	        		    try {
	        		        BufferedWriter out = new BufferedWriter(new FileWriter("database/users.txt"));
	        		            for (int i = 0; i < 4; i++) {
	        		                out.write("U:" + packet1.name + " P:" + packet1.getPassword() + "\n");
	        		            }
	        		            out.close();
	        		        } 
	        		    catch (IOException e) {   	
	        		    	e.printStackTrace();
	        		    }
	        			server.sendToUDP(connection.getID(), packet1);
	        			
	        		}else if(object instanceof Packet7WorldCreation){
	        			System.out.println("WORLD CREATE CONFIRMED");
	        			packet7 = new Packet7WorldCreation(WorldCreation.getChunks(), WorldCreation.getWorldWidth());
	        			server.sendToUDP(connection.getID(), packet7);
	        		}else if(object instanceof Packet3RequestBody){
	        			System.out.println(" PACKET BODY CONFIRMED");
	        			packet3 = (Packet3RequestBody)object;
        				packet2 = new Packet2Body();
        				packet2.setBody(WorldUtils.getGameWorld().bodies().get(packet3.requestedID()));
        				packet2.setCount(WorldUtils.getGameWorld().getWorld().getBodyCount());
        				
        				server.sendToUDP(connection.getID(), packet2);
	        		}else if(object instanceof Packet7WorldCreation){
        				System.out.println("WORLD GET info PACKET  CONFIRMED");
        				packet8 = (Packet8WorldInfo)object;
        				packet82 = new Packet8WorldInfo();
        				packet82.setWorld(WorldUtils.getGameWorld().getWorld());
        				server.sendToUDP(connection.getID(), packet8);
        		}

	        	}
	        	packets++;
	        }
	     });
	}

	protected static void confirmLogin(String username2, String password2) {
		if(username.equals(packet1.getUsername())){
			if(password.equals(packet1.getPassword())){
				packet1.logout(false);
			}
		}
	}
}
