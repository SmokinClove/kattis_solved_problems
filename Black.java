import java.util.*;
public class Black {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer f, Integer s) {
				return list.get(f).get(0) - list.get(s).get(0);
			}
			
		});
		for(int i = 0; i < 7; i++){
			list.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < N; i++){
			list.get(sc.nextInt()).add(i);
		}
		int max = -1;
		for(int i = 0; i < 7; i++){
			if((list.get(i).size()) == 1){
				//q.add(i);		
				max = list.get(i).get(0);
			}
		}
		//if(!q.isEmpty()){
		if(max > -1){
			//System.out.println(q.poll());
			System.out.println(max + 1);
		} else {
			System.out.println("none");
		
		}
	}
}
