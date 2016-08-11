import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class CatalanSquare {
	private final static BigInteger ZERO = BigInteger.ZERO;
    private final static BigInteger ONE  = BigInteger.ONE;
    private final static BigInteger TWO  = new BigInteger("2");
	 public static BigInteger cat(int N) {
		 if(N<=1)return ONE;
		 BigInteger bottom = ONE;
		 BigInteger top = ONE;
		 for(int i=2;i<=N;i++)
			 bottom=bottom.multiply(new BigInteger(""+i));
		 for(int k=2;k<=N;k++)
			 top = top.multiply(new BigInteger(""+(N+k)));
		 
		 return top.divide(bottom);
	 }
	public static void main(String[] args) {
		IntegerScanner sc = new IntegerScanner(System.in);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        pw.println(cat(sc.nextInt()+1).toString());
        pw.flush();
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