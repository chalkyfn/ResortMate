 
import java.util.*;
/**
 * Write a description of class MyTester here.
 * 
 * @author 
 * @version 
 */
public class MyTester 
{   
    Resort wayward = new Resort("wayward");
    private void doTest1()
    {        
       // Test: Display all Plant Details
        System.out.println("** Test 1: Displaying all planets ** \n");
        System.out.println(wayward.toString());
        System.out.println("Expected: All planets with their details (ID, name, rating, capacity) displayed.\n");
    
        
        // Test2: Display A Specific Permit Details
        System.out.println("** Test 2a: Displaying Permit 1000 Details **");
        System.out.println(wayward.getPermitDetails(1000));
        System.out.println("Expected: Permit with their details (ID: 1001, guestname: Lynn, Luxuryrating: 5, Number Of Tokens: 6 \n");
        
        System.out.println("** Test 2b: Displaying Permit 1002 Details **");
        System.out.println(wayward.getPermitDetails(1002));
        System.out.println("Expected: Permit with their details (ID: 1002, guestname: May, Luxuryrating: 3, Number Of Tokens: 20 \n");
        
        
        // Test3: Display A Specific Permit Location
        System.out.println("** Test 3a: Displaying Permit 1000 Location **");
        System.out.println(wayward.getPermitLocation(1000));
        System.out.println("Expected: Permit with Location : Home \n");

        System.out.println("** Test 3b: Displaying Permit 1005 Location **");
        System.out.println(wayward.getPermitLocation(1005));
        System.out.println("Expected: Permit with Location : Home \n");
        
        
        //Test4: Display A Specific Planet Number or ID
        System.out.println("** Test 4a: Displaying Planet Number or ID for Specific Planet **");
        System.out.println("Planet Number for Home: " + wayward.getPlanetNumber("Home"));
        System.out.println("Expected: 0 \n");
        
        System.out.println("** Test 4b: Displaying Planet Number or ID for Specific Planet **");
        System.out.println("Planet Number for Sprite: " + wayward.getPlanetNumber("Tropicana"));
        System.out.println("Expected: 2 \n");
        
        //Test5: Display all Permits in A Specific Planet
        System.out.println("** Test 5a: Displaying all Permit in Specific Planet **");
        System.out.println("All Permits in Home: " + wayward. getAllPermitsOnOnePlanet("Home"));
        System.out.println("Expected: return all permits since all permits are initially in Home \n");
        
        System.out.println("** Test 5b: Displaying all Permit in Specific Planet **");
        System.out.println("All Permits in Tropicana: " + wayward. getAllPermitsOnOnePlanet("Tropicana"));
        System.out.println("Expected: Should not return any Permit since no Planet in Tropicana  \n");
        
        //Test6: Display Boolean if Permit can Travel to Planet
        System.out.println("** Test 6a: Displaying Boolean if Permit can Travel **");
        System.out.println("Can a 1001 Travel to Sprite: " + wayward.canTravel(1001,"ABC1"));
        System.out.println("Expected: Should return 'true' since permit is not on the sh  uttle's Planet \n");
        
        System.out.println("** Test 6b: Displaying Boolean if Permit can Travel **");
        System.out.println("Can a 1004 Travel to Tropicana: " + wayward.canTravel(1004,"ABC1"));
        System.out.println("Expected: Should return 'false' since permit check all requirement \n");
        
        //Test7: Display String to Show if a Permit made a Journey
        System.out.println("** Test 7a: Display String to Show if a Permit made a Journey **");
        System.out.println(wayward.travel(1001,"ABC1"));
        System.out.println("Expected: Journey Completed \n");
        
        System.out.println("** Test 7b: Display String to Show if a Permit made a Journey **");
        System.out.println(wayward.travel(1004,"ABC1"));
        System.out.println("Expected: Journey Could not be Completed \n");
        
        //Test8: Test Method to TopUp Tokens
        System.out.println("** Test 8a: TopUp Permit Tokens **");
        System.out.println(wayward.getPermitDetails(1000));
        wayward.topUpTokens(1000,7);
        System.out.println("Expected: Total Token to increse from 6 to 13  ");
        System.out.println(wayward.getPermitDetails(1000));
        
        System.out.println("** Test 8b: TopUp Permit Tokens **");
        System.out.println(wayward.getPermitDetails(1005));
        wayward.topUpTokens(1005,10);
        System.out.println("Expected: Total Token to increse from 5 to 10 \n ");
        System.out.println(wayward.getPermitDetails(1005));
        
        //Test9: Test Method to ConvertPoints
        System.out.println("** Test 9a: Convert Tokens To Points **");
        System.out.println(wayward.getPermitDetails(1000));
        wayward.convertPoints(1000);
        System.out.println("Expected: Total Points \n");
        System.out.println(wayward.getPermitDetails(1000));
                        
    }
    
    
     
     
    
    public static void main(String[] args)
    {
        MyTester xx = new MyTester();
        xx.doTest1();
        

        
    }
}
