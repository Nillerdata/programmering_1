package opg_2GiftAndPackage;

public class SantaClausApp {
    public static void main(String[] args) {
        Person p1 = new Person("Niels",24);
        Person p2 = new Person("BOb",30);
        Gift g1 = new Gift("FucktonOfMoney");
        Gift g2 = new Gift("HelloMario");
        Gift g3 = new Gift("OPSDJG");
        g2.setPrice(10000);
        g3.setPrice(29348);
        g1.setPrice(20000);
        g1.setPerson(p1);
        g2.setPerson(p1);
        g3.setPerson(p2);
        p1.addGift(g1);
        p2.addGift(g3);


        ;
        System.out.println(g1.getPerson()+"");
            System.out.println(p1.valueOfGift());

        System.out.println(p1.gaveGivere());

        }
    }


