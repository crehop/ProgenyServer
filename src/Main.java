
import gui.GUI;
import gui.Terminal;

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
	        			System.out.println();
	        			packet1 = (Packet1Connect)object;
	        			System.out.println(packet1.getName());
	        			packet1.setName(" Welcome to HopNet " + packet1.getName() + " !");
	        			server.sendToUDP(connection.getID(), packet1);
	        		}
	        	}
	        	packets++;
	        	System.out.println("PACKET! " + packets + " " + object.getClass());
	        }
	     });
	}

}
