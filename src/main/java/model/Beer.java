package model;

/**
 * Created by IntelliJ IDEA.
 * User: vulp
 * Date: 1/6/13
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Beer {
    public String Name;
    private double price;
    private double percent;


    public Beer() {

    }

    public Beer(String name, double price, double percent) {
        this.Name = name;
        this.price = price;
        this.percent = percent;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
