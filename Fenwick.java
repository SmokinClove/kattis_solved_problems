import java.io.*;
import java.math.BigInteger;
public class Fenwick {
    private int N, Q;
    //private BigInteger[] A;
    private long[] A;

	void run() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] args = br.readLine().split(" ");
		N = Integer.valueOf(args[0]);
		//A  = new BigInteger[N + 1];
		A  = new long[N + 1];
		/*
		for(int i = 0; i <= N; i++){
			A[i] = new BigInteger("0");
		}
		*/
		FWT f = new FWT(A);
		Q = Integer.valueOf(args[1]);
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		while(Q -- > 0){
			String[] s = br.readLine().split(" ");
			String command = s[0];
			switch(command){
			case "+":
				f.update(Integer.valueOf(s[1]) + 1, (long)(Integer.valueOf(s[2])));
				break;
			case "?":
				pw.println(f.sum(Integer.valueOf(s[1])));
				break;
			}
		}
		
		br.close();
		pw.close();
	}
    
	public static void main(String[] args) throws IOException{
		Fenwick f = new Fenwick();
		f.run();
	}
}

class FWT{
	long[] arr;
	
	FWT(long[] A){
	    arr = A;
	}
	
	void print(){
		for(int i = 0; i < arr.length; i++){
			System.out.println("index " + i + " = " + arr[i]);
		}
	}
	int LSB(int i){
		return (i &(-i));
	}
	//the par(i) stores sum of par(i) to i 
	int par(int i){
	    return i - (LSB(i));	
	}
	
	int next(int i){
	    return i + (LSB(i));	
	}

	long sum(int i){
		//BigInteger ans = new BigInteger("0");
		long ans = 0;
	    int j = i;
	    while(j > 0){//keep adding with parents  	
	    	//if(arr[j] == null) arr[i] = new BigInteger("0");
	    	ans += arr[j];
	    	j = par(j);
	    }
	    return ans;
	}
	
	void update(int i, long j){//update at i by j
		 int k = i;
		 while(k < arr.length){//keep adding with next
			 //if(arr[k] == null) arr[k] = new BigInteger("0");
			 arr[k] = arr[k] + j;
		     k = next(k);
		 }
	}
}