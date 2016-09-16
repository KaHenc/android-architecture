package pl.training.githubbrowser.view;

import java.util.List;

import pl.training.githubbrowser.model.github.Repository;

public interface RepositoriesView extends MvpView {

    void showRepositories(List<Repository> repositories);

    void showError(Throwable throwable);

    void onLoadingCompleted();

}
