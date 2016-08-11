import java.util.*;
public class Busy {
     private ArrayList<PriorityQueue<Hour>> queues;
     
     Busy(){
    	
     }
     
     void setup(){
    	 queues = new ArrayList<PriorityQueue<Hour>>(4);  
    	 for(int i = 0; i < 4; i++){
    		 queues.add(new PriorityQueue<Hour>());
    	 }
     }
     
     void insert(Hour h){
    	 queues.get(h.getType()).add(h);
     }
     
     void print(){
    	 for(int i = 0; i < 4; i++){
    		 while(!queues.get(i).isEmpty()){
    			 System.out.println(queues.get(i).poll().getContent());
    		 }
    	 }
     }
     
	 public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);
		    Busy b = new Busy();
		    int N = sc.nextInt();
		    sc.nextLine();
		    while(N > 0){
		    	b.setup();
		    	while(N -- > 0){
		    		b.insert(new Hour(sc.nextLine()));
		    	}
		    	b.print();
		    	System.out.println("");
		    	N = Integer.valueOf(sc.nextLine());
		    }
	 }
}

class Hour implements Comparable<Hour> {
	String content;
	int hour;
	int min;
	int type;//which queue to go to
	
	public int compareTo(Hour h) {
		if(this.getHour() == h.getHour()){
			return this.getMin() - h.getMin();
		} else {
			return this.getHour() - h.getHour();
		}
	}
	
	Hour(String s){
		content = s;
		int colon = s.indexOf(':');
		int space = s.indexOf(' ');
		hour = Integer.valueOf(s.substring(0, colon));
		min = Integer.valueOf(s.substring(colon + 1, space));
		String section = s.substring(space + 1, space + 2);
		if(hour == 12){
			if(section.equals("a")){
				type = 0;
			} else {
				type = 2;
			}
		} else {
			if(section.equals("a")){
				type = 1;
			} else {
				type = 3;
			}
		}
	}
	
	int getHour(){
		return hour;
	}
	
	int getMin(){
		return min;
	}

	int getType(){
		return type;
	}
	
	String getContent(){
		return content;
	}
}
