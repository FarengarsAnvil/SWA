public class Person {

    private Name userName;
    private String country;
    private int age;
    private String phoneNumber;


    public Person(String fName, String mName, String lName, String countryName, int personAge, String phNumber) {
        userName = new Name(fName, mName, lName);
        country = countryName;
        age = personAge;
        phoneNumber = phNumber;
    }
    public Name getName() {
        return userName;
    }

    public String getFirstName() {
        return userName.getFirstName();
    }
    public String getMiddleName() {
        return userName.getMiddleName();
    }
    public String getLastName() {
        return userName.getLastName();
    }

    public String getNameAsText() {
        return userName.getFullName();
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String fName, String mName, String lName) {
        userName.setFirstName(fName);
        userName.setMiddleName(mName);
        userName.setLastName(lName);
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phNumber) {
        phoneNumber = phNumber;
    }
}



