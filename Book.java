import java.util.*;
public class Book {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int numRooms = sc.nextInt();
		int numBooked = sc.nextInt();
		sc.nextLine();
		boolean[] rooms = new boolean[numRooms];
		while(numBooked -- > 0){
			rooms[Integer.valueOf(sc.nextLine()) - 1] = true;
		}
		
		boolean full = true;
		for(int i = 0; i < numRooms; i++){
			if(rooms[i] == false){
				full = false;
				System.out.println(i + 1);
				break;
			}
		}
		if(full){
			System.out.println("too late");
		}
	}
}
