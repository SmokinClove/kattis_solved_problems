import java.util.*;
public class Decode {
    
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		sc.nextLine();
		while(TC -- > 0){
		    String message = sc.nextLine();
		    int size = (int)Math.sqrt((double)message.length());
		    char[][] arr = new char[size][size];
		    for(int i = 0; i < message.length(); i++){
			    arr[i/size][i%size] = message.charAt(i);
		    }
		
		    for(int i = size - 1; i >= 0;  i --){
			    for(int j = 0; j < size;  j++){
				    System.out.print("" + arr[j][i]);
			    }
		    }
		    System.out.println("");
		}
	}
}
