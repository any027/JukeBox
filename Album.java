import java.util.ArrayList;

//Album holds songs.
public class Album implements Comparable<Album> {
    
    private ArrayList<Song> Album = new ArrayList<Song>();
    private String name;
    private String artist;
    private boolean isPlaying = false;
    
    public Album(String name, String artist){
        this.name = name;
        this.artist = artist;
    }
    
    //get Album name
    public String getName(){
        return this.name;
    }
    
    //get Artist name
    public String getArtist(){
        return this.artist;
    }
    //add a song to the album
    public void addSong(Song song){
        if(Album.contains(song)){
            System.out.println("Song is already in album");
        } else {
            Album.add(song);
        }

    }
    
    //plays a song.
    public void playSong(Song song){
        if(Album.contains(song)){
            int number = Album.indexOf(song);
            Song choice = Album.get(number);
            choice.playSong();
        } else{
            System.out.println("Song does not exist in this album");
        }
    }
    
    public boolean removeSong(Song song){
        if(Album.contains(song)){
            for(int i = 0; i < Album.size() ; i++){
                if(Album.get(i).equals(song)){
                    Album.remove(i);
                    System.out.println("Song " + song.getName() + " removed");
                    return true;
                }
            }
        }
        System.out.println("Album does not contain song");
        return false;
    }
    
    public int compareTo(Album compares) {
        String compareage=((Album)compares).getName();
        /* For Ascending order*/
        return this.name.compareTo(compareage);

        /* For Descending order do like this */
        //return compareage-this.studentage;
    }
    
}