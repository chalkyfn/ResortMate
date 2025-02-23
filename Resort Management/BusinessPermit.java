public class BusinessPermit extends Permit {
    private int freeDrinks;

    public BusinessPermit(int id, String name, int luxuryRating) {
        super(id, name, luxuryRating, 30); // Business permits start with 30 tokens
        this.freeDrinks = 10; // Business permits start with 10 free drinks
    }

  
    public void deductTokens(int tokens) {
        super.deductToken(2); // Deduct only 2 tokens for shuttle journeys
        if (freeDrinks > 0) {
            freeDrinks--; // Deduct one free drink if available
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Free Drinks Remaining: " + freeDrinks + "\n";
    }
}