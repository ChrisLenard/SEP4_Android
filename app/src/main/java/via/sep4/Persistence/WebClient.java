package via.sep4.Persistence;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebClient {
    /**
     * @author Kristóf Lénárd
     * @version 1.0
     * This class is responsible for implementing the Retrofit library, enabling connections to the webservice.
     */

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://app.swaggerhub.com/apis-docs/C4T4PHR4CT/SEP4")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static SpecimenAPI specimenAPI = retrofit.create(SpecimenAPI.class);

    public static SpecimenAPI getSpecimenAPI()
    {
        return specimenAPI;
    }

    public static UserAPI getUserAPI() {
        return userAPI;
    }

    public static HardwareAPI getHardwareAPI() {
        return hardwareAPI;
    }

    public static StatusAPI getStatusAPI() {
        return statusAPI;
    }

    public static MiscAPI getMiscAPI() {
        return miscAPI;
    }

    public static boolean token(String auth)
    {
        final boolean[] ret = {false};
        Call<String> tokenCall = getMiscAPI().getToken(auth);
        tokenCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.body() != null) {
                    tempJWT = response.body();
                }
                specimenAPI = createService(SpecimenAPI.class, tempJWT);
                userAPI = createService(UserAPI.class, tempJWT);
                hardwareAPI = createService(HardwareAPI.class, tempJWT);
                statusAPI = createService(StatusAPI.class, tempJWT);
                ret[0] = true;
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
        return ret[0];
    }
}
