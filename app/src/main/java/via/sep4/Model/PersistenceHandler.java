package via.sep4.Model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import via.sep4.Model.Data.Hardware;
import via.sep4.Model.Data.SensorData;
import via.sep4.Model.Data.SensorDataList;
import via.sep4.Model.Data.Specimen;
import via.sep4.Model.Data.Status;

public class PersistenceHandler {

    /**
     * @author Kristóf Lénárd
     * @version 1.0
     * This class is responsible for implementing the Data Access Objects, supporting the LocalPersistence.
     */

    @Dao
    public interface StatusDAO {
        @Query("SELECT * FROM status WHERE specimen_key = (:specimenKey)")
        List<Status> getAllBySpecimen(int specimenKey);

        //varargs used to make sure cardinality is always appropriate
        @Insert
        void insertAll(Status... statuses);

        @Delete
        void delete(Status status);
    }

    @Dao
    public interface HardwareDAO {
        @Query("SELECT * FROM hardware WHERE hardware_key = (:hardwareKey)")
        Hardware getHardware(int hardwareKey);

        @Insert
        void insertAll(Hardware... hardwares);

        @Delete
        void delete(Hardware hardware);
    }

    @Dao
    public interface SpecimenDAO {
        @Query("SELECT * FROM specimen WHERE specimen_key = (:specimenKey)")
        Specimen getSpecimen(int specimenKey);

        @Query("SELECT * FROM sensordata WHERE specimenKey = (:specimenKey1)")
        List<SensorData> getSensorDataBySpecimen(int specimenKey1);

        @Insert
        void insertAll(Specimen... specimens);

        @Delete
        void delete(Specimen specimen);
    }
}
