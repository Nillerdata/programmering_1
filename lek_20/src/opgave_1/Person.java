package opgave_1;

public class Person {
    private String name;
    private String title;
    private boolean senior;
    public Person(String name,String title, boolean senior) {
        this.name = name;
        this.title = title;
        this.senior = senior;
    }
    public String toString() {
        String s = name +" " + title;
        if (senior) s = s + " (senior)";
        return s;
    }

    public String getName() {
        return name;
    }

    public boolean isSenior() {
        return senior;
    }
}
