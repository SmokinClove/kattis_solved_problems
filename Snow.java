//Accepted on Kattis 20/1/16 12:21 AM!! *crying happy tears again*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.TreeMap;

public class Snow {
    private int N, len, curr;
	private TreeMap<Integer, Integer> H;
	void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int TC =  Integer.valueOf(br.readLine());
		while( TC -- > 0){
			N =  Integer.valueOf(br.readLine());
			len = 0;
			curr = 0;
			H = new TreeMap<Integer, Integer>();
			for(int i = 1; i <= N; i++ ){
				process(Integer.valueOf(br.readLine()), i);
			}
			pw.println(len);
		}
		br.close();
		pw.close();
	}
	
	void process(int n, int i){
		if(!H.containsKey(n)){
			H.put(n,  i);
			curr++;
			len  = Math.max(len,  curr);
		} else {//if the number appeared before			
			len  = Math.max(len,  curr);
			curr = Math.min(curr + 1, i - (H.get(n)));
			H.put(n, i);
		}		
	}
	public static void main(String[] args) throws NumberFormatException, IOException{
		Snow s = new Snow();
		s.run();
	}
}
