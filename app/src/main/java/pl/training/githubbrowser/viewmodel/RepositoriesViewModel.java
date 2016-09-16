package pl.training.githubbrowser.viewmodel;

import java.util.List;

import pl.training.githubbrowser.model.github.GitHub;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

public class RepositoriesViewModel {

    public PublishSubject<List<RepositoryItemViewModel>> repositoriesStream = PublishSubject.create();

    private GitHub gitHub;

    public RepositoriesViewModel(GitHub gitHub) {
        this.gitHub = gitHub;
    }

    public void loadRepositories(String username) {
        gitHub.getRepositories(username)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .flatMapIterable(list -> list)
                .map(RepositoryItemViewModel::new)
                .toList()
                .subscribe(repositoriesStream::onNext, repositoriesStream::onError);
    }

}
