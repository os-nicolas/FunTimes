import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public void listenForConnection(int port) {
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			Socket clientSocket = serverSocket.accept();
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
					true);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			
			String inputLine, outputLine;
			
			 CommunicationProtocol communication = new CommunicationProtocol();
			 outputLine = communication.processInput(null);
			 out.println(outputLine);

			    while ((inputLine = in.readLine()) != null) {
			        outputLine = communication.processInput(inputLine);
			        out.println(outputLine);
			        if (outputLine.equals("Bye."))
			            break;
			    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
