package via.sep4.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = Specimen.class,
        parentColumns = "specimen_key",
        childColumns = "specimenKey"
)})
public class SensorData {

    /**
     * @author Kristóf Lénárd
     * @version 1.0
     * This class stores all saved sensor data at a given timestamp.
     */

    @PrimaryKey
    private int key;

    private long time; //long needed due to unix time (stored in 64-bit format)
    private float current_air_temperature;
    private float current_air_humidity;
    private float current_air_co2;
    private float current_light;
    private float desired_air_temperature;
    private float desired_air_humidity;
    private float desired_air_co2;
    private float desired_light;
    private int specimenKey;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public float getCurrent_air_temperature() {
        return current_air_temperature;
    }

    public void setCurrent_air_temperature(float current_air_temperature) {
        this.current_air_temperature = current_air_temperature;
    }

    public float getCurrent_air_humidity() {
        return current_air_humidity;
    }

    public void setCurrent_air_humidity(float current_air_humidity) {
        this.current_air_humidity = current_air_humidity;
    }

    public float getCurrent_air_co2() {
        return current_air_co2;
    }

    public void setCurrent_air_co2(float current_air_co2) {
        this.current_air_co2 = current_air_co2;
    }

    public float getCurrent_light() {
        return current_light;
    }

    public void setCurrent_light(float current_light) {
        this.current_light = current_light;
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

    public float getDesired_light() {
        return desired_light;
    }

    public void setDesired_light(float desired_light) {
        this.desired_light = desired_light;
    }

    public int getSpecimenKey() {
        return specimenKey;
    }

    public void setSpecimenKey(int specimenKey) {
        this.specimenKey = specimenKey;
    }
}
