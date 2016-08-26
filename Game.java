//2048
import java.io.*;
import java.util.*;
public class Game {
	private ArrayList<IntegerPair> moves;
	private ArrayList<ArrayList<Square>> N;
	
	int left = 0, up = 1, right = 2, down = 3;
	IntegerPair _left = new IntegerPair(0, -1), _up = new IntegerPair(-1, 0), _right = new IntegerPair(0, 1), _down = new IntegerPair(1, 0);
	
	void setup(){
		moves = new ArrayList<IntegerPair>();
	    moves.add(_left);
	    moves.add(_up);
	    moves.add(_right);
	    moves.add(_down);
	}
	
	boolean isBorder(Square sq, int dir){
		return (((dir == 0) && (sq.getCol() == 0)) ||
				((dir == 2)&& sq.getCol() == 3) ||
				((dir == 1) && (sq.getRow() == 0)) ||
				((dir == 3) && sq.getRow() == 3)); 
				//if dir = left||right, the border condition depends on the col
				//if dir = up||down, the border condition depends on row
	}
	
    void bubble(int dir, Square sq, IntegerPair p){//recursively glance to the direction until cannot move any more
    	//System.out.println("Bubbling");
    	if(!isBorder(sq, dir)){
    	    int currCol = sq.getCol();
    	    int currRow = sq.getRow();
    	    int score = sq.getScore();
    	    Square next = N.get(currRow + p.first()).get(currCol + p.second());
		    if(!next.getMerge()){
			    if(next.getScore() == 0){
			        next.setScore(score);
			        sq.setScore(0);
			        bubble(dir, next, p);//recursively until can no longer move
			    } else if(next.getScore() == sq.getScore()) {
			    	if(!sq.getMerge()) next.merge(sq);//if can merge, stop here
			    } 
		    }
    	}
	}
	
	void move(int dir, IntegerPair ip){//move the whole matrix depending on user's command
		if(dir == 0 || dir == 1){
			for(int i = 0; i < 4; i++ ){
				for(int j = 0; j < 4; j++){
					bubble(dir, N.get(i).get(j), ip);
				}
			}
		} else {
			for(int i = 3; i >= 0; i--){
				for(int j = 3; j >= 0; j--){
					bubble(dir, N.get(i).get(j), ip);
				}
			}
		}
	}
	
	void print(){
		for(int i = 0; i < 4; i++){
	    	for(int j = 0; j < 3; j++){
	    		System.out.print(N.get(i).get(j).getScore() + " ");
	    	}
	    	System.out.println(N.get(i).get(3).getScore());
	    }
	}
	
	void run() throws Exception {
		    // do not alter this method to standardize the I/O speed (this is already very fast)
		    IntegerScanner sc = new IntegerScanner(System.in);
		    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		    N = new ArrayList<ArrayList<Square>>();
		    for(int i = 0; i < 4; i++){
		    	N.add(new ArrayList<Square>());
		    	for(int j = 0; j < 4; j++){
		    		N.get(i).add(new Square(i,j,sc.nextInt()));
		    	}
		    }
		    setup();
		    int dir = sc.nextInt();//user's move
		    
		    move(dir, moves.get(dir));
		    print();
		    pw.close();
		    
	}

		  
	public static void main(String[] args) throws Exception {
		 Game game= new Game();
		 game.run(); 
	}
}

class IntegerPair {
	  Integer _first, _second;

	  public IntegerPair(Integer f, Integer s) {
	    _first = f;
	    _second = s;
	  }

	  Integer first() { return _first; }
	  Integer second() { return _second; }
	}

class Square{
	private int _row;
	private int _col;
	private int _score;
	private boolean _merge;
	
	public Square(int r, int c, int s){
		_row = r;
		_col = c;
		_score = s;
		_merge = false;
	}
	
	public boolean getMerge(){
		return _merge;
	}
	
	public int getScore(){
		return _score;
	}

	public int getRow(){
		return _row;
	}
	
	public int getCol(){
		return _col;
	}
	
	public void setScore(int s){
		_score = s;
	}
	
	public void setMerge(boolean m){
		_merge = m;
	}
	
	public void merge(Square s){//this is the resulting square after merging
		this._score += s.getScore();
		s.setScore(0);
		setMerge(true);
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
