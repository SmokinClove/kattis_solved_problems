//TLE 12:23am 28 Dec ;(
import java.util.*;
public class ClosestSum {
    private TreeSet<Integer> q;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int _case = 0;
		ClosestSum sum = new ClosestSum();
		while(sc.hasNextLine()){
			int N = Integer.valueOf(sc.nextLine());
			int[] arr = new int[N];
			System.out.println("Case " + ++_case + ":");
			for(int i = 0; i < N; i++){
				arr[i] = sc.nextInt();
				sc.nextLine();
			}
			int m = sc.nextInt();
			sc.nextLine();
			sum.preprocess(arr);
			for(int j = 0; j < m; j++){
			    System.out.println(sum.solve(Integer.valueOf(sc.nextLine())) + ".");
			}
		}
	}
	
	public void preprocess(int[] arr){
		q= new TreeSet<Integer>();
		for(int i = 0; i< arr.length; i++){
			for(int j = i + 1; j < arr.length; j++){
				q.add(arr[j] + arr[i]);
			}
		}
	}
	
	public int solve(int sum){
		System.out.print("Closest sum to " + sum + " is ");
		SortedSet<Integer> head = q.headSet(sum);
	    SortedSet<Integer> tail = q.tailSet(sum);
	    int last;
	    last = (head.isEmpty()) ? 1000000 : head.last();
	    int first;
	    first = (tail.isEmpty())? 1000000 : tail.first();
		return Math.abs(last - sum) > Math.abs(first - sum)? first : last;
	}
}
