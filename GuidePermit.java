public class GuidePermit extends Permit {
    private String citizenship;

    public GuidePermit(int permitid, String guidename, int luxuryrating, int nooftokens, String Planet) {
        super(permitid, guidename, luxuryrating, nooftokens);
        this.citizenship = Planet;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Citizenship: " + citizenship + "\n";
    }
    
}
