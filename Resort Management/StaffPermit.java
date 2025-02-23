public class StaffPermit extends Permit {
    private int employeeNumber;
    private String jobDescription;
    private int journeyScore;

    public StaffPermit(int id, String name, int employeeNumber, String jobDescription) {
        super(id, name, 10, 0); 
        this.employeeNumber = employeeNumber;
        this.jobDescription = jobDescription;
        this.journeyScore = 0; 
    }

    @Override
    public void enterShuttle(){
        super.enterShuttle(); // Staff don't lose tokens, but jorney score increases
        journeyScore++; // ADD 1 to journey score for each shuttle journey
    }

    @Override
    public boolean canshuttle(){
        return true;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Employee Number: " + employeeNumber 
                + ", Job Description: " + jobDescription
                + ", Journey Score: " + journeyScore + "\n";
    }
}
