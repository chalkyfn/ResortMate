
/**
 * Write a description of class PermitTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PermitTester
{
    public static void main(String[] args)
    {
        Permit firstGuest = new Permit(0001,"John Doe",8,10);
        
        Permit secondGuest = new Permit(13, "Janet Doe" , 5 ,5);
        
        System.out.println("Permit ID is: " + firstGuest.get_permitID() + " expected output : 1"); 
        System.out.println("Luxury Rating is: " + firstGuest.get_luxuryRating() + " expected output : 8"); 
        System.out.println("No of Tokens is: " + firstGuest.get_noOfTokens()+ " expected output : 10");
        
        firstGuest.deductToken(2);
        System.out.println("Deduct 2 Tokens would  : " + firstGuest.get_noOfTokens() + " expected output : 8"); 
        
        firstGuest.addToken(10);
        System.out.println("add 10 Tokens would give : " + firstGuest.get_noOfTokens() + " expected output : 18"); 
        
        firstGuest.convertPoints();
        System.out.println("Converted Tokens to Points : " + firstGuest.get_noOfTokens()+ " expected output : 10");
        
        System.out.println("Can Guest Shuttle : " + firstGuest.canshuttle() + " expected output : true");
        
        firstGuest.enterShuttle();
        System.out.println("Number Of Tokens : " + firstGuest.get_noOfTokens() + " expected output : 15");
        System.out.println("Number Of Points : " + firstGuest.get_noOfPoints() + " expected output : 1");
        
    }
        
    
}
