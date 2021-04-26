package via.sep4.Persistence;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebClient {
    /**
     * @author Kristóf Lénárd
     * @version 1.0
     * This class is responsible for implementing the Retrofit library, enabling connections to the webservice.
     */

    //URL for connection
    private static final String BASE_URL = "https://app.swaggerhub.com/apis-docs/C4T4PHR4CT/SEP4";

    private static final Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static final OkHttpClient.Builder httpClient
            = new OkHttpClient.Builder();

    private static final HttpLoggingInterceptor logging
            = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    private static final String tempJWT = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJrZXkiOiIxIiwibmJmIjoxNjE3ODA5MDk4LCJleHAiOjE4OTM0NTI0MDAsImlhdCI6MTYxNzgwOTA5OH0.YHBQxZOg73Vmm3n6iKH7Ew4rJ9t0Q7VUakFriTsdpig";

    private static final SpecimenAPI specimenAPI = createService(SpecimenAPI.class, tempJWT);
    private static final UserAPI userAPI = createService(UserAPI.class, tempJWT);
    private static final HardwareAPI hardwareAPI = createService(HardwareAPI.class, tempJWT);
    private static final StatusAPI statusAPI = createService(StatusAPI.class, tempJWT);

    public static <S> S createService(Class<S> serviceClass) {
        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging);
            retrofitBuilder.client(httpClient.build());
            retrofit = retrofitBuilder.build();
        }
        return retrofit.create(serviceClass);
    }

    public static <S> S createService(Class<S> serviceClass, final String token) {
        if (token != null) {
            httpClient.interceptors().clear();
            httpClient.addInterceptor( chain -> {
                Request original = chain.request();
                Request.Builder builder1 = original.newBuilder()
                        .header("Authorization", token);
                Request request = builder1.build();
                return chain.proceed(request);
            });
            httpClient.addInterceptor(logging);
            retrofitBuilder.client(httpClient.build());
            retrofit = retrofitBuilder.build();
        }
        return retrofit.create(serviceClass);
    }

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
}
