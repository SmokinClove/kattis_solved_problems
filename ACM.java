import java.util.*;
public class ACM {
    private HashMap<String, Integer> record;
    private TreeSet<String> IDs;
    private int solved;
    private int total;
    
    ACM(){
    	record = new HashMap<String, Integer>();
    	IDs = new TreeSet<String>();
    }
    
    public void process(int time, String id, String status){
    	//System.out.println("time " + time + " id = " + id + " status " + status);
    	if(record.containsKey(id)){
    		if(status.equals("right") && !IDs.contains(id)){
    			solved ++;
    			IDs.add(id);
    			total += record.get(id) + time;
    		} else if (status.equals("wrong")){
    			int curr = record.get(id);
    			record.put(id, curr + 20);
    		}
    	} else {
    		if(status.equals("right")){
    			record.put(id, 0);
    			solved ++;
    			IDs.add(id);
    			total += time;
    		} else {
    		    record.put(id, 20);
    		}
    	}
    }
    
    public int solved(){
    	return solved;
    }
    
    public int time(){
    	return total;
    }
    
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	String s = sc.nextLine();
    	ACM a = new ACM();
    	while(!s.equals("-1")){
    		//System.out.println("valid");
    		String[] command = s.split(" ");
    		a.process(Integer.valueOf(command[0]), command[1], command[2]);
    		s = sc.nextLine();
    	}
    	System.out.println(a.solved() + " " + a.time());
    }
}
