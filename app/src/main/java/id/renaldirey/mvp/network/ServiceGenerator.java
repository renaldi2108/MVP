package id.renaldirey.mvp.network;

import android.content.Context;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import id.renaldirey.mvp.BuildConfig;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static OkHttpClient.Builder builder() {
        OkHttpClient.Builder okhttpBuilder = new OkHttpClient().newBuilder();
        okhttpBuilder.connectTimeout(60, TimeUnit.SECONDS);
        okhttpBuilder.writeTimeout(60, TimeUnit.SECONDS);
        okhttpBuilder.readTimeout(60, TimeUnit.SECONDS);

        return okhttpBuilder;
    }

    private static HttpLoggingInterceptor interceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return interceptor;
    }

    public static <S> S createBaseService(Context context, Class<S> serviceClass) {
        OkHttpClient.Builder okhttpBuilder = builder();

        if (BuildConfig.DEBUG) {
            okhttpBuilder.addInterceptor(interceptor());
        }

        okhttpBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request newReq = request.newBuilder()
                        .header("Accept", "application/json")
                        .build();
                return chain.proceed(newReq);
            }
        });

        OkHttpClient client = okhttpBuilder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Endpoint.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(serviceClass);
    }
}
