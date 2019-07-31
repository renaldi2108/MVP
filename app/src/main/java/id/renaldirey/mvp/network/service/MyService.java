package id.renaldirey.mvp.network.service;

import java.util.List;

import id.renaldirey.mvp.model.Model;
import id.renaldirey.mvp.network.Endpoint;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MyService {
    @GET(Endpoint.API_POST_DATA)
    Call<List<Model>> callData();
}
