 
import java.util.*;

/**This class implements the STARS interface
 *
 * @author A.A.Marczyk 
 * @version 09/11/21
 **/
public class Resort implements STARS 
{
    private String location;
    // more fields
    private ArrayList<Planet> allPlanets;
    private ArrayList<Shuttle> allShuttle;
    private ArrayList<Permit> allPermits;


    /** constructor
     */
    public Resort(String loc) 
    {
        location = loc;
        
        allPlanets = new ArrayList<>();
        allShuttle = new ArrayList<>();
        allPermits = new ArrayList<>();
        
        
        loadPlanets();
        setUpShuttles();
        loadPermits();
        
        Planet Home = allPlanets.get(0);
        for (Permit allPermits : allPermits){
            Home.arrive(allPermits);
        } //assigns all permit to Home
        
        
    }
    
    /**
     * Returns all of the details of all planets including the permits
     * currently on each planet, on "No permits"
     * @return all of the details of all planets including location 
     * and all permits currently on each planet, or "No permits" 
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (Planet planet : allPlanets){
            sb.append(planet.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
    
    /**Returns a String with details of a permit
     * @param permitId - id number of the permit
     * @return the details of the permit as a String, or "No such permit"
     */
    @Override
    public String getPermitDetails(int permitId)
    {
        Permit permit = getPermit(permitId);
        
        if ( permit != null){
            return permit.toString();
        }
        return "No such permit";
    }

    /**Returns the name of the planet which contains the specified permit or null
     * @param tr - the specified permit
     * @return the name of the Planet which contains the permit, or null
     **/
     @Override
    public String getPermitLocation(int tr)
    {
        for (Planet p : allPlanets){
            if (p.onPlanetCheckbyID(tr)){
                return p.get_planetName();
            }
        }
        
        return null;
    }
    
    /** Given the name of a planet, returns the planet id number
     * or -1 if planet does not exist
     * @param name of planet
     * @return id number of planet
     */
    @Override
    public int getPlanetNumber(String ww)
    {
        for(Planet p: allPlanets){
            if (p.get_planetName() == ww){
                return p.get_planetID();
            }
        }
        return -1;
    }
                
    /**Returns a String representation of all the permits on specified planet
     * @return a String representation of all permits on specified planet
     **/
    @Override
    public String getAllPermitsOnOnePlanet(String planetName)
    {
        Planet planet = getPlanet(planetName);
        
        if (planet == null){
            return "Planet not found";
        }
        
        return planet.permitDetails();
        
    } 

    
    /**Returns true if a Permit is allowed to move using the shuttle, false otherwise
     * A move can be made if:  
     * the rating of the permit  >= the rating of the destination planet
     * AND the destination planet is not full
     * AND the permit has sufficient tokens
     * AND the permit is currently in the source planet
     * AND the permit id is for a permit on the system
     * AND the shuttle code is the code for a shuttle on the system
     * @param trId is the id of the permit requesting the move
     * @param shtlCode is the code of the shuttle journey by which the permit wants to pPermitel
     * @return true if the permit is allowed on the shuttle journey, false otherwise 
     **/    
    @Override
    public boolean canTravel(int trId, String shtlCode)
    {   
        Permit permit = getPermit(trId);
        Shuttle shuttle =  getShuttle(shtlCode);
        
        if (permit == null || shuttle == null){
            return false;
        }
        
        return shuttle.canShuttle(permit);
 
    }     

    /**Returns the result of a permit requesting to move by Shuttle.
     * A move will be successful if:  
     * the luxury rating of the permit  >= the luxury rating of the destination planet
     * AND the destination planet is not full
     * AND the permit has sufficient tokens
     * AND the permit is currently in the source planet
     * AND the permit id is for a permit on the system
     * AND the shuttle code is the code for a shuttle on the system
     * If the shuttle journey can be made, the permit information is removed from the source
     * planet, added to the destination planet and a suitable message returned.
     * If shuttle journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param pPermitId is the id of the permit requesting the move
     * @param shtlCode is the code of the shuttle journey by which the permit wants to pPermitel
     * @return a String giving the result of the request 
     **/
    public String travel(int pPermitId, String shtlCode )
    {   
        Permit permit = getPermit(pPermitId);
        Shuttle shuttle =  getShuttle(shtlCode);
        
        if (permit == null){
            return "permit not found";
        }
        if (shuttle == null)
        {
            return "shuttle not found";
        }

        return shuttle.makeJourney(permit); 
    } 
         

