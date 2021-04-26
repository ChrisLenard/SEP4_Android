package via.sep4.Model.Data;

public class Status {
    private int entry_key;
    private double entry_time; // This is double due to int max size - Swagger provides higher value than max int can hold
    private String stage_name;
    private int specimen_key;

    public int getEntry_key() {
        return entry_key;
    }

    public void setEntry_key(int entry_key) {
        this.entry_key = entry_key;
    }

    public double getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(double entry_time) {
        this.entry_time = entry_time;
    }

    public String getStage_name() {
        return stage_name;
    }

    public void setStage_name(String stage_name) {
        this.stage_name = stage_name;
    }

    public int getSpecimen_key() {
        return specimen_key;
    }

    public void setSpecimen_key(int specimen_key) {
        this.specimen_key = specimen_key;
    }
}
