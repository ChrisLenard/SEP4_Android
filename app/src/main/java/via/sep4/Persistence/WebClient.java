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
}
