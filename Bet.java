import java.util.*;
public class Bet {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		sc.nextLine();
		while(TC -- > 0){
			System.out.println(solve(sc.nextInt(), sc.nextInt()));
			sc.nextLine();
		}
	}
	
	public static String solve(int sum, int diff){
		if((sum + diff)%2 == 1 || (sum - diff)%2== 1 || diff > sum){
			return "impossible";
		} else {
			return("" + (sum + diff)/2 + " " + (sum - diff)/2);
		}
	}
}
