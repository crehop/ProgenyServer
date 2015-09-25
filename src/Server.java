import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(12253);
		Socket socket = serverSocket.accept();
		Scanner sc = new Scanner(socket.getInputStream());
	}

}
