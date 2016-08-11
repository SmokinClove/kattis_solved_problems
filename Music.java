//wrong answer 29 Dec 10:48pm ;(
import java.util.*;
public class Music {
	private PriorityQueue<Song> songs;
	private ArrayList<Song> originals;
	private String attributes;
	
	Music(){
		songs = new PriorityQueue<Song>();
		originals = new ArrayList<Song>();
	}

	void accept(Song s){
		originals.add(s);
	}
	
	void setAttr(String att){
		attributes = att;
	}
	
	String getAttr(String att){
		return attributes;
	}
	
	void sort(String attr){
	//	System.out.println("size = " + songs.size());
		PriorityQueue<Song> q = new PriorityQueue<Song>( new Comparator<Song>(){
			public int compare(Song o1, Song o2) {
				//return o1.get(attr).compareTo(o2.get(attr));
			
				if(o1.get(attr).compareTo(o2.get(attr)) == 0){
					return o1.order() - o2.order();
				} else {
					return o1.get(attr).compareTo(o2.get(attr));
				}
				
			}
		});
		if(!songs.isEmpty()){//not the first add
		//	System.out.println("not first sort, size = " + songs.size());
			int order = 0;
		    while(!songs.isEmpty()){	
		    	Song poll = songs.poll();
		    	poll.setOrder(order++);
			    q.add(poll);
		    }
		} else {
			//System.out.println("original size = " + originals.size());
			for(int i = 0; i < originals.size(); i++){
			//	System.out.println("in for loop, q size = " + q.size());
		//		originals.get(i).print();
				q.add(originals.get(i));
			}
			//System.out.println("q size = " + q.size());
		}
		songs = new PriorityQueue<Song>( new Comparator<Song>(){
			public int compare(Song o1, Song o2) {
				//return o1.get(attr).compareTo(o2.get(attr));
				
				if(o1.get(attr).compareTo(o2.get(attr)) == 0){
					return o1.order() - o2.order();
				} else {
					return o1.get(attr).compareTo(o2.get(attr));
				}
				
			}
			
		});
		
		//System.out.println("start printing");
		while(!q.isEmpty()){
			Song s = q.poll();
			s.print();
			songs.add(s);
		}
	//	System.out.println("done sorting");
	}
	
	public static void main(String[] args) {
		   Scanner sc = new Scanner(System.in);
		   Music m = new Music();
		   String att = sc.nextLine();
		   m.setAttr(att);
		   String[] attr = att.split(" ");//a list of attributes
		   int numSongs = Integer.valueOf(sc.nextLine());
		   for(int i = 0; i < numSongs; i++){
			   String content = sc.nextLine();
			   String[] song = content.split(" ");
			   m.accept(new Song(song, attr, content, i));
		   }
		   int TC = Integer.valueOf(sc.nextLine());
		   while(TC -- > 0){
			   System.out.println(m.getAttr(att));
			   m.sort(sc.nextLine());
			   System.out.println("");
		   }
		   sc.close();
	}
}

class Song {
	private HashMap<String, String> map;
	private String content;
	private int order;
	Song(String[] details, String[] attr, String s, int order){
		content = s;
		this.order = order;
		map = new HashMap<String, String>();
		for(int i = 0; i < details.length; i++){
	     	map.put(attr[i], details[i]);
		}
	}
	
	String get(String trait){
		return map.get(trait);
	}
	
	int order(){
		return this.order;
	}
	
	void setOrder(int o){
		this.order = o;
	}
	
	void print(){
		System.out.println(content); 
	}
	
}
