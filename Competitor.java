import java.sql.Array;
import java.util.Arrays;

public class Competitor extends Person {

    private int compNumber;
    private final String competitorLevel;
    private String email;
    private String category;
    private boolean isWinner = false;

    private int scores[] = new int[5];

    private double avgScore;

    public Competitor(String fName, String mName, String lName, String countryName, int personAge, String phNumber, int cNumber, String compLevel, String email, String cat ) {
        super(fName, mName, lName, countryName, personAge, phNumber);
        compNumber = cNumber;
        competitorLevel = compLevel;
        this.email = email;
        category = cat;
    }

    public int getCompNumber() {
        return compNumber;
    }

    public String getCompetitorLevel() {
        return competitorLevel;
    }

    public String getEmail() {
        return email;
    }

    public String getCategory() {
        return category;
    }

    public double getOverallScore() {
        return avgScore;
    }

    public int getTotal() {
        return scores[0] + scores[1] + scores[2] + scores[3];
    }

    public int getMinimum() {
        int minimum = scores[0];
        for(int i=0; i<scores.length; i++) {
            if(scores[i] < minimum) {
                minimum = scores[i];
            }
        }
        return minimum;
    }

    public String getAllDetails() {
        return "Competitor Number:" + getCompNumber() + ",Competitor Name:" + getName().getFullName() + ",Country:" + getCountry() +
                ",Age:" + getAge() + ",Email:" + getEmail() + ",Level:" + getCompetitorLevel() + ",Category :" + getCategory() +
                ",Phone Number:" + getPhoneNumber() + ",Overall Score:" + getOverallScore();
    }

    public String getShortDetails() {
        return compNumber + " " + getName().getInitials() + " " + getOverallScore() + " ";
    }

    public int[] getScoreArray() {
        return scores;
    }
    public void setCompNumber(int compNumber) {
        this.compNumber = compNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Totals the Scores array and divides by the number of scores which is Array Length.
     */
    public void setAverage() {
        double sum =0;
        for(int i=0; i<scores.length; i++) {
            sum+= scores[i];
        }
        avgScore = sum/scores.length;
    }

    /**
     * Inputs the Competitors Score into the Score Array.
     * @param score = Score Value to insert into array
     * @param index = The location of the array we insert the Score in
     */
    public void setScore(int score, int index) {
        try {
            scores[index] = score;
        }
        catch (ArrayIndexOutOfBoundsException e) {
             System.out.println("Invalid Score entry");
        }
    }

    public static void main(String[] args) {
        Competitor c1 = new Competitor("Chuck", "A", "Ward", "Jamaica",
                23, "078214567", 123, "Advanced", "unk@gmail.com", "Weightlifting");
//        System.out.println(c1.getAllDetails() + "\n");
//        System.out.println(c1.getShortDetails() + "\n");
//        System.out.println(c1.getCompNumber() + "\n");
//        System.out.println(c1.getAge() + "\n");
//        c1.setScore(4, 0);
//        c1.setScore(5,1);
//        c1.setScore(3,2);
//        System.out.println(Arrays.toString(c1.getScoreArray()) + "\n");
//        System.out.println(c1.getAge() + "\n");

    }
}