    /** Allows a permit to top up their tokens.This method is not concerned with 
     *  the cost of a credit as currency and prices may vary between resorts.
     *  @param id the id of the permit toping up their tokens
     *  @param tkns the number of tokens purchased to be added to permits information
     */
    @Override
    public void topUpTokens(int id, int tkns)
    {
        Permit permit = getPermit(id);
        if (permit != null){
            permit.addToken(tkns);
        }
    }
    
    /** Allows the points on a permit to be converted to tokens (4 points = 1 token)
     *  @param id the id of the card toping up their tokens
     */
    @Override
    public void convertPoints(int id)
    {
        Permit permit = getPermit(id);
        permit.convertPoints();
    } 
   
    //***************private methods**************
    private void loadPlanets()
    {
        allPlanets.add(new Planet(0, "Home", 0, 1000)); // Planet 0: Home
        allPlanets.add(new Planet(1, "Sprite", 1, 100)); // Planet 1: Sprite
        allPlanets.add(new Planet(2, "Tropicana", 3, 10)); // Planet 2: Tropicana
        allPlanets.add(new Planet(3, "Fanta", 5, 2)); // Planet 3: Fanta
        allPlanets.add(new Planet(4, "Coke", 1, 1)); // Planet 4: Coke
    }
    
    private void setUpShuttles()
    {
        allShuttle.add(new Shuttle("ABC1", allPlanets.get(0), allPlanets.get(1))); // Home -> Sprite
        allShuttle.add(new Shuttle("BCD2", allPlanets.get(1), allPlanets.get(0))); // Sprite -> Home
        allShuttle.add(new Shuttle("CDE3", allPlanets.get(1), allPlanets.get(2))); // Sprite -> Tropicana
        allShuttle.add(new Shuttle("DEF4", allPlanets.get(2), allPlanets.get(1))); // Tropicana -> Sprite
        allShuttle.add(new Shuttle("EFG5", allPlanets.get(3), allPlanets.get(1))); // Fanta -> Sprite
        allShuttle.add(new Shuttle("GHJ6", allPlanets.get(1), allPlanets.get(4))); // Sprite -> Coke
        allShuttle.add(new Shuttle("HJK7", allPlanets.get(4), allPlanets.get(1))); // Coke -> Sprite
        allShuttle.add(new Shuttle("JKL8", allPlanets.get(2), allPlanets.get(3))); // Tropicana -> Fanta
    }
    
    private void loadPermits()
    {
        allPermits.add(new Permit(1000,"Lynn",5,6));
        allPermits.add(new Permit(1001,"May",3,20));
        allPermits.add(new Permit(1002,"Nils",10,20));
        allPermits.add(new Permit(1003,"Olek",1,12));
        allPermits.add(new Permit(1004,"Pan",3,2));
        allPermits.add(new Permit(1005,"Quin",1,5));
        allPermits.add(new Permit(1006,"Raj",10,6));
        allPermits.add(new Permit(1007,"Sol",7,20));
        allPermits.add(new Permit(1008,"Tel",6,24));
        allPermits.add(new Permit(1009,"Zan",9,50));
        allPermits.add(new GuidePermit(1010, "Una", 5, 10, "Earth"));// Adding GuidePermit
        allPermits.add(new BusinessPermit(1011, "Val", 3));// Adding BusinessPermit
        allPermits.add(new StaffPermit(1012, "Wei", 12345, "Pilot"));// Adding StaffPermit
        

    }
 
    /** Returns the permit with the permit id specified by the parameter
     * @return the permit with the specified name
     **/
    public Permit getPermit(int id)
    {
        for (Permit permit: allPermits){
            if (permit.get_permitID() == id){
                return permit;
            }
        }
        return null;
    }
    
    
    /** Returns the planet with the name specified by the parameter
     * @return the planet with the specified name
     **/
    public Planet getPlanet(String planetName)
    {
        for (Planet planet : allPlanets){
            if (planet.get_planetName().equals(planetName)) {
                return planet;
            }
        }
        return null;
    }
    
    /** Returns the planet with the name specified by the parameter
     * @return the planet with the specified name
     **/
    private Shuttle getShuttle(String shut)
    {
        for (Shuttle shuttle: allShuttle){
            if (shuttle.get_shuttlecode().equals(shut)){
                return shuttle;
            }
        }
        return null;
    }
    
    //other private methods
    
    
    private boolean containshtlcode(String shtlcd){  //Method returns if a shuttlcode belongs shuttle 
        for (Shuttle s : allShuttle){
            if (s.get_shuttlecode().equals(shtlcd)){
                return true;
            }
        }
        return false;
    }
    
}