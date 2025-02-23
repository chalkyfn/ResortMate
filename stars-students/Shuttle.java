 
/**
 * A shuttle provides a one-way connection between two planets. It
 * has a Shuttle code and information about both the source and
 * the destination planet
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shuttle
{
    private String shuttleCode;
    private Planet from_planet;
    private Planet to_planet;
    
    public Shuttle(String shuttlecode, Planet froplanet, Planet toplanet){
        shuttleCode = shuttlecode;
        from_planet = froplanet;
        to_planet = toplanet;
    }
    
    public String get_shuttlecode(){
        return shuttleCode;
    }
    
    
    public boolean canShuttle(Permit P){
        
        if (P.get_luxuryRating() < to_planet.get_luxuryRating()){
                return false;
        }
        
        if(to_planet.hasCapacity() == false){
             return false;       
        }
        
        if(P.canshuttle() == false){
            return false;
        }
        
        if (from_planet.onPlanetCheck(P) == false){
            return false;
        }
        
        return true;    
    }
    
    public String makeJourney(Permit P){
        if (canShuttle(P) == true){
                P.enterShuttle();
                from_planet.leave(P);
                to_planet.arrive(P);
                return "Journey Completed";
        }else{
        return "Journey Could not be Completed";
    }

    }
    
    public String toString(){
        return "Source Planet: " + from_planet+
         "\nReference Number: "+ from_planet.get_planetID()+
         "Destination: " + to_planet +
         "\nReference Number: " + to_planet.get_planetID();
    }
    
}
