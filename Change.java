import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.TreeSet;

public class Change {
    private int N, P;
    int[] A;
    int[][] memo; 
    int[] count;
    final int INF = 1000000000;
    int ans = INF;
    TreeSet<IntegerPair> T;
	void run() throws NumberFormatException, IOException{
		    QuickScanner sc = new QuickScanner(System.in);
	        int TC = sc.nextInt();
		    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		    for(int id = 1; id <= TC; id++){
			    P = sc.nextInt();
			    N = sc.nextInt();
			    A = new int[N];
			    memo = new int[10010+P][N+ 10];
				count = new int[10010+P];
		    	for(int i = 0; i < 10010+P; i++){
			    	count[i] = INF;
		    	}
		    	T = new TreeSet<IntegerPair>();
		    	
			    for(int i = 0; i < N; i++){
			    	T.add(new IntegerPair(sc.nextInt(), i));
				    //A[i] = sc.nextInt();
			    }
                int indx = 0;
			    while(!T.isEmpty()){
			    	A[indx] = T.pollLast().first();
			    	indx++;
			    }
			    ans = solve(0, 0, 0);
			    pw.println(ans + " " + count[ans]);
		    }

		    pw.close();
	}
	
	public int solve(int i, int v, int c){
		if(memo[v][i] != 0) {
			return memo[v][i];
		}
		if(v >= P) {
			count[v] = Math.min(count[v], c);
			return v;
		}
		if(i == N) {
			return INF;
		}
		memo[v][i] = INF;
		memo[v][i]= Math.min(memo[v][i], 
					 Math.min(solve(i +1, v + A[i], c+ 1), solve(i + 1, v, c))); 	
		
		return memo[v][i];
	}
	
	 public static void main(String[] args) throws NumberFormatException, IOException{
	      Change c = new Change();
	      c.run();
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
		if(this._f == p.first()){
			return this._s - p.sec();
		}
		else {
		    return this._f - p.first();
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
