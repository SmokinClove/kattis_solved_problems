import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.TreeSet;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Gold {
int r, c, max;
int w, h;
char[][] A;
int[][] v;
TreeSet<IntegerPair> T;
void run() throws NumberFormatException, IOException{
	  QuickScanner sc = new QuickScanner(System.in);
	  PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	  w = sc.nextInt();
	  h = sc.nextInt();
	  sc.nextLine();
	  A = new char[h][w];
	  v = new int[h][w];
	  T = new TreeSet<IntegerPair>();
      for(int i = 0; i < h; i++){
    	  StringBuilder sb = new StringBuilder(sc.nextLine());
    //	  System.out.println(sb);
    	  for(int j = 0; j < w; j++){
    //		  System.out.println("j = " + j + " " + sb.charAt(j));
    		  A[i][j] = sb.charAt(j);
    		  if(A[i][j] == 'P'){
    			  r = i; c = j;
    			  //System.out.println("r = " + r + "c = " + c);
    		  }
    	  }
      }
      
      BFS();
      pw.println(max);
      pw.close();
}

public static void main(String[] args) throws NumberFormatException, IOException{
	Gold g = new Gold();
	g.run();
}

boolean visited(int i, int j){
	return (v[i][j] == 1);
}

void BFS(){
	 v[r][c] = 1;//mark as visited
	 //System.out.println("r = " + r + "c = " + c);
	 int cur = 0;
	 T.add(new IntegerPair(r,c));
	 while(!T.isEmpty()){
		 IntegerPair p= T.pollFirst();
	      int i = p.first(); int j = p.second();
	   //   System.out.println("i = " + i + "j = " + j);
	      if(A[i][j] == 'G') {
	    	  cur++;
	    	  max = Math.max(max, cur); 
	    	  A[i][j] = '.';//gold!!
	      }
	      boolean go = true;
		  for(int k = -1; k <= 1; k++){
			  for(int g = -1; g <= 1; g++){
				  if(!(k != 0 && g != 0)){
					  int nr = i + k;//neighbors
					  int nc = j + g;
					  
					  
					 // System.out.println("nr =" + nr + " nc = " + nc + visited(nr, nc) + A[nr][nc] + "h = " + h + " w = " + w);
					  if((0 <= nr && nr <h) && (0 <=nc && nc <w) && !visited(nr, nc) && A[nr][nc] != '#'){//in range
						 // System.out.println("nr =" + nr + " nc = " + nc + A[nr][nc]);
						  /*
						  if(A[nr][nc] != 'T') { 
						      v[nr][nc] = 1;//mark as visited
						      T.add(new IntegerPair(nr,nc));
						  }	 else {
							  break;
						  }
						  */
						  go &= (A[nr][nc] != 'T');
					  }
					  
				  }
			  }
		 }
		  
		  if(go){
			  for(int k = -1; k <= 1; k++){
				  for(int g = -1; g <= 1; g++){
					  if(!(k != 0 && g != 0)){
						  int nr = i + k;//neighbors
						  int nc = j + g;
						  
						  
						 // System.out.println("nr =" + nr + " nc = " + nc + visited(nr, nc) + A[nr][nc] + "h = " + h + " w = " + w);
						  if((0 <= nr && nr <h) && (0 <=nc && nc <w) && !visited(nr, nc) && A[nr][nc] != '#'){//in range
							 // System.out.println("nr =" + nr + " nc = " + nc + A[nr][nc]);
							  
							  if(A[nr][nc] != 'T') { 
							      v[nr][nc] = 1;//mark as visited
							      T.add(new IntegerPair(nr,nc));
							  }	
							  
						 //go &= (A[nr][nc] != 'T');
						  }
						  
					  }
				  }
			 }
		  }
		// v[i][j] = 0;
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

class IntegerPair implements Comparable < IntegerPair > {
	  Integer _first, _second;

	  public IntegerPair(Integer f, Integer s) {
	    _first = f;
	    _second = s;
	  }

	  public int compareTo(IntegerPair o) {
	    if (!this.first().equals(o.first()))
	      return this.first() - o.first();
	    else
	      return this.second() - o.second();
	  }

	  Integer first() { return _first; }
	  Integer second() { return _second; }
	}


