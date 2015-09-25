import java.io.IOException;

import com.esotericsoftware.kryonet.Server;


public class Main {
	static int number;
	String temp = "NULL";

	public static void main(String[] args) throws IOException{
		Server server = new Server();
		server.start();
		server.bind(36626,32352);
		
	}

}
