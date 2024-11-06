package opg_2GiftAndPackage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private final ArrayList<Gift> gifts = new ArrayList<>();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return name;
    }




    public double valueOfGift(){
      double value = 0;
      for(int i = 0; i< gifts.size(); i++){
          value = value + gifts.get(i).getPrice();

      }
      return value;
    }
    //linkattributter---------
    public ArrayList<Gift>getGifts(){
        return new ArrayList<>();
    }
    public void addGift(Gift gift){
        if(!gifts.contains(gift)){
            gifts.add(gift);
        }
    }
    public void removeGift(Gift gift){
        if(gifts.contains(gift)){
            gifts.remove(gift);
        }
    }
    public ArrayList<Person> gaveGivere(){
        ArrayList<Person>dejligeMennesker = new ArrayList<>();
        for(Gift g : gifts){
            dejligeMennesker.add(g.getPerson());
        }
        return dejligeMennesker;
    }
    }


