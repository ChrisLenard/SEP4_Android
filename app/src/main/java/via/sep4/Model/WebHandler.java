package via.sep4.Model;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import via.sep4.Model.Data.SensorData;
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

    public boolean token(User user)
    {
        String auth = user.getUsername() + ":" + user.getPassword();
        return WebClient.token(auth);
    }

    public float getCurrentSensorData(int hardwareID, String src)
    {
        final float[] ret = {0};
        Call<SensorData> call = WebClient.getHardwareAPI().getHardwareSensorData(hardwareID);
        call.enqueue(new Callback<SensorData>() {
            @Override
            public void onResponse(Call<SensorData> call, Response<SensorData> response) {
                if(response.body() != null)
                {
                    if (src.equals("co2"))
                    {
                        ret[0] = response.body().getCurrent_air_co2();
                    }
                    else if (src.equals("light")) {
                        ret[0] = response.body().getCurrent_light();
                    }
                }
            }

            @Override
            public void onFailure(Call<SensorData> call, Throwable t) {

            }
        });
        return ret[0];
    }
}
