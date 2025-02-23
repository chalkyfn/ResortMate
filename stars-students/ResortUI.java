
import java.util.*;
/**
 * Write a description of class ResortUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResortUI
{
    
    private Scanner reader = new Scanner(System.in);
    private STARS wayward = new Resort("Wayward Planets");
    
    private void runUI()
    {   

        int choice = getOption();        
        while (choice != 0)
        {            
            // process choice
            if      (choice == 1){listAllPlanets();}
            else if (choice == 2){listOnePlanet();}
            else if (choice == 3){findPermitLocation();}
            else if (choice == 4){tryTravel();}
            else if (choice == 5){travelNow();}
            else if (choice == 6){getPermitInfo();}
            else if (choice == 7){updateTokens();}
            else if (choice == 8){convertPoints();}
            // output menu & get choice
            choice = getOption();
        }
        System.out.println("\nThank-you");
    }
    
    
    private int getOption()
    {
       System.out.println("What would you like to do ?");
       System.out.println("0. Quit");
       System.out.println("1. List all planet details");
       System.out.println("2. List all permits on one planet");
       System.out.println("3. Find permit location");
       System.out.println("4. Say if permit can move by shuttle");
       System.out.println("5. Move a permit by shuttle");
       System.out.println("6. Get permit details");
       System.out.println("7. Top up tokens");
       System.out.println("8. Convert Points");
       //output menu and get choice
       System.out.println("Enter your choice");
       // read choice
       int option = reader.nextInt();
       reader.nextLine();
       return option;
    }
    
    // peovide the code here
    private void listAllPlanets()
    {   
        System.out.println(wayward.toString());
    }
    
    // This one has been done for you 
    private void listOnePlanet()
    {
        System.out.println("Enter name of planet");
        String ww = reader.nextLine();
        System.out.println(wayward.getAllPermitsOnOnePlanet(ww));
    }
    
    // provide the code here
    private void findPermitLocation()
    {
        System.out.println("Enter Permit ID you want to Locate: ");
        int tr = reader.nextInt();
        System.out.println("The permit is Located at " + wayward.getPermitLocation(tr));
    }
    
    // This one has been done for you 
    private void tryTravel()
    {
        System.out.println("Enter permit id");
        int trav = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter shuttle code");
        String shuttle = reader.nextLine();
        System.out.println(wayward.canTravel(trav,shuttle));
    }
    
    // Provide the code here
    private void travelNow()
    {
        System.out.println("Enter Permit ID");
        int trav = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter Shuttle Code");
        String shutle = reader.nextLine();
        System.out.println(wayward.travel(trav,shutle));
        
    }

    // this one has been done for you
    private void getPermitInfo()
    {
        System.out.println("Enter permit id");
        int trav = reader.nextInt();
        System.out.println(wayward.getPermitDetails(trav));
    }

    // provide the code here
    private void updateTokens()
    {
        System.out.println("Enter Permit ID");
        int permitID = reader.nextInt();
        System.out.println("How much do you want to Top-Up?");
        int topUP = reader.nextInt();
        
        wayward.topUpTokens(permitID,topUP);
    }
    
    // provide the code here
    private void convertPoints()
    {
        System.out.println("Enter Permit ID: ");
        int permitID = reader.nextInt();
        wayward.convertPoints(permitID);
    }
   
    
    public static void main(String[] args)
    {
        ResortUI xx = new ResortUI();
        xx.runUI();
    }
}
