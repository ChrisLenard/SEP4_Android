package via.sep4.Model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import via.sep4.Model.Data.Status;

public class PersistenceHandler {
    /**
     * @author Kristóf Lénárd
     * @version 1.0
     * This class is responsible for implementing the Data Access Objects, supporting the LocalPersistence.
     */

    @Dao
    public interface StatusDAO {
        @Query("SELECT * FROM status WHERE specimen_key IN (:searchKey)")
        List<Status> getAllBySpecimen(int searchKey);

        //varargs used to make sure cardinality is always appropriate
        @Insert
        void insertAll(Status... statuses);

        @Delete
        void delete(Status status);
    }
}
