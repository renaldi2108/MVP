package id.renaldirey.mvp.presenter;

import java.util.List;

import id.renaldirey.mvp.model.Model;
import id.renaldirey.mvp.network.ServiceGenerator;
import id.renaldirey.mvp.network.service.MyService;
import id.renaldirey.mvp.view.DataView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPresenter implements BasePresenter<DataView> {

    private DataView view;
    private MyService service;

    public MyPresenter() {
    }

    @Override
    public void attachView(DataView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public boolean isViewAttached() {
        return this.view!=null;
    }

    public void getData() {
        view.showProgress();
        service = ServiceGenerator.createBaseService(view.getContext(), MyService.class);

        Call<List<Model>> call = service.callData();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                view.hideProgress();
                if (response.code() == 200)
                    view.showData(response.body());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                view.hideProgress();
                view.isError(t.toString());
            }
        });
    }
}
