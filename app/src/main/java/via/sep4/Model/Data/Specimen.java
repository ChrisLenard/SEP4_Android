package via.sep4.Model.Data;

public class Specimen {
    private int specimen_key;
    private double planted_date; // This is double due to int max size - Swagger provides higher value than max int can hold
    private String specimen_name;
    private String specimen_type;
    private String specimen_description;
    private float desired_air_temperature;
    private float desired_air_humidity;
    private float desired_air_co2;
    private int hardware_id;
    private SensorData currentData;

    public int getSpecimen_key() {
        return specimen_key;
    }

    public void setSpecimen_key(int specimen_key) {
        this.specimen_key = specimen_key;
    }

    public double getPlanted_date() {
        return planted_date;
    }

    public void setPlanted_date(double planted_date) {
        this.planted_date = planted_date;
    }

    public String getSpecimen_name() {
        return specimen_name;
    }

    public void setSpecimen_name(String specimen_name) {
        this.specimen_name = specimen_name;
    }

    public String getSpecimen_type() {
        return specimen_type;
    }

    public void setSpecimen_type(String specimen_type) {
        this.specimen_type = specimen_type;
    }

    public String getSpecimen_description() {
        return specimen_description;
    }

    public void setSpecimen_description(String specimen_description) {
        this.specimen_description = specimen_description;
    }

    public float getDesired_air_temperature() {
        return desired_air_temperature;
    }

    public void setDesired_air_temperature(float desired_air_temperature) {
        this.desired_air_temperature = desired_air_temperature;
    }

    public float getDesired_air_humidity() {
        return desired_air_humidity;
    }

    public void setDesired_air_humidity(float desired_air_humidity) {
        this.desired_air_humidity = desired_air_humidity;
    }

    public float getDesired_air_co2() {
        return desired_air_co2;
    }

    public void setDesired_air_co2(float desired_air_co2) {
        this.desired_air_co2 = desired_air_co2;
    }

    public int getHardware_id() {
        return hardware_id;
    }

    public void setHardware_id(int hardware_id) {
        this.hardware_id = hardware_id;
    }

    public SensorData getCurrentData() {
        return currentData;
    }

    public void setCurrentData(SensorData currentData) {
        this.currentData = currentData;
    }
}
