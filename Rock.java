import java.text.DecimalFormat;
import java.io.*;

public class Rock {
    private int[] P;
    private int[] L;//losses
    private int n;
    private int k;
    private int games;
    void run() throws IOException{
    	BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    	String[] in = sc.readLine().split(" ");
    	
    	while(in.length > 1){
    		n = Integer.valueOf(in[0]);
    		P = new int[n];
    		L = new int[n];
    		k = Integer.valueOf(in[1]);
    		games = k*n*(n-1)/2;

    		for(int i = 0; i < games; i++){
            	String[] a = sc.readLine().split(" ");
            	int p1 = Integer.valueOf(a[0]);
            	int p2 = Integer.valueOf(a[2]);
            	String f = a[1];//p1
            	String s = a[3];//p2
            	if(f.equals("rock") && s.equals("paper") || f.equals("paper") && s.equals("scissors") || 
            			f.equals("scissors") && s.equals("rock")){
            		P[p2 -1]++;
            		L[p1 -1]++;
            	} else if(s.equals("rock") && f.equals("paper") || s.equals("paper") && f.equals("scissors") || 
            			s.equals("scissors") && f.equals("rock")){
            		P[p1 -1]++;
            		L[p2 -1]++;
            	}
            
            }
    		
    		DecimalFormat df = new DecimalFormat("0.000");
    		for(int i = 0; i < n; i++){
    			if(P[i] + L[i] > 0){
    				System.out.println(df.format((double)P[i]/(P[i] + L[i])));
    			} else {
    				System.out.println("-");
    			}
            }
    		
    		System.out.println("");
    		in = sc.readLine().split(" ");
    	}
    }
    
    public static void main(String[] args) throws IOException{
    	Rock r = new Rock();
    	r.run();
    }
}