package id.renaldirey.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainMVP.view {

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new Presenter(this);
    }

    @OnClick(R.id.btn)
    void clicked(){
        presenter.clickedButton();
    }

    @Override
    public void displayToast(Model model){
        Toast.makeText(this, "Hello "+model.getNama(), Toast.LENGTH_SHORT).show();
    }
}
