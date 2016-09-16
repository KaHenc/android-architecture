package pl.training.githubbrowser.presenter;

import pl.training.githubbrowser.model.github.GitHub;
import pl.training.githubbrowser.view.RepositoriesView;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RepositoriesPresenter implements Presenter<RepositoriesView> {

    private GitHub gitHub;

    private RepositoriesView repositoriesView;
    private Subscription subscription;

    public RepositoriesPresenter(GitHub gitHub) {
        this.gitHub = gitHub;
    }

    public void loadRepositories(String username) {
        subscription = gitHub.getRepositories(username)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(repositories -> repositoriesView.showRepositories(repositories),
                        throwable -> repositoriesView.showError(throwable),
                        () -> repositoriesView.onLoadingCompleted());
    }


    @Override
    public void attachView(RepositoriesView view) {
        repositoriesView = view;
    }

    @Override
    public void detachView() {
        repositoriesView = null;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

}
