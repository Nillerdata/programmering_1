package opg_2GiftAndPackage;

public class Gift {
    private String description;
    private double price;
    private Person person;



    public Gift(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String toString(){
        return price+"";
    }
    //linkattributter------------
    public Person getPerson(){
        return person;
    }
    public void setPerson(Person person){
        if(this.person!= person){
            this.person= person;
        }
    }


}
