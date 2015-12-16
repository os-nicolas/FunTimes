
public class Logger {
	
	private static boolean on = false;
	
	public static void turnOn(){
		on = true;
	}

	public static void turnOff(){
		on = false;
	}
	
	public static void d(String s){
		if (on){
			System.out.println(s);
		}
	}
}
