import java.util.*;

public class Orders {
public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	int N=sc.nextInt();//num of cusstomers
	sc.nextLine();
	while(N>0){
		TreeMap<String,TreeSet<String>> M=new TreeMap<String,TreeSet<String>>();
		TreeSet<String> dishes=new TreeSet<String>();
	    for(int i=0;i<N;i++){
		    String[] orders= sc.nextLine().split(" ");
		    String name=orders[0];
		    int size=orders.length;
		    for(int j=1;j<size;j++){
			   if(!M.containsKey(orders[j])){
				    TreeSet<String> set= new TreeSet<String>();
				    set.add(name);
				    M.put(orders[j],set); 
				    dishes.add(orders[j]);
			    }else{
				    if(!M.get(orders[j]).contains(name)){
					    M.get(orders[j]).add(name);
				     }
			    }
		    }
	    }
	    while(!dishes.isEmpty()){
		String dishName=dishes.pollFirst();
		System.out.print(dishName);
		TreeSet<String> Set=M.get(dishName);
		while(!Set.isEmpty()){
			System.out.print(" " + Set.pollFirst());
		}
		System.out.println("");
	}
	N=sc.nextInt();
	sc.nextLine();
	}
}
}
