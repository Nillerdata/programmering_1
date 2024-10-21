package opg_9_8;

public class fan {
    //konstanter
    final static int SLOW = 1;
    final static int MEDIUM = 2;
    final static int FAST = 3;
    //data field attributter
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public fan() {
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public boolean getOn() {
        return this.on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public String toString() {
        if (on = true) {
            return "fan speed is :" + speed + "\nthe fans color is : " + color + "\n radius is : " + radius;
        } else {
            return "the fan is off" + "\nthe fans color is : " + color + "\n radius is : " + radius;
        }


    }
}
