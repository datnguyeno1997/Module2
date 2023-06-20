package model;

public class GymPackages {
    private long id;
    private String name;
    private float price;
    private int month;
    private EPt ePt;

    public GymPackages() {
    }

    public GymPackages(long id, String name, float price, EPt ePt,int month) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ePt = ePt;
        this.month = month;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public EPt getePt() {
        return ePt;
    }

    public void setePt(EPt ePt) {
        this.ePt = ePt;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return id + "," + name + ',' + price + ',' + ePt.getName() + "," + month;

    }
}
