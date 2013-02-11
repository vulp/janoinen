package Beer;

/**
 * Created by IntelliJ IDEA.
 * User: vulp
 * Date: 1/6/13
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */
//@Entity
//@Table
public class Beer {
    private String name;
    private double price;
    private double percent;
    private String description;

    public Beer() {

    }

    public Beer(String name, double price, double percent, String description) {
        this.name = name;
        this.price = price;
        this.percent = percent;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
