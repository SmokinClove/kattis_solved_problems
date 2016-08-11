//accepted!!! =D 1:22AM 14/01/16
import java.util.Scanner;

public class Artichoke {
    int size;
    double min = 0.00;
	void cal(int p, int a, int b, int c, int d, int n){
		size = n;
		double curr;
		double max = -1000000000;
		for(int k = 1; k <= n ; k++){
	        curr = p * (Math.sin((double)(a*k + b)) + Math.cos((double)(c*k + d)) + 2);
	    	if(curr > max) max = curr;
	    	if(curr < max) {
	    		min = Math.max(min, max - curr);
	    	}
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		cal(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println(min);
        sc.close();
	}
	
	public static void main(String[] args){
		Artichoke a = new Artichoke();
		a.run();
	}
}


