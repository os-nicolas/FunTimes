import java.io.IOException;
import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	static int DEFAULT_PORT = 1990;
	
	static int portnum;
	static String ip_addr;
	
	static Socket socket;
	
	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println("Usage: Client ipaddress [portnum]");
			return;
		}
		if(args.length > 0){
			ip_addr = (String)args[0];
		}
		if(args.length > 1){
			portnum = Integer.parseInt(args[1]);
		}
		else{
			portnum = DEFAULT_PORT;
		}
		
		socket = new Socket();
		try {			
			socket = new Socket(InetAddress.getByName(ip_addr), portnum);
		} catch (UnknownHostException tantrum) {
			tantrum.printStackTrace();
		} catch (IOException fit) {
			fit.printStackTrace();
		}
		
		if(!socket.isConnected()){
			System.out.println("Socket not connected");
			return;
		}	
		else{
			System.out.println("Connected to " + socket.getRemoteSocketAddress().toString());
		}
		
		Scanner keylistener = new Scanner(System.in);
		while(true){
			String text = keylistener.nextLine();
			try {
				socket.getOutputStream().write(text.getBytes());
				socket.getOutputStream().flush();
			} catch (IOException tantrum) {
				tantrum.printStackTrace();
				break;
			}
			System.out.println("You sent: " + text);
		}
		
		keylistener.close();
		return;
	}
	
	

}
