package opgave_04;

public class name {
    //attributter
    private String firstName;
    private String middleName;
    private String lastName;

    //constructor
    //navne med middelnavn
    public name(String firstName,String middleName, String lastName){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
    public name(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){return this.firstName;}

    public void setMiddleName(String middleName){
        this.middleName = middleName;
    }
    public String getMiddleName(){return this.middleName;}

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){return this.lastName;}

    public String getInit(){
        char[] init = new char
    String firstname = this.firstName;
    char firstLetter = firstname.charAt(0);
    String middlename = this.middleName;
    char middleletter = middlename.charAt(0);
    char lastletter = lastName.charAt(0);

    return
    }



}
