package Classes;

public class Chocolate {

    String name;
    int theobromidePerOz;
    int caffeinePerOz;

    public Chocolate(){}

    public Chocolate(String name, int theobromidePerOz, int caffeinePerOz) {
        this.name = name;
        this.theobromidePerOz = theobromidePerOz;
        this.caffeinePerOz = caffeinePerOz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTheobromidePerOz() {
        return theobromidePerOz;
    }

    public void setTheobromidePerOz(int theobromidePerOz) {
        this.theobromidePerOz = theobromidePerOz;
    }

    public int getCaffeinePerOz() {
        return caffeinePerOz;
    }

    public void setCaffeinePerOz(int caffeinePerOz) {
        this.caffeinePerOz = caffeinePerOz;
    }
}
