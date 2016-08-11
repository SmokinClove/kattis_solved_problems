import java.util.*;
public class Axian {

	public static void main(String[] agrs ){
		Scanner sc = new Scanner(System.in);
		String test = sc.nextLine();
		System.out.println(truncate(test, ""));
	}
	
	public static String truncate(String s, String ans){
	//	System.out.println("length = " + s.length());
		if(s.length() == 0 ){
	//		System.out.println("ending cuz string empty, s = " + s);
			return ans ;
		} else if(s.length() == 1 ){
	//		System.out.println("add " + s);
			return ans + s ;
		} else {
			char f = s.charAt(0);
			ans += f;
		    for(int i=  0; i < s.length(); i++){
		    	if(!(s.charAt(i) == f)){
		//    		System.out.println("in loop! i= " + i);
		//    		System.out.println(s.charAt(i));
		    		ans = truncate(s.substring(i), ans);
		    		break;
		    	}
		    }
		}
	//	System.out.println("ans = " + ans);
		return ans;
	}
}
