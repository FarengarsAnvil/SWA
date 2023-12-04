import java.util.ArrayList;

public class Competition {

    private int competitionNumber;
    private String compName;
    private Staff staffMember;
    private String category;

    private ArrayList<Competitor> competitors = new ArrayList<Competitor>();

    public Competition(int cNo, String cName, String fName, String mName, String lName, String countryName,
                       int personAge, String phNumber, int staffNo, int hourlyWage, String staffRole, String category) {

        competitionNumber = cNo;
        compName = cName;
        staffMember = new Staff(fName,mName,lName,countryName,
        personAge,phNumber,staffNo,hourlyWage,staffRole);
        this.category = category;
    }

    public int getCompNumber() {
        return competitionNumber;
    }

    public String getCompName() {
        return compName;
    }

    public String getCategory() {
        return category;
    }

    public void setCompNumber(int cNo) {
       competitionNumber = cNo;
    }

    public void setCompName(String name) {
        compName = name;
    }

    public void setCategory(String cat) { category = cat;}

    /**
     * Registers a Competitor onto the competition by adding them to the competitors list.
     */
    public void registerCompetitor(String fName, String mName, String lName,
                                   String countryName, int personAge, String phNumber,
                                   int cNumber, String compLevel, String email, String cat) {
        Competitor temp = new Competitor(fName, mName, lName, countryName, personAge, phNumber, cNumber,
                compLevel, email, cat);
        competitors.add(temp);
    }

    /**
     * Removes a Competitor based on a Param comp number.
     */
    public void removeCompetitorByNumber(int num) {
        for(int i=0; i<competitors.size(); i++) {
            if(competitors.get(i).getCompNumber() == num) {
                competitors.remove(i);
            }
        }
    }

    /**
     * @return = False, if num is not a valid Comp number, True if it is.
     */
    public boolean checkCompetitorExists(int num) {
        for(int i=0; i<competitors.size();i++) {
            if(competitors.get(i).getCompNumber() ==num) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return = String of All Details of All Competitors.
     */
    public String getAllCompetitors() {
        String ret = "";
        for(int i=0; i<competitors.size();i++) {
            ret += competitors.get(i).getAllDetails() + "\n";
        }
        return ret;
    }

}
