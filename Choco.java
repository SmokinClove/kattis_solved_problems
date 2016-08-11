import java.util.*;
public class Choco {
     private TreeSet<Integer> POWER_2;//1, 2, 4, 8, 16, 32, 64
     private int breaks;
     
     Choco(){
    	 int add = 1;
    	 breaks = 0;
    	 POWER_2 = new TreeSet<Integer>();
    	 while(add <= 2000000){
    		 POWER_2.add(add);
    		 add *= 2;
    	 }
     }
     
     public int findSmallest(int k){
    	 return(POWER_2.tailSet(k).first());
     }
     
     public void print(int k){
    	 System.out.println(findSmallest(k) + " " +  findBreaks(k));
     }
     
     private int findBreaks(int k, int size){//k == num needed left, size = the size to break up
    	 int ans;
    	 if(size == k){
    		 return breaks;
    	 } else {
             if(k > size/2){
            	 breaks++;
    		     ans = findBreaks(k - size/2, size/2);
             } else {
            	 breaks++;
    		     ans = findBreaks(k, size/2);
             }
    	 }
    	 return ans;
     }
     
     public int findBreaks(int k){
    	 return findBreaks(k, findSmallest(k));
     }
     
	 public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);
		    int K = Integer.valueOf(sc.nextLine());
		    Choco c = new Choco();
		    c.print(K);
		    sc.close();
	 }
}
