public class Sensor {
    private int id;
    private String data;
    private double aqi;

    public Sensor(int id, String data, double aqi) {
        this.id = id;
        this.data = data;
        this.aqi = aqi;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public double getAqi() {
        return aqi;
    }
}
