import java.util.*;
public class Tower {
 
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[][] arr = new int[6][6];
		boolean[] visited = new boolean[6];
		String[] nums = sc.nextLine().split(" ");
		int firstHeight = Integer.valueOf(nums[6]);
		int secondHeight = Integer.valueOf(nums[7]);
		TreeSet<Integer> first = new TreeSet<Integer>();
		TreeSet<Integer> second = new TreeSet<Integer>();
		for(int i = 0; i < 6; i++){
			map.put(Integer.valueOf(nums[i]), i);
			for(int j = 0; j < 6; j++){
				if(i != j) arr[i][j] = Integer.valueOf(nums[i]) + Integer.valueOf(nums[j]);
			}
		}
		
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(i != j) {
					if(map.containsKey(firstHeight - arr[i][j])){
						visited[i] = true;
						visited[j] = true;
						int third = firstHeight - arr[i][j];
						visited[map.get(third)] = true;
						int _second = 0;
						for(int k = 0; k < 6; k++){
							if(!visited[k]) _second += Integer.valueOf(nums[k]);
						}
						
						if(_second == secondHeight){
						    first.add(Integer.valueOf(nums[i]));
						    first.add(Integer.valueOf(nums[j]));
						    first.add(firstHeight - arr[i][j]);
						    
						    for(int h = 0; h < 6; h++){
								if(!visited[h]) second.add(Integer.valueOf(nums[h]));
							}
						    break;
						} else {
							visited = new boolean[6];
						}
					}
				}
			}
		}

		String f = "", s = "";
		while(!first.isEmpty()){
		    f = " " + first.pollFirst() + f; 	
		}
		System.out.print(f.trim());
		System.out.print(" ");
		while(!second.isEmpty()){
		    s = " " + second.pollFirst() + s; 	
		}
		System.out.println(s.trim());
		sc.close();
	}
	
}
