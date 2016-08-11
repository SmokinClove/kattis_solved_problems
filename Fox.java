import java.io.*;
import java.util.*;
public class Fox {
	int N;
	String string;
	ArrayList<Character> alphabets;
		
	public String pangram(String s){
		String ans = "";
		alphabets = new ArrayList<Character>();
		TreeSet<Integer> set = new TreeSet<Integer>();	
		for(int i = 65; i < 91; i++){
			alphabets.add((char)i);
			set.add(i);
		}
		
		for(int i = 0; i < s.length(); i++){
		    if(Character.isLetter(s.charAt(i))){
		    	char c = s.charAt(i);
		    	if(set.contains((int)c)){
		    		set.remove((int)c);
		    		alphabets.remove(alphabets.indexOf(c));
		    	}
		    }
		}
		
		if(alphabets.isEmpty()){
			ans = "pangram";
		} else {
			ans += "missing ";
			
			for(int i = 0; i< alphabets.size(); i++){
				ans += Character.toLowerCase(alphabets.get(i));
			}
		}
		
		return ans;
		
	}

	void jump() throws Exception {
		    // do not alter this method to standardize the I/O speed (this is already very fast)
		    //IntegerScanner sc = new IntegerScanner(System.in);
		    Scanner sc = new Scanner(System.in);
		    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		    N = Integer.valueOf(sc.nextLine());
		    for(int i = 0; i < N; i++){
		    	pw.println(pangram(sc.nextLine().toUpperCase()));
		    }
		    pw.close();
		    
	}

		  
	public static void main(String[] args) throws Exception {
		 Fox fox = new Fox();
		 fox.jump();
	}
}

