package via.sep4;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.net.InetAddress;

import via.sep4.Model.Data.SensorDataList;
import via.sep4.Model.Data.Specimen;
import via.sep4.Model.PersistenceHandler;
import via.sep4.Model.WebHandler;

public class ViewSpecimenViewModel extends ViewModel
{
    /**
     * @author Kristóf Lénárd
     * @version 1.0
     * This class is responsible for implementing UI background code.
     */

    private PersistenceHandler persistenceHandler;
    private WebHandler webHandler;
    private int specimenKey;
    private MutableLiveData<SensorDataList> sensorLiveData;
    //TODO: visualizer, visualizer data binding

    public ViewSpecimenViewModel()
    {
        persistenceHandler = new PersistenceHandler();
        webHandler = new WebHandler();
        sensorLiveData = new MutableLiveData<>();
        specimenKey = 0;
        //TODO: write specimen key retriever
    }

    public MutableLiveData<SensorDataList> getSensorLiveData() {
        return sensorLiveData;
    }

    /*private void setSensorLiveData()
    {
        sensorLiveData.setValue(getSensorData());
    }*/

    private void addSensorLiveData()
    {

    }

    public Specimen getSpecimen()
    {
        //TODO: write internet checker
        return webHandler.getSpecimen(specimenKey);
    }

    public SensorDataList getLocalSensorData()
    {
        return persistenceHandler.getAllSensorData(specimenKey);
    }

}
