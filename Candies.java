import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Candies {

	
	String Query(BigInteger N, BigInteger T){
		String ans = "";
		if(T.mod(N).equals(new BigInteger("0"))){
			ans = "YES";
		} else {
			ans = "NO";
		}
		return ans;
	}
	  void run() throws Exception {
		    // do not alter this method to standardize the I/O speed (this is already very fast)
		    //IntegerScanner sc = new IntegerScanner(System.in);
		    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		    Scanner sc = new Scanner(System.in);
		    int TC = sc.nextInt(); // there will be several test cases
		    
		    while (TC-- > 0) {
		    	BigInteger N = sc.nextBigInteger();
		    	//System.out.println("N = " + N);
		    	BigInteger T = new BigInteger("0");
		    	//System.out.println("T = " + T);
		    	BigInteger i = new BigInteger("0");
		    	//System.out.println("i = " + i);
		    	while (i.compareTo(N) < 0) {
		            T = T.add(sc.nextBigInteger());
		          //  System.out.println("next T = " + T);
		            i = i.add(new BigInteger("1"));
		          //  System.out.println("next i = " + i);
		    	}
		    	pw.println(Query(N, T));
		    }

		    pw.close();
		  }

		  public static void main(String[] args) throws Exception {
		    // do not alter this method
		    Candies c = new Candies();
		    c.run();
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