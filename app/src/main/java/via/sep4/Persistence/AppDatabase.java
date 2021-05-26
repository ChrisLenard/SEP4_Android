package via.sep4.Persistence;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import via.sep4.Model.Data.Hardware;
import via.sep4.Model.Data.SensorData;
import via.sep4.Model.Data.Specimen;
import via.sep4.Model.Data.Status;
import via.sep4.Model.PersistenceHandler;

@Database(entities = {Specimen.class, SensorData.class, Hardware.class, Status.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersistenceHandler.StatusDAO statusDAO();
    public abstract PersistenceHandler.HardwareDAO hardwareDAO();
    public abstract PersistenceHandler.SpecimenDAO specimenDAO();
}
