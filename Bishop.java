import java.util.*;
public class Bishop {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			System.out.println(bishop(Integer.valueOf(sc.nextLine())));
		}
	}
	
	public static int bishop(int size){
		if(size == 0) return 0;
		if(size == 1) return 1;
		
		return 2 * size - 2;
	}
}
