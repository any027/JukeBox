//This is the song class, which lists out a songs Name, Album, 
//Aritist and length.

public class Song {
    
    //these are the field variables
    //They should NEVER have to be changed EXCEPT complete.
    private String name;
    private String album;
    private String artist;
    private long length;
    //Complete is a variable that tells us whether a song is done playing or 
    //not.
    public boolean complete = false;
    
    public Song(String name, String album, String artist, long length){
        this.name = name;
        this.album = album;
        this.artist = artist;
        this.length = length;
    }

    //accessors here
    public String getName(){
        return this.name;
    }
    
    public String getAlbum(){
        return this.album;
    }
    
    public String getArtist(){
        return this.album;
    }
    
    public long getLength(){
        return this.length;
    }
    
    public boolean getComplete(){
        return this.complete;
    }
    
    public void setComplete(boolean status){
        this.complete = status;
    }
    
    public void playSong(){
        
        //Thread stuff maybe in the future?
        if( getComplete() ){
            setComplete(false);
        } 
        setComplete(true);
    }
    
}