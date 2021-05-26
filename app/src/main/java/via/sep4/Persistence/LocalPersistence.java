package via.sep4.Persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.time.LocalDateTime;

import via.sep4.Model.Data.Hardware;
import via.sep4.Model.Data.SensorData;
import via.sep4.Model.Data.Specimen;
import via.sep4.Model.Data.Status;
import via.sep4.Model.Data.User;
import via.sep4.Model.PersistenceHandler;

public class LocalPersistence { //implements Room Library, provides database access
    /**
     * @author Kristóf Lénárd
     * @version 1.0
     * This class is responsible for implementing the Room library, enabling connections to the local SQLite database.
     */

    private static AppDatabase database;

    private LocalPersistence() {

    }

    public static AppDatabase getDatabaseInstance(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context, AppDatabase.class, "MushroomDatabase").build();
        }
        return database;
    }
}
