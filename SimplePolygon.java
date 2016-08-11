import java.util.*;
import java.io.*;
public class SimplePolygon {
	 final double EPS = 1e-9;
	  // In Java, we can use Math.PI instead of using Math.acos(-1.0)
     TreeMap<point, Integer>T;
     TreeSet<point> upper,lower, A;
	  double DEG_to_RAD(double d) { return d * Math.PI / 180.0; }
	  double RAD_to_DEG(double r) { return r * 180.0 / Math.PI; }
	  vec toVec(point a, point b) {               // convert 2 points to vector
	        return new vec(b.x - a.x, b.y - a.y); }

	      double dist(point p1, point p2) {                   // Euclidean distance
	        return Math.hypot(p1.x - p2.x, p1.y - p2.y); }         // return double

	      double dot(vec a, vec b) { return (a.x * b.x + a.y * b.y); }

	      double norm_sq(vec v) { return v.x * v.x + v.y * v.y; }

	      double angle(point a, point o, point b) {     // returns angle aob in rad
	        vec oa = toVec(o, a), ob = toVec(o, b);
	        return Math.acos(dot(oa, ob) / Math.sqrt(norm_sq(oa) * norm_sq(ob))); }

	      double cross(vec a, vec b) { return a.x * b.y - a.y * b.x; }

	      // note: to accept collinear points, we have to change the `> 0'
	      // returns true if point r is on the left side of line pq
	      boolean ccw(point p, point q, point r) {
	        return cross(toVec(p, q), toVec(p, r)) > 0; }
	      boolean collinear(point p, point q, point r) {
	    	    return Math.abs(cross(toVec(p, q), toVec(p, r))) < EPS; }
	      void run() throws Exception {
	    	    // do not alter this method
	    	    IntegerScanner sc = new IntegerScanner(System.in);
	    	    PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	    	    int TC = sc.nextInt();
	    	    while(TC-->0){
	    	    	 T= new TreeMap<point, Integer>();
	    	    	 upper= new TreeSet<point>();
	    	    	 lower= new TreeSet<point>();
	    	    	 A=new TreeSet<point>();
	    	    	 ArrayList<point> list = new ArrayList<point>();
	    	    	 int n= sc.nextInt();
	    	    	 for(int i=0;i<n;i++){
	    	    		 int x=sc.nextInt();int y= sc.nextInt();
	    	    		 point p=new point(x,y);
	    	    		 A.add(p);
	    	    		 T.put(p,i);
	    	    	 }
	    	    	 
	    	    	 point l = A.pollFirst(); point r= A.pollLast();
	    	    	 //pr.println("left = " + T.get(l) + " right = " + T.get(r));
	    	    	 while(!A.isEmpty()){
	                      point q= A.pollFirst();
	                     // pr.println("ccw " + T.get(q) + " "+ ccw(l,r,q));
	                      if(collinear(l, r, q)){
	                    	  list.add(q);
	                      }else{
	    	    			 if(ccw(l,r,q))upper.add(q);
	    	    			 else lower.add(q);
	                      }
	    	    		 }
	    	    	 if(upper.isEmpty()){
	    	    		 for(int i=0;i<list.size();i++){
	    	    			 upper.add(list.get(i));
	    	    		 }
	    	    	 }else {
	    	    		 for(int i=0;i<list.size();i++){
	    	    			 lower.add(list.get(i));
	    	    		 }
	    	    	 }
	    	    	 pr.print(T.get(l));
	    	    	 while(!upper.isEmpty()){
	    	    		 pr.print(" " + T.get(upper.pollFirst()));
	    	    	 }
	    	    	 pr.print(" " + T.get(r));
	    	    	 while(!lower.isEmpty()){
	    	    		 pr.print(" " + T.get(lower.pollLast()));
	    	    	 }
	    	    	 pr.println("");
	    	    	 pr.flush();
	    	    }
	      }
	      public static void main(String[] args) throws Exception{
	    	  SimplePolygon s= new SimplePolygon();
	    	  s.run();
	      }
}
class point implements Comparable<point>{
	final double EPS = 1e-9;
	  // In Java, we can use Math.PI instead of using Math.acos(-1.0)

	  double DEG_to_RAD(double d) { return d * Math.PI / 180.0; }
	  double RAD_to_DEG(double r) { return r * 180.0 / Math.PI; }
    double x, y;                   // only used if more precision is needed
    point() { x = y = 0.0; }                         // default constructor
    point(double _x, double _y) { x = _x; y = _y; }         // user-defined
    // use EPS (1e-9) when testing equality of two floating points
    /*
    public int compareTo(point other) {      // override less than operator
      if (x != other.x)                // useful for sorting
        return (int) (x - other.x);       // first: by x-coordinate
      else if (Math.abs(y) != Math.abs(other.y))
        return (int) (Math.abs(y) - Math.abs(other.y))  ;   // second: by y-coordinate
      else
        return 0; } };                                    // they are equal
        */
    public int compareTo(point other) {      // override less than operator
        if (Math.abs(x - other.x) > EPS)                // useful for sorting
          return (int)Math.ceil(x - other.x);       // first: by x-coordinate
        else if (Math.abs(y - other.y) > EPS)
          return (int)Math.ceil(y - other.y);      // second: by y-coordinate
        else
          return 0; } };                                    // they are equal
class vec { double x, y;     // name: `vec' is different from Java Vector
        vec(double _x, double _y) { x = _x; y = _y; } };
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

      
