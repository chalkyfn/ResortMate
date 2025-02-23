 
import java.util.*;
/**
 * An planet is part of a STARS resort.Each planet has a name,  a luxury rating
 * and a capacity which represents the maximum number of permits(people) who can be on the  
 * planet at any one time. Each planet must maintain a list of all permits(people)
 * currently on the planet. These lists are updated whenever permits arrive or leave 
 * an planet,so that it is always possible to say how many permits(people) are on the planet 
 * and who they are.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Planet 
{
    private int planetID;
    private String planetName;
    private int rating;
    private int capacity;
    private ArrayList<Permit> permitsOnPlanet;
    
    public Planet(int planetid, String planetname, int raTing , int caPacity){
        planetID = planetid;
        planetName = planetname;
        rating = raTing;
        this.capacity = caPacity;
        this.permitsOnPlanet = new ArrayList<>();
    }
    
    public int get_planetID(){ // returns Planet ID
        return planetID;
    }
    
    public String get_planetName(){ //returns planet Name
        return planetName;
    }
    
    public int get_luxuryRating(){ //returns Luxury Rating
        return rating;
    }
    
    public int getCapacity(){  // returms capacity of Planet
        return permitsOnPlanet.size();
    }
    
    public void arrive(Permit permit){ // adds A permit to Planet
        permitsOnPlanet.add(permit);
        
    }
    
    public void leave(Permit permit){ // removes a permit from Planet
        if (permitsOnPlanet.contains(permit)){
                permitsOnPlanet.remove(permit);
        }
    }
   
    public String checkCapacity(){ // checks if Planet has Capacity
        if (permitsOnPlanet.size() < capacity){
            return "Planet still has Capcity";
            
        }else if (permitsOnPlanet.size() == capacity){
            return "Planet is at Full Capacity";
        }
        return "";
    }
    
    public boolean hasCapacity(){  // returns Boolean if Planet has Capacity
        return permitsOnPlanet.size() < capacity;
    }
    
     public void getAllPermitDetails(){  // returns all Permits Details in a Planet
        for (Permit permit: permitsOnPlanet){
            permit.toString();
        }
    }
    
    public boolean onPlanetCheck(Permit permit){ // returns Boolean if permit is on Planet
        return permitsOnPlanet.contains(permit);
    }
    
    public boolean onPlanetCheckbyID(int tr){ // returns Boolean if permit is on Planet by permitid
        for(Permit p : permitsOnPlanet){
            if (p.get_permitID() == tr){
                return true;
            }
        }
        return false;
    }
    
    public String checkPermitDetails(int permitid){ //returns permit details of a permit by permitid
            for(Permit i : permitsOnPlanet){
                if (i.get_permitID() == permitid){
                    return i.toString() ;
                }
        }  
        return "";
    }
           
        
    public String permitDetails(){
        if(permitsOnPlanet.isEmpty()){
            return "No permits on this planet";
        }
        
        String s = "";
        for (Permit permit : permitsOnPlanet){
            s += permit.toString() + "\n";
        }
        return s;
    }
    
    public String toString(){
         return "Reference Number : " + get_planetID()  + 
                " Planet Name : " + planetName+
                " Luxury Rating : " + get_luxuryRating()+
                " Capacity : " + capacity  + 
                " Permits : " + permitsOnPlanet;
    }   
    
    
}
