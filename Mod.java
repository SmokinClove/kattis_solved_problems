import java.util.*;

public class Mod {
private static TreeSet<Integer> S;

public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	S=new TreeSet<Integer>();
	int ans=0;
	for(int i=0;i<10;i++){
		int mod=sc.nextInt()%42;
		if(!S.contains(mod)){
			ans++;
			S.add(mod);
		}
	}
System.out.println(ans);
}
}
