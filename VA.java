import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TreeSet;

public class VA {
	ArrayList<ArrayList<IntegerPair>> T;
	ArrayList<ArrayList<Integer>> D;
	int[] P;
	int V, E;
	int s, t;
    TreeSet<IntegerPair> S;
    int[] dist;
    final int INF = 1000000000;
	void Dijkstra(){
		dist[s] = 0;
		S.add(new IntegerPair(s, 0));
		while(!S.isEmpty()){
			IntegerPair p = S.pollFirst();
			int _v = p.first(), _w = p.sec();
			if(_w <= dist[_v]){
			    for(int i = 0; i < T.get(_v).size(); i++){
				    int _v2 = T.get(_v).get(i).first(), _w2 = T.get(_v).get(i).sec();
				    if(dist[_v] + _w2 < dist[_v2]){
					    dist[_v2] = dist[_v] + _w2; //relax
					    D.get(_v2).clear();
					    D.get(_v2).add(_v);
					    S.add(new IntegerPair(_v2, dist[_v] + _w2));
				    } else if (dist[_v] + _w2 == dist[_v2]){
					    if(!D.get(_v2).contains(_v))D.get(_v2).add(_v);
					    S.add(new IntegerPair(_v2, dist[_v] + _w2));
				    }
			    }
			}
		}
	}
	
	int findPar(int i){
		if(i == s) return 1;
		if(P[i] > 0){//avoid double cal
			return P[i];
		} else {
			int ans = 0;
			for(int j = 0; j < D.get(i).size(); j++){
				int cur = D.get(i).get(j);
				ans += findPar(cur);
			}
			P[i] = ans;
		}
		return P[i];
	}
	
	void run() throws NumberFormatException, IOException{
	    QuickScanner sc = new QuickScanner(System.in);
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	    V = sc.nextInt();
	    E = sc.nextInt();
	    T = new ArrayList<ArrayList<IntegerPair>>();
	    D = new ArrayList<ArrayList<Integer>>();
	    //D = new int[V];
	    S = new TreeSet<IntegerPair>();
	    dist = new int[V];
	    P = new int[V];
	    for(int i = 0; i < V; i++){
	    	T.add(new ArrayList<IntegerPair>());
	    	D.add(new ArrayList<Integer>());
	    	//D.get(i).add(e)
	    	//D[i] = 1;
	    	dist[i] = INF;
	    }
	    
	    for(int i = 0; i < E; i++){
	    	T.get(sc.nextInt()).add(new IntegerPair(sc.nextInt(), sc.nextInt()));
	    }
	    s = sc.nextInt();
	    t = sc.nextInt();
	    D.get(s).add(s);
	    Dijkstra(); 
	 //   System.out.println("s = " + s + " t = " + t + " " + D.get(t).size());
	    
	    pw.println(findPar(t));
	    pw.close();
	}
    
	public static void main(String[] args) throws NumberFormatException, IOException{
		VA v = new VA();
		v.run();
	}
}
class IntegerPair implements Comparable<IntegerPair>{
	int _f, _s;
	IntegerPair(int f, int s){
		_f = f;
		_s = s;
	}
	
	int first(){
		return _f;
	}
	
	int sec(){
		return _s;
	}

	public int compareTo(IntegerPair p) {
		if(this._s == p.sec()){
			return this._f - p.first();
		}
		else {
		    return this._s - p.sec();
		}
	}

}
class QuickScanner {
	private BufferedInputStream bis;
	private int cur = -2;
	public QuickScanner(InputStream is) {
		bis = new BufferedInputStream(is, 1000000);
	}

	public String next() {
		try {
			return exNext();
		} catch(IOException e) {
			return null;
		}
	}

	public StringBuilder nextSB() {
		try {
			return exNextSB();
		} catch(IOException e) {
			return null;
		}
	}

	public String nextLine() {
		try {
			return exNextLine();
		} catch(IOException e) {
			return null;
		}
	}

	public StringBuilder nextLineSB() {
		try {
			return exNextLineSB();
		} catch(IOException e) {
			return null;
		}
	}

	public int nextInt() {
		try {
			return exNextInt();
		} catch(IOException e) {
			return -1;
		}
	}

	public long nextLong() {
		try {
			return exNextLong();
		} catch(IOException e) {
			return -1L;
		}
	}

	public double nextDouble() {
		try {
			return exNextDouble();
		} catch(IOException e) {
			return -1.0;
		}
	}

	public StringBuilder exNextSB() throws EOFException, IOException {
		while (cur <= 32) {
			cur = bis.read();
			if (cur == -1) throw new EOFException();
		}

		StringBuilder sb = new StringBuilder();

		while (cur > 32) {
			sb.append((char)cur);
			cur = bis.read();
		}

		return sb;
	}

	public String exNext() throws EOFException, IOException {
		return exNextSB().toString();
	}

	public String exNextLine() throws EOFException, IOException {
		return exNextLineSB().toString();
	}

	public StringBuilder exNextLineSB() throws EOFException, IOException {
		if(cur == -2)
			cur = bis.read();

		if (cur == -1) throw new EOFException();

		StringBuilder sb = new StringBuilder(100);

		while (cur != 13 && cur != 10 && cur != -1) {
			sb.append((char)cur);
			cur = bis.read();
		}

		if(cur == 13) {
			// handle \r\n's
			cur = bis.read();
			if(cur == 10) {
				cur = -2;
			}
		}
		else if(cur == 10) {
			cur = -2;
		}

		return sb;
	}

	public int exNextInt() throws EOFException, IOException {
		int result = 0;

		while ((cur < 48 || cur > 57) && cur != 45) {
			cur = bis.read();
			if (cur == -1) throw new EOFException();
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

	public long exNextLong() throws EOFException, IOException {
		long result = 0;

		while ((cur < 48 || cur > 57) && cur != 45) {
			cur = bis.read();
			if (cur == -1) throw new EOFException();
		}

		boolean negate = false;
		if (cur == 45) {
			negate = true;
			cur = bis.read();
		}

		while (cur >= 48 && cur <= 57) {
			result = result * 10L + (cur - 48L); //cur auto-upgrade to long from int
			cur = bis.read();
		}

		if (negate) {
			return -result;
		}
		return result;
	}

	public double exNextDouble() throws EOFException, IOException {
		String str = exNext();

		return Double.parseDouble(str);
	}
}

