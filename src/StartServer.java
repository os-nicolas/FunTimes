import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class StartServer {
	
	private static boolean logging = false;
	private static int port = 1990;
	
	// takes port logging
	public static void main(String... args){
		
		paseParms(args);
				
		new Server().listenForConnection(1990);
	}

	private static void paseParms(String[] args) {
		if (args.length > 0){
			port = Integer.parseInt(args[0]);			
		}
		if (args.length > 1){
			logging = Arrays.asList(new String[] {"yes","y"}).contains(args[1].toLowerCase());
		}
		
		
		if (logging){
			Logger.turnOn();
		}else{ 
			Logger.turnOff();
		}
	}
}
