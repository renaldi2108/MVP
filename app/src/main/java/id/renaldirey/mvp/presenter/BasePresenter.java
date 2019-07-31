package id.renaldirey.mvp.presenter;

import id.renaldirey.mvp.view.BaseView;

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);
    void detachView();
    boolean isViewAttached();
}
