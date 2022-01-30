package Example;

public class Car {
    private String brand;
    private String color;
    private int year;

    public Car (){

    }

    public Car(String brand, String color, Integer year) {
        this.brand = brand;
        this.color = color;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String StringOf (){
        return "Brand: " + getBrand() +  "Color: " + getColor();
    }
}
