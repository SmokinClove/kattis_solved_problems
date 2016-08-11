import java.util.*;
public class AA {
	
	public static void main(String[] args){
		AA AA = new AA();
		Scanner sc = new Scanner(System.in);
		String first = sc.nextLine();
		String second = sc.nextLine();
		if(first.length() >= second.length()){
			System.out.println("go");
		} else {
			System.out.println("no");
		}
	}	
}
