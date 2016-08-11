import java.io.*;
import java.util.*;
public class Bus {
void run(){
	 TreeSet<Integer> T=new TreeSet<Integer>();
	 IntegerScanner sc = new IntegerScanner(System.in);
	 PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
     int size= sc.nextInt();
     int N=size;
     while(size-->0){
    	 T.add(sc.nextInt());
     }
     int[] A=new int[N];
     int indx=0;
     while(!T.isEmpty()){
    	A[indx++]=T.pollFirst();
     }
     int temp=0,start=0;
    	 while(start<N){
    		 temp=start;
    	     while(start<N-1&&A[start+1]==A[start]+1){
    	    	 start++;
    	     }
    	     if(temp==start){
    	    	 pr.print(A[temp]+" ");
    	    	 start++;
    	     }else {
    	    	 if(start > temp+1){
    	    	     pr.print(A[temp]+"-"+A[start]+" ");
    	         }else{
    	        	 pr.print(A[temp]+" "+A[start]+" ");
    	         }
    	    	 start++;
    	     }
     
     }

         pr.println("");
         pr.flush();
}
public static void main(String[] args){
	Bus b= new Bus();
	b.run();
}
}
class IntegerScanner { // coded by Ian Leow, using any other I/O method is not recommended
	  BufferedInputStream bis;
	  IntegerScanner(InputStream is) {
	    bis = new BufferedInputStream(is, 1000000);
	  }
	  
	  public int nextInt() {
	    int result = 0;
	    try {
	      int cur = bis.read();
	      if (cur == -1)
	        return -1;

	      while ((cur < 48 || cur > 57) && cur != 45) {
	        cur = bis.read();
	      }

	      boolean negate = false;
	      if (cur == 45) {
	        negate = true;
	        cur = bis.read();
	      }

	      while (cur >= 48 && cur <= 57) {
	        result = result * 10 + (cur - 48);
	        cur = bis.read();
	      }

	      if (negate) {
	        return -result;
	      }
	      return result;
	    }
	    catch (IOException ioe) {
	      return -1;
	    }
	  }
	}
