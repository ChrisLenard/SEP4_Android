package via.sep4.Model.Data;

import java.util.ArrayList;

//unknown - use singleton? would need to look into better alternatives
public class SensorDataList
{
    /**
     * @author Kristóf Lénárd
     * @version 1.0
     * This class is a list class for all sensor data associated with a given specimen.
     */

    private ArrayList<Specimen> sensorData;

    public SensorDataList()
    {
        sensorData = new ArrayList<Specimen>();
        //when needed, write retrieval methods - from webservice or local persistence
    }

    public ArrayList<Specimen> getList()
    {
        return sensorData;
    }

    public void addToList(Specimen s)
    {
        sensorData.add(s);
    }
}
