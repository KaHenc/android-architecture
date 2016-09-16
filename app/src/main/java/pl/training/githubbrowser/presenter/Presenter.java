package pl.training.githubbrowser.presenter;

import pl.training.githubbrowser.view.MvpView;

public interface Presenter<V extends MvpView> {

    void attachView(V view);

    void detachView();

}
