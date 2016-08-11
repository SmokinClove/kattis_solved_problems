//problem: precendence :S
import java.util.*;
public class Four {
     private HashMap<Integer, String> map;
     int _add = 0, _sub = 1,_mul = 2,_div = 3;
     //int[][][] memo;//3d array to store result of all possibilities
     //int mem
     final String[] OPS = {"+", "-", "*", "/"};
     private Stack<String> post;
     
     int op(int operator, int operand1, int operand2){
    	 int ans = 0;
    	 switch (operator){
    	 case 0: ans = operand1 + operand2;
    	 break;
    	 case 1: ans = operand1 - operand2;
    	 break;	 
    	 case 2: ans = operand1 * operand2;
    	 break;
    	 case 3: ans = operand1/operand2;
    	 break;
    	 }
    	 return ans;
     }
     
     String write(int op){
    	 return "4 " + OPS[op] + " ";
     }
     
     void setup(){
    	// memo = new int[4][4][4];
    	 map = new HashMap<Integer, String>();//is HashMap fast enough?
    	 post = new Stack<String>();
    	 //possible values = from 0 to 64 ( 4 * 4 * 4 is max)
    	 for(int i = 0; i < 4; i++){
    		// int first = op(i, 4, 4);
    		 String _first = write(i);
    		 for(int j = 0; j < 4; j++){
    			// int sec = op(j, first, 4);
    			 String _sec = _first + write(j);
    			 for(int k = 0; k < 4; k++){
    				 String _third = _sec + write(k);
    				 //int third = op(k, sec, 4);
    				 //memo[i][j][k] = third;
    	//			 System.out.println("infix= " + _third + 4);
    				 map.put(cal(_third + 4), _third + "4 = ");
    			//	 System.out.println(" values = " + _third + " 4 = " + third);
    			 }
    		 }
    	 }
     }
     
     int cal(String exp){//calculate based on an expression. before that, convert from infix to postfix first 
    	 post = new Stack<String>();
    	 exp = convert(exp);// now exp will have no space in between
    //	 System.out.println(exp);
    	 int ans = 0;
    	 for(int i = 0; i < exp.length(); i++){
    		 char arg = exp.charAt(i);
    		 if((int)arg <= 47){//if this is an operator
    	//		 System.out.println("operator " + arg+ " at " + i);
    			 int operand1 = Integer.valueOf(post.pop());
    	//		 System.out.println("operand 1 " + operand1 );
    			 int operand2 = Integer.valueOf(post.pop());
    	//		 System.out.println("operand 2 " + operand2);
    			 switch (arg){
    	    	 case '+': ans = operand2 + operand1;
    	    	 break;
    	    	 case '-': ans = operand2 - operand1;
    	    	 break;	 
    	    	 case '*': ans = operand2 * operand1;
    	    	 break;
    	    	 case '/': ans = operand2/operand1;
    	    	 break;
    	    	 }
    			 post.push("" + ans);
    		 } else {//number 4
    		//	 System.out.println("number 4 " + arg + " at " + i);
    			 post.push("" + arg);
    		 }
    	 }
    //	 System.out.println("ans = " + ans);
    	 return ans;
     }
     
     String convert(String inf){//converting an infix expression to postfix
    	 Stack<String> s = new Stack<String>();
    	 String post = "";
    	 String[] args = inf.split(" ");
    	 for(int i= 0; i < args.length; i++){
    		 String c = args[i];
    		 if(c.codePointAt(0) == 52){//the only operand, number 4
    			 post += c;
    		 } else {//operator
    			 while(!s.isEmpty() && compare(c, s.peek()) >= 0){
    				 post += s.pop();
    			 }
    			 s.push(c); 
    		 }
    	 }
    	 while(!s.isEmpty()){
    		 post += s.pop();
    	 }
    	 return post;
     }
     
     int compare(String a, String b){//compare 2 operators
    	int ans = 2;
        //compare b to a
    	if(a.equals("+")){
    		if(b.equals("-") || b.equals("+")){
    			ans = 0;
    		} else {
    			ans = 1;
    		}
    	} else if(a.equals("-")){
    		if(b.equals("+") || b.equals("-")){
    			ans = 0;
    		} else {
    			ans = 1;
    		}
    	} else if(a.equals("*")){
    		if(b.equals("/") || b.equals("*")){
    			ans = 0;
    		} else {
    			ans = -1;
    		}
    	} else if(a.equals("/")){
    		if(b.equals("*") || b.equals("/")){
    			ans = 0;
    		} else {
    			ans = -1;
    		}
    	}
    	return ans;
     }
     
     void solve(int ans){
    	// System.out.println("size = " + map.size());
    	 if(map.containsKey(ans)){
    		 System.out.println(map.get(ans) + ans);
    	 } else {
    		 System.out.println("no solution");
    	 }
     }
     
     
	 public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);
		    Four f = new Four();
		    f.setup();
		    int TC = sc.nextInt();
		    sc.nextLine();
		    while(TC -- > 0){
		    	f.solve(Integer.valueOf(sc.nextLine()));
		    }
	 }
}
