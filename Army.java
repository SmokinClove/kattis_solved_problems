import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Army {

    void run() {
    	IntegerScanner sc = new IntegerScanner(System.in);
	    int TC = sc.nextInt();
	    int G, M;
	    while(TC -- > 0){
	    	G = sc.nextInt();
	    	M = sc.nextInt();
	    	int g = 0;
	    	while(G -- > 0){
	    		g = Math.max(g, sc.nextInt());
	    	}
	    	boolean changed = true;
	    	while(M -- > 0){
	    		if(sc.nextInt() > g){
	    			changed = false;
	    			//break;
	    		}
	    	}
	    	
	    	//if(m > g) System.out.println("MechaGodzilla");
	    	if(changed) System.out.println("Godzilla");
	    	else System.out.println("MechaGodzilla");
	    }   
    }
    
    public static void main(String[] args){
    	Army a = new Army();
    	a.run();
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