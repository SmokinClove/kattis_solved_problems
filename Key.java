import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;
public class Key {

	public static void main(String[] args){
		TreeMap<Character,IntegerPair> m=new TreeMap<Character,IntegerPair>();
		m.put('q', new IntegerPair(0,0));
		m.put('w', new IntegerPair(0,1));
		m.put('e', new IntegerPair(0,2));
		m.put('r', new IntegerPair(0,3));
		m.put('t', new IntegerPair(0,4));
		m.put('y', new IntegerPair(0,5));
		m.put('u', new IntegerPair(0,6));
		m.put('i', new IntegerPair(0,7));
		m.put('o', new IntegerPair(0,8));
		m.put('p', new IntegerPair(0,9));
		
		m.put('a', new IntegerPair(1,0));
		m.put('s', new IntegerPair(1,1));
		m.put('d', new IntegerPair(1,2));
		m.put('f', new IntegerPair(1,3));
		m.put('g', new IntegerPair(1,4));
		m.put('h', new IntegerPair(1,5));
		m.put('j', new IntegerPair(1,6));
		m.put('k', new IntegerPair(1,7));
		m.put('l', new IntegerPair(1,8));
		
		m.put('z', new IntegerPair(2,0));
		m.put('x', new IntegerPair(2,1));
		m.put('c', new IntegerPair(2,2));
		m.put('v', new IntegerPair(2,3));
		m.put('b', new IntegerPair(2,4));
		m.put('n', new IntegerPair(2,5));
		m.put('m', new IntegerPair(2,6));
		Scanner sc = new Scanner(System.in);
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	    int TC= sc.nextInt();sc.nextLine();
	   while(TC-->0){
		   TreeSet<Pair>T= new TreeSet<Pair>();
		String[] a= sc.nextLine().split(" ");
		String str= a[0]; int n= Integer.valueOf(a[1]);
		while(n-->0){
			int dist=0;
		    String str2=sc.nextLine();
		    for(int i=0;i<str.length();i++){
		    	if(str.charAt(i)!=str2.charAt(i)){
		    		dist += Math.abs(m.get(str.charAt(i)).first()-m.get(str2.charAt(i)).first())+
		    				Math.abs(m.get(str.charAt(i)).second()-m.get(str2.charAt(i)).second());
		    	}
		    }
		    T.add(new Pair(str2,dist));
		}
		while(!T.isEmpty()){
			Pair p = T.pollFirst();
			pr.println(p.first() + " " + p.second());
		}
	   }
	pr.flush();
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
		  
		  public String toString() {return ("neigbor " + _first + " weight " + _second);};
		}
	
	

	class Pair implements Comparable <Pair > {
		  String _first; int _second;

		  public Pair(String f, Integer s) {
		    _first = f;
		    _second = s;
		  }

		  public int compareTo(Pair o) {
		    if (!this.second().equals(o.second()))
		      return this.second() - o.second();
		    else
		      return this.first().compareTo(o.first());
		  }

		  String first() { return _first; }
		  Integer second() { return _second; }
		  
		  public String toString() {return ("neigbor " + _first + " weight " + _second);};
		}
	