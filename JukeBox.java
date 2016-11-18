import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

// todo: Implement showing the albums in the array list to make it more jukeboxy

public class JukeBox {
    
    private boolean power = false;
    public int currentCredit;
    public ArrayList<Album> songBank;
    
    public JukeBox(){
        power = true;
        songBank = new ArrayList<Album>();
        startDataBank();
        currentCredit = 0;
        /*
        System.out.println("    __       __         ___.");                 
        System.out.println("   |__|__ __|  | __ ____\_ |__   _______  ___");
        System.out.println("    |  |  |  \  |/ /  __ \| __ \ /  _ \  \/  "); 
        System.out.println("    |  |  |  /    <\  ___/| \_\ (  <_> >    < ");
        System.out.println("/\__|  |____/|__|_ \\___  >___  /\____/__/\_ \");
        System.out.println("\______|                                      ");
        */
        System.out.println("Welcome to Anthony's Jukebox!");
        turnOn();
    }
    
    public int getCredits(){
        return currentCredit;
    }
    
    public void putCredit(){
        currentCredit += 1;
    }
    
    public void useCredit(){
        currentCredit -= 1;
        if(currentCredit <= 0){
            currentCredit = 0;
        }
    }
    
    //prompts use to put in credit to play a song
    public void turnOn(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Press P to play a song");
        System.out.println("Press C to put in a credit");
        System.out.println("Press Q to quit");
        while(power){
            System.out.println("Current Credits = " + getCredits());
            String input = reader.nextLine();
            if(input.length() == 0){
                continue;
            }else if(input.charAt(0)=='Q' || input.charAt(0) == 'q'){
                System.out.println("Shutting down services");
                power = false;
            }else if(input.charAt(0)=='C' || input.charAt(0) == 'c'){
                putCredit();
                //System.out.println("Current Credits = " + getCredits());
            }else if(input.charAt(0)=='P' || input.charAt(0) == 'p'){
               if(getCredits() <= 0){
                    System.out.println("Please put in a credit");
               }else{
                   System.out.println("Please choose an album");
                   albumSelection();
               }
            }else {
                System.out.println("Please put in a valid input");
            }
            
        }

    }
    
    public void albumSelection(){
        boolean songChoice = false;
        Scanner reader = new Scanner(System.in);
      


      
        for(int i = 0; i < songBank.size() ; i++){
        if(getCredits() == 0){
            System.out.println("Please put in another credit");
            turnOn();
            break;
        }
        System.out.println("Album: " + songBank.get(i).getName() + 
                        " Arist " + songBank.get(i).getArtist());
        System.out.println("Press C to choose this album");
        System.out.println("Press N to go to the next album");
        String input = reader.nextLine();
            if( input.length() == 0){
                i = i-1;
            }else if(input.charAt(0) == 'c' || input.charAt(0) == 'C'){
                for(int j = 0; j < songBank.get(i).getLength();j++){
                    System.out.println("Album: " + songBank.get(i).getName() + 
                    " Song " + songBank.get(i).getSong(j).getName());
                    System.out.println("Press C to choose this song");
                    System.out.println("Press N to go to the next song");
                    System.out.println("Press Q to go to the album selection");                     
                    String input2 = reader.nextLine();
                    if(input2.length() == 0){
                        j = j-1;
                    }else if(input2.charAt(0) =='c' || input2.charAt(0) =='C'){
                        songBank.get(i).getSong(j).playSong();
                        useCredit();
                        break;
                    }else if(input2.charAt(0) =='n' || input2.charAt(0) =='N'){
                        if(j == songBank.get(i).getLength()-1){
                            j = 0-1;
                      }
                    }else if(input2.charAt(0) =='q' || input2.charAt(0) =='Q'){
                            break;
                    }else {
                        j = j-1;
                    }

                }
            }else if(input.charAt(0) =='N' || input.charAt(0) == 'n'){
                if(i == songBank.size()-1){
                    i = 0-1;
                }
                continue;    
            }else{
                i = i-1;
            }
        }
        
    }
    public static void main(String[] args){
        JukeBox juke = new JukeBox();
    }
    
    public void startDataBank(){
        //Below are random albums just for testing.
        
        //Adding the album Animal Farm
        Song Goat = new Song("Goat", "Animal Farm", "Orwell" , 60);
        Song Pig = new Song("Pig", "Animal Farm", "Orwell", 60);
        Song Sheep = new Song("Sheep", "Animal Farm", "Orwell", 60);
        Album Animal_Farm = new Album("Animal Farm", "Orwell");
        Animal_Farm.addSong(Goat);
        Animal_Farm.addSong(Pig);
        Animal_Farm.addSong(Sheep);
        
        //Adding the album Alphabet
        Song A = new Song("A", "Alphabet", "Momma Z" , 60);
        Song B = new Song("B", "Alphabet", "Momma Z", 60);
        Song C = new Song("C", "Alphabet", "Momma Z", 60);
        Album Alphabet = new Album("Alphabet", "Momma Z");
        Alphabet.addSong(A);
        Alphabet.addSong(B);
        Alphabet.addSong(C);
        
        //Adding the album Smash
        Song Mario = new Song("Mario", "Smash", "Sakurai", 60);
        Song Sonic = new Song("Sonic", "Smash", "Sakurai", 60);
        Song Link = new Song("Link", "Smash", "Sakurai", 60);
        Album Smash = new Album("Smash", "Sakurai");
        Smash.addSong(Mario);
        Smash.addSong(Sonic);
        Smash.addSong(Link);
        
        songBank.add(Animal_Farm);
        songBank.add(Alphabet);
        songBank.add(Smash);
        
        //Sorts all the songs
        Collections.sort(songBank);
    }
    

    
    
}