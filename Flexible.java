import java.util.*;
public class Flexible {
    
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		//sc.nextLine();
		int p = sc.nextInt();
		sc.nextLine();
		int[] arr = new int[p + 2];
		arr[0] = 0;
		arr[p+1] = w;
		for(int i = 1; i <= p ; i++){
			arr[i] = sc.nextInt();
		//	System.out.println(arr[i]);
		}
		sc.nextLine();
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i = 0; i < p + 2; i++){
			for(int j = i + 1; j < p + 2; j++){
				if(!q.contains(arr[j] - arr[i])) q.add(arr[j] - arr[i]);
			}
		}
		while(q.size() > 1){
			System.out.print(q.poll() + " ");
		}
		System.out.println(q.poll());
	}
}
