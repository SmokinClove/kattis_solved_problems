import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;
/**
 * Idea: if no place to sit, count num of handshakes of the existing people=> How? each person has a TreeSet???
 * Else, iterate thru and count num of handshakes that can happen at the dots
 * and take the max
 */
public class Misa {
	int R, S;
	String[][] A;
	int max = 0;
	int shake = 0;
	private TreeMap<IntegerPair, TreeSet<IntegerPair>> T;
	void run() throws NumberFormatException, IOException{
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		  String[] a = br.readLine().split(" ");
		  R = Integer.valueOf(a[0]);
		  S = Integer.valueOf(a[1]);
		  T = new TreeMap<IntegerPair, TreeSet<IntegerPair>>();
		  A = new String[R][S];
		  for(int i = 0; i < R; i++){
			  String read =  br.readLine(); 
			  for(int j = 0; j < S; j++){
				  A[i][j] = "" + read.charAt(j);
				  T.put(new IntegerPair(i, j), new TreeSet<IntegerPair>());
			  }
		  }
		  for(int i = 0; i < R; i++){
			  for(int j = 0; j < S; j++){
				  if(A[i][j].equals("o")){//beware if the count of any dot equals o!!
					  //System.out.println("deteced o " + i + " " + j);
					  for(int k = -1; k <= 1; k++){
						  for(int h = -1; h <= 1; h++){
							  if(!(k== 0 && h==0)){
								  int r = i + k;//neighbors
								  int c = j + h;
								  if((0 <= r && r <R) && (0 <=c && c <S)){
									  if(A[r][c].equals("o")){
										//  System.out.println("neighbor " + r + " " + c);
										  if(!T.get(new IntegerPair(i,j)).contains(new IntegerPair(r, c))){
										  T.get(new IntegerPair(i,j)).add(new IntegerPair(r, c));
										  T.get(new IntegerPair(r,c)).add(new IntegerPair(i, j));
										  shake++;
										  }
									  } else {//dots instead
										  int C = 0;
									//	  System.out.println("dot at " + A[r][c] + " " + r + " " + c);
										  if(A[r][c].equals(".")) {
											   A[r][c] = "" + 1;  
											   C = 1;
										  } else {
										       C = Integer.valueOf(A[r][c]);
										  }
										  max = Math.max(max, C);
									      A[r][c] = "" + (C+1);
									  }
								  }
							  }
						  }
					  }
				  }
			  }
		  }
		 
		  pw.println(max + shake);
		  pw.flush();
	}
	
	 public static void main(String[] args) throws NumberFormatException, IOException{	 
	     Misa m = new Misa();
	     m.run();
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
