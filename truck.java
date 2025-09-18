package alfertramos;

class Truck {
    String plate;
    String driver;
// setter
    Truck(String plate, String driver) {
        this.plate = plate;
        this.driver = driver;
    }
//getter
    public String toString() {
        return plate + " | " + driver;
    }
}
