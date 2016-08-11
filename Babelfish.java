import java.util.*;
public class Babelfish {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> dict = new HashMap<String, String>();
		String input = sc.nextLine();
		
		while(!(input.length() == 0)){
			String[] entries = input.split(" ");
			dict.put(entries[1], entries[0]);
			input = sc.nextLine();
		}
		
		
		while(sc.hasNextLine()){
			String foreign = sc.nextLine();
		    if(dict.containsKey(foreign)){
		    	System.out.println(dict.get(foreign));
		    } else {
		    	System.out.println("eh");
		    }
		  //  foreign = sc.nextLine();
		}
	}
}
