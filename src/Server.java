import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
	static int number;
	String temp = "NULL";

	public static void main(String[] args) throws IOException {
		System.out.println("SERVER START");
		ServerSocket serverSocket = new ServerSocket(12253);
		System.out.println("SERVER SOCKET CREATED");
		Socket socket = serverSocket.accept();
		System.out.println("SOCKET CREATED");
		Scanner sc = new Scanner(socket.getInputStream());
		System.out.println("SCANNER CREATED");
		String temp = sc.nextLine();
		System.out.println(temp);
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		printStream.println("SERVER CONNECTION SUCCESSFUL!" + temp);
		System.out.println("SERVER END");
	}

}
