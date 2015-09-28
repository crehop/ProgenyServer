
import gui.GUI;
import gui.Terminal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import packets.Packet;
import packets.Packet1Connect;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;


public class Main {
	static int packets = 0;
	static Packet1Connect packet1;
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
		
		//INITIATE THE GUI
		Terminal terminal = new Terminal();
		
		//WHEN PACKET SENT, THIS FUNCTION RUNS
	    server.addListener(new Listener() {
	        public void received (Connection connection, Object object) {
	        	if(object instanceof Packet){
	        		if(object instanceof Packet1Connect){
	        			packet1 = (Packet1Connect)object;
	        			packet1.logout(true);
	    	        	System.out.println("PACKET! " + packets + " " + object.getClass() +" " + packet1.logout());
	        			if(username.equals(packet1.getUsername())){
	        				if(password.equals(packet1.getPassword())){
	        					packet1.logout(false);
	        				}
	        			}
	    	        	System.out.println("PACKET! " + packets + " " + object.getClass() +" " + packet1.logout());
	        			System.out.println(packet1.getUsername());
	        			packet1.setUsername(" Welcome to HopNet " + packet1.getUsername() + " !");
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
	        			
	        		}
	        	}
	        	packets++;
	        	System.out.println("PACKET! " + packets + " " + object.getClass());
	        }
	     });
	}

}
