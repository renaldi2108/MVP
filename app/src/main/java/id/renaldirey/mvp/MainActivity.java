package id.renaldirey.mvp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.renaldirey.mvp.adapter.DataAdapter;
import id.renaldirey.mvp.model.Model;
import id.renaldirey.mvp.presenter.MyPresenter;
import id.renaldirey.mvp.view.DataView;

public class MainActivity extends AppCompatActivity implements DataView<List<Model>> {
    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.rv_data) RecyclerView rvData;
    @BindView(R.id.pb_loading) ProgressBar pbLoading;

    private MyPresenter presenter;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new DataAdapter(this);
        rvData.setLayoutManager(new LinearLayoutManager(this));
        rvData.setAdapter(adapter);

        presenter = new MyPresenter();
        loadPresenter();
    }

    private void loadPresenter() {
        presenter.attachView(this);

        if(presenter.isViewAttached())
            presenter.getData();
    }

    @Override
    public void showData(List<Model> data) {
        adapter.addAll(data);
    }

    @Override
    public void showProgress() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void isError(String message) {
        Log.e(TAG+".error", message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
