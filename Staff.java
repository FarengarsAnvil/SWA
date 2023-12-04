
public class Staff extends Person{

    private int staffNo;
    private int hourlyWage;
    private String role;

    public Staff(String fName, String mName, String lName, String countryName, int personAge, String phNumber, int staffNo, int hourlyWage, String staffRole) {
        super(fName, mName, lName, countryName, personAge, phNumber);
        this.staffNo = staffNo;
        this.hourlyWage = hourlyWage;
        role = staffRole;
    }

    public int getStaffNum() {
        return staffNo;
    }

    public int getHourlyWage() {
        return hourlyWage;
    }

    public String getRole() {
        return role;
    }

    public void setStaffNum(int num) {
        staffNo = num;
    }

    public void setHourly(int num) {
        hourlyWage = num;
    }

    public void setRole(String roles) {
        role = roles;
    }

    
}