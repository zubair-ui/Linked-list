import java.util.*;
public class songPlaylist {
	
	node head;
	node shuffle;
	
	public void addSong(String songName,String artist,String duration){
		node nNode=new node(songName,artist,duration);
		
		if(head==null){
			head=nNode;
		}
		else{
			node tNode=head;
			
			while(tNode.next!=null){
				tNode=tNode.next;
			}
			tNode.next=nNode;
		}
	}
	
	public void removeSong(String songTitle){
		if(head.songName==songTitle){
			head=head.next;
		}
		else{
			node tNode=head.next;
			node pNode=head;
			
			while(tNode.next!=null){
				if(tNode.songName==songTitle){
					pNode.next=tNode.next;
					break;
				}
				pNode=tNode;
				tNode=tNode.next;
			}
		}
	}
	
	public void shuffleSong(){
		shuffle=head;
		node tNode=shuffle;
		int counter=0;
		while(tNode.next!=null){
			tNode=tNode.next;
			counter++;
		}
		tNode=shuffle;
		for(int i=1;i<counter;i++){
			int shuffleCounter=(int) (Math.random()*counter);
			for(int j=1;j<=shuffleCounter;j++){
					tNode=shuffle.next;
				
			}
			node tNode2 = new node("","","");
			tNode2.songName=shuffle.songName;
			tNode2.artist=shuffle.artist;
			tNode2.duration=shuffle.duration;
			
			shuffle.songName=tNode.songName;
			shuffle.artist=tNode.artist;
			shuffle.duration=tNode.duration;
			
			tNode.songName=tNode2.songName;
			tNode.artist=tNode2.artist;
			tNode.duration=tNode2.duration;
		}
	}
	
	public void playSong(){
		node tNode=head;
		int counter=1;
		System.out.println("Songs in the playlist:");
		while(tNode!=null){
			System.out.println(counter+". Name:"+tNode.songName+
					", Artist:"+tNode.artist+", Duration:"+tNode.duration);
			counter++;
			tNode=tNode.next;
		}
	}
	
	public void playSongShuffled(){
		node tNode=shuffle;
		int counter=1;
		System.out.println("Songs in the playlist(Shuffled):");
		while(tNode!=null){
			System.out.println(counter+". Name:"+tNode.songName+
					", Artist:"+tNode.artist+", Duration:"+tNode.duration);
			counter++;
			tNode=tNode.next;
		}
	}
	public static void main(String[] args) {
		songPlaylist obj = new songPlaylist();
		obj.addSong("Gunahgar", "Maaz siddique", "02:30");
		obj.addSong("Despacito", "Justin", "03:40");
		obj.addSong("Fight Back", "Neffex", "03:15");
		obj.addSong("Attention", "Charlie puth", "02:50");
		
		obj.playSong();
		System.out.println("\nAfter Removing");
		obj.removeSong("Despacito");
		obj.playSong();
		
		System.out.println();
		obj.shuffleSong();
		obj.playSongShuffled();
	}

}
