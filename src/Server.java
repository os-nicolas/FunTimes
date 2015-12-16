import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public Server() {
	}

	public void listenForConnection(int port) {
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			serverSocket = new ServerSocket(port);
			Logger.d("listening on port: " + port);
			clientSocket = serverSocket.accept();
			Logger.d("connected");
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));

			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				out.println(inputLine);
				Logger.d(inputLine);
				if (inputLine.equals("Bye."))
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			Logger.d("closing");
			
			// a lot of stuff to close

			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (clientSocket != null) {
				try {
					clientSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				out.close();
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
