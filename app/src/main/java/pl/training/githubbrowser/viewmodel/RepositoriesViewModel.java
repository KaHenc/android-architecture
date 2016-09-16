package pl.training.githubbrowser.viewmodel;

import java.util.ArrayList;
import java.util.List;

import pl.training.githubbrowser.model.github.GitHub;
import pl.training.githubbrowser.model.github.Repository;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RepositoriesViewModel {

    public Observable<List<RepositoryItemViewModel>> repositories = Observable.just(new ArrayList<>());

    private GitHub gitHub;

    public RepositoriesViewModel(GitHub gitHub) {
        this.gitHub = gitHub;
    }

    public void loadRepositories(String username) {
        Observable<List<Repository>> observable = gitHub.getRepositories(username)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());

        repositories = observable.flatMapIterable(list -> list)
                .map(RepositoryItemViewModel::new)
                .toList();
    }

}
