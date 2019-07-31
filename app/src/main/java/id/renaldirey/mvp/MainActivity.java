package id.renaldirey.mvp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import id.renaldirey.mvp.model.Model;
import id.renaldirey.mvp.presenter.MyPresenter;
import id.renaldirey.mvp.view.DataView;

public class MainActivity extends AppCompatActivity implements DataView<Model> {

    private static final String TAG = MainActivity.class.getSimpleName();

    private MyPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MyPresenter();
    }

    @OnClick(R.id.btn)
    void clicked(){
        loadPresenter();
    }

    private void loadPresenter() {
        presenter.attachView(this);

        if(presenter.isViewAttached())
            presenter.clickedButton();
    }

    @Override
    public void showData(Model data) {
        Toast.makeText(this, "Hello "+data.getNama(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void isError(String message) {
        Log.e(TAG+".error", message);
    }
}
