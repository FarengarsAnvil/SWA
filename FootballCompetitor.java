public class FootballCompetitor extends Competitor{

    private String team;
    private String position;
    private int shirtNum;
    private int division;

    public FootballCompetitor(String fName, String mName, String lName, String countryName, int personAge, String phNumber,
                              int cNumber, String compLevel, String email, String cat) {
        super(fName, mName, lName, countryName, personAge, phNumber, cNumber, compLevel, email, cat);
    }

    public String getTeam() {
        return team;
    }
    public String getPosition() {
        return position;
    }
    public int getShirtNum() {
        return shirtNum;
    }
    public int getDivision() {
        return division;
    }

    public void setTeam(String t) {
        team = t;
    }
    public void setPosition(String pos) {
        position = pos;
    }

    public void setShirtNum(int no) {
        shirtNum = no;
    }

    public void setDivision(int n) {
        division = n;
    }

    @Override
    public String getAllDetails() {
        return "Competitor Number:" + getCompNumber() + ",Competitor Name:" + getName().getFullName() + ",Country:" + getCountry() +
                ",Age:" + getAge() + ",Email:" + getEmail() + ",Level:" + getCompetitorLevel() + ",Category :" + getCategory() +
                ",Phone Number:" + getPhoneNumber() + ",Overall Score:" + getOverallScore() + " Team:" + getTeam() +
                " Position:" + getPosition() + " Shirt Number:" + getShirtNum() + " Division:" + getDivision();

    }
}
