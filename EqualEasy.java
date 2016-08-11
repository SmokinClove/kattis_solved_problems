import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
public class EqualEasy {
 private int[] memo;
 int N;
 String[] B;
 int[] A;
 int f, s;
 boolean found;
 
 int findLog2(int i){
  int ans = 0;
  while(i > 1){
   i /= 2;
   ans++;
  }
  return ans;
 }
 
 void run() throws NumberFormatException, IOException{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
  int TC = Integer.valueOf(br.readLine());
  int c = 1;
  while(TC -- > 0){
	  memo =new int[2000000];
	  for(int i = 0; i < 2000000; i++)
		  memo[i] = -1;
	  
	  found = false;
      N = 20;
      B = br.readLine().split(" ");
      A = new int[N + 1];
      f = 0;
      s = 0;
      for(int i = 1; i <= 20; i++){
          A[i] = Integer.valueOf(B[i]);
      }
      DP(0, 1);
      pw.println("Case #" + c++ + ":");
      if(found){
      String a = "", b = "";
      int l = f, k = s;
      while(l > 0){
       if(findLog2(LSB(l)) > 0)a += " " + A[findLog2(LSB(l))];//get rid of the zero
       l = l - LSB(l);
      }
      while(k > 0){
       if(findLog2(LSB(k)) > 0)b += " " + A[findLog2(LSB(k))];//get rid of the zero
       k = k - LSB(k);
      }
     
      pw.println(a.trim());
      pw.println(b.trim());
      } else {
       pw.println("Impossible");
      }
      pw.flush();
  }
  br.close();
  pw.close();
 }

 
 void DP(int i, int bitmask){
      if(memo[i] != -1 ){//this sum has  been computed before
    	  if(memo[i] != bitmask){
          f = bitmask;
          s = memo[i];
          found = true;
          }
      } else {
          memo[i] = bitmask;
          for(int k = 1; k < 21; k++){
              if(!found && !isOn(bitmask, k)){
                  DP(i + A[k] ,  turnOn(bitmask, k));
              }
          }
      }
    
 }
 
 int LSB(int i){
  return i & (-i);
 }
 
 int turnOn(int bitMask, int index){//turn on one bit
     bitMask = bitMask|(1 << index);
  return bitMask;
 }
   
 int turnOff(int bitMask, int index){//turn off one bit
  bitMask = bitMask^((1 << index));
  return bitMask;
 }
   
 boolean isOn(int bitMask, int index){
  return (bitMask&(1 << index)) != 0;
 }
 
 public static void main(String[] args) throws NumberFormatException, IOException{
  EqualEasy e = new EqualEasy();
  e.run();
 }
}
