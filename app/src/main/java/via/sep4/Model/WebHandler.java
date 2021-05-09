package via.sep4.Model;


import java.io.IOException;
import via.sep4.Model.Data.Specimen;
import via.sep4.Model.Data.User;
import via.sep4.Persistence.WebClient;

public class WebHandler {
    /**
     * @author Kristóf Lénárd
     * @version 1.0
     * This class connects the application data and the REST client.
     */

    public Specimen getSpecimen(int specimenKey)
    {
        Specimen s = new Specimen();
        try
        {
            s = WebClient.getSpecimenAPI().getSpecimen(specimenKey).execute().body();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
        return s;
    }

    public void token(User user)
    {
        String auth = user.getUsername() + ":" + user.getPassword();
        WebClient.token(auth);
    }
}
