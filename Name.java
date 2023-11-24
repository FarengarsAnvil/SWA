public class Name {

    private String firstName;
    private String middleName;
    private String lastName;


    /**
     * Constructor Method assigns Values to Fields.
     * @param fName = String of First Name
     * @param midName = String of Middle Name
     * @param lName = String of Last Name
     */
    public Name(String fName, String midName, String lName) {
        firstName = fName;
        middleName = midName;
        lastName = lName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLastName() {
        return lastName;
    }

    public String getFullName() {

        return firstName + " " + middleName + " " + lastName;
    }

    public String getInitials() {

        char first = firstName.charAt(0);
        char sec   = middleName.charAt(0);
        char last  =  lastName.charAt(0);
        String s =String.valueOf(first) + String.valueOf(sec) + String.valueOf(last);
        return s;

    }
    public void setFirstName(String fName) {
        firstName = fName;
    }
    public void setMiddleName(String midName) {
        middleName = midName;
    }

    public void  setLastName(String lName) {
        lastName = lName;
    }

}


