import java.io.*;
import java.util.*;
public class Bit {
    private ArrayList<String> arr;
	public void setup(){
		arr = new ArrayList<String>();
		for(int i = 0; i < 32; i++){
			arr.add("?");
		}
	}
	
	public void set(int i, String val){
		arr.set(i, val);
	}
	
	public boolean isOn(int i){
		return arr.get(i).equals("1");
	}
	
	public boolean isOff(int i){
		return arr.get(i).equals("0");
	}
	
	public boolean question(int i){
		return arr.get(i).equals("?");
	}
	
	public void print(){
		for (int i = 31; i >= 0; i--){
			System.out.print(arr.get(i));
		}
		System.out.println("");
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Bit b =  new Bit();
		int TC = sc.nextInt();
		sc.nextLine();
		while(TC != 0){
			b.setup();
			
			for(int i = 0; i < TC; i++){
				String[] command = sc.nextLine().split(" ");
				if(command[0].equals("CLEAR")) {
					b.set(Integer.valueOf(command[1]), "0");
				} else if(command[0].equals("SET")) {
				    b.set(Integer.valueOf(command[1]), "1");
				} else if (command[0].equals("AND")){
					if(b.isOn(Integer.valueOf(command[1]))){
						if(b.question(Integer.valueOf(command[2]))){ //if the second is unsure, put ?
							b.set(Integer.valueOf(command[1]), "?");
							//if the second is 0, turn off
						} else if(b.isOff(Integer.valueOf(command[2]))){
							b.set(Integer.valueOf(command[1]), "0");	
						}
							//if the second is 1, do nothing
					} else if (b.question(Integer.valueOf(command[1]))){//if the first is unsure
						if(b.isOff(Integer.valueOf(command[2]))){
							b.set(Integer.valueOf(command[1]), "0");
						}
						//if the second is unsure or 1, do nothing
					}
				} else {//OR
					//if the first index is already 1, do nothing
					if(b.isOff(Integer.valueOf(command[1]))){
						if(b.question(Integer.valueOf(command[2]))){
							b.set(Integer.valueOf(command[1]), "?");
						} else if (b.isOn(Integer.valueOf(command[2]))){
							b.set(Integer.valueOf(command[1]), "1");
						}
					} else if (b.question(Integer.valueOf(command[1]))){
						if (b.isOn(Integer.valueOf(command[2]))){
							b.set(Integer.valueOf(command[1]), "1");
						}
					}
				}
			}
			b.print();
			TC = Integer.valueOf(sc.nextLine());
		}
	}
}
