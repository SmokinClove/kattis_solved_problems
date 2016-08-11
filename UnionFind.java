import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class UnionFind {
	int[] par;
	int N;

	void run() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String[] args = br.readLine().split(" ");
		N = Integer.valueOf(args[0]);
		par = new int[N];
		for(int i = 0; i < N; i++){
			par[i] = i;
		}
		int Q = Integer.valueOf(args[1]);
		
		while(Q -- > 0){
			String[] command = br.readLine().split(" ");
			String query = command[0];
			switch(query){
			case "=":
				merge(Integer.valueOf(command[1]), Integer.valueOf(command[2]));
				break;
			case "?":
				if(sameSet(Integer.valueOf(command[1]), Integer.valueOf(command[2]))){
					pw.println("yes");
				} else {
					pw.println("no");
				}
				break;
					
			}
		}
		br.close();
		pw.close();
	}
	
	void merge(int i, int j){
		if(par(i) < par(j)) {
			par[par(j)] = par(i);
		} else if(par(j) < par(i)) {
			par[par(i)] = par[j];
		}
	}
	
	int par(int i){
		if(par[i] == i) return i;
		
		par[i] = par(par[i]);
		return par[i];
	}
	
	boolean sameSet(int i, int j){
		return par(i) == par(j);
	}

    public static void main(String[] args) throws IOException{
		UnionFind u = new UnionFind();
		u.run();
	}
}
