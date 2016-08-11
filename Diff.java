import java.util.*;
import java.math.BigInteger;

public class Diff {
  
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			System.out.println((sc.nextBigInteger().add(sc.nextBigInteger().negate())).abs());
		}
	}
}
