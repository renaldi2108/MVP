package id.renaldirey.mvp.presenter;

import id.renaldirey.mvp.model.Model;
import id.renaldirey.mvp.view.DataView;

public class MyPresenter implements BasePresenter<DataView> {

    DataView view;

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

    public void clickedButton() {
        view.showData(new Model("Renaldi", "Male", 20));
    }
}
