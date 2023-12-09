public class MMACompetitor extends Competitor{

    private int weightClass;
    private int height;
    private String bjjColour;
    private String gym;
    private String discipline;

    public MMACompetitor(String fName, String mName, String lName, String countryName, int personAge,
                         String phNumber, int cNumber, String compLevel, String email, String cat,
                         int weightClass, int height, String bjjColour, String gym, String discipline) {
        super(fName, mName, lName, countryName, personAge, phNumber, cNumber, compLevel, email, cat);
        this.weightClass = weightClass;
        this.height = height;
        this.bjjColour = bjjColour;
        this.gym = gym;
        this.discipline = discipline;
    }

    public int getWeight() { return weightClass;}
    public int getHeight() { return height;}
    public String getBJJ() { return bjjColour;}
    public String getGym() { return gym;}
    public String getDiscipline() { return discipline;}

    public void setWeight(int x) {
        weightClass = x;
    }

    public void setHeight(int y) {
        height =  y;
    }

    public void setBjjColour(String clr) {
        bjjColour = clr;
    }

    public void setGym(String g) {
        gym = g;
    }

    public void setDiscipline(String dis) {
        discipline = dis;
    }
}
