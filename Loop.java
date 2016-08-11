import java.util.*;
public class Loop {
    private PriorityQueue<Integer> red;
    private PriorityQueue<Integer> blue;
    
    void setup(){
    	red = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
    		
    	});
    	blue = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
    		
    	});
    }
   
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int TC = Integer.valueOf(sc.nextLine());
	    Loop l = new Loop();
	    int _case = 0;
	    while(TC -- > 0){
	    	System.out.print("Case #" + ++_case + ": ");
	    	l.setup();
	    	int S = Integer.valueOf(sc.nextLine());
	    	while(S -- > 0){
	    		l.insert(sc.next());
	    	}
	    	l.solve();
	    	sc.nextLine();
	    }
	}
	
	void insert(String segment){
		int len = segment.length();
		if(segment.substring(len - 1).equals("R")){
			red.add(Integer.valueOf(segment.substring(0, len - 1)));
		} else {
			blue.add(Integer.valueOf(segment.substring(0, len - 1)));
		}
		
	}
	
	void solve(){//always get red first
		int ans = 0;
		int count = 0;
		while(!red.isEmpty() && !blue.isEmpty()){
			ans += red.poll() + blue.poll();
			count += 2;
		}
		System.out.println(ans - count);
	}
}
