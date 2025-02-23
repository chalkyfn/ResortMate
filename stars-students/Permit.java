 
/**
 * A Permit has an id number, name, a luxury rating,  tokens and points.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Permit 
{
    
   private int permitID;
   private String guestName;
   private int luxuryRating;
   private int noOfTokens;
   private int noOfPoints = 0;

   public Permit(int permitid,String guestname, int luxuryrating, int nooftokens){
       permitID = permitid; 
       guestName = guestname;
       luxuryRating = luxuryrating;
       noOfTokens = nooftokens;
   }
   
   
   public int get_permitID(){   // this method returns the permit ID
       return permitID;
   }
   
   public int get_luxuryRating(){   // this methodreturns the luxury rating
       return luxuryRating;
   }
   
   public int get_noOfTokens(){     // this method returns the number of tokens user has 
       return noOfTokens;
   }
   
   public int get_noOfPoints(){  // this method returns number of points
        return noOfPoints; 
    }
   
   public void deductToken(int changeToken){    // this method deducts number of tokens
       noOfTokens -=  changeToken;
   }
    
   public void addToken(int changeToken){   // this method adds to the number of tokens
       noOfTokens += changeToken;
   }
   
   public void convertPoints(){  // this method converts points to tokens
        noOfTokens += (noOfPoints / 4);
    }
    
    public void enterShuttle(){  
        if (canshuttle() == true){
            noOfTokens -= 3;
            noOfPoints += 1;
        }
    }
    
    public boolean canshuttle(){ // returns boolean to see if guest can enter shuttle
        return noOfTokens >= 3;
    }
    
 
    public String toString(){ // prints out relevant information about guest
        
        return "Permit ID : " + get_permitID()  + 
                " Guest Name : " + guestName +
                " Luxury Rating : " + luxuryRating +
                " Number Of Tokens : " + get_noOfTokens() + "\n";
    }
    
   
    
}

