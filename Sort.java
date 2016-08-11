import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;
public class Sort {
	public static void main(String[] args){
		 PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
			sc.nextLine();
			while(n>0){
				
		    TreeSet<String> T= new TreeSet<String>(new Comparator<String>(){

			@Override
			public int compare(String a, String b) {
				if(a.charAt(0)==b.charAt(0)&&a.charAt(1)==b.charAt(1)){
					return 1;
				}else{
				    if(a.charAt(0)==b.charAt(0)){
				    	if(Character.toUpperCase(a.charAt(1))==Character.toUpperCase(b.charAt(1))){
				           if(a.charAt(1)>b.charAt(1)){//a is the lower case version
				    		return -1;
				    	   }else{
				    		   return 1;
				    	   }	
				    	}else{
				    		return a.charAt(1)-b.charAt(1);
				    	}
				    }else{
				    	if(Character.toUpperCase(a.charAt(0))==Character.toUpperCase(b.charAt(0))){
					           if(a.charAt(0)>b.charAt(0)){//a is the lower case version
					    		return -1;
					    	   }else{
					    		   return 1;
					    	   }	
					    	}else{
					    		return a.charAt(0)-b.charAt(0);
					    	}
				    }
				}
			}
		});
		while(n-->0){
		T.add(sc.nextLine());
		}
		while(!T.isEmpty()){
			pr.println(T.pollFirst());
		}
		
		pr.println("");n=sc.nextInt();sc.nextLine();

			}
			pr.flush();
	}
	
}
