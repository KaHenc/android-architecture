package pl.training.githubbrowser.model.di;

import dagger.Module;
import dagger.Provides;
import pl.training.githubbrowser.model.github.GitHub;
import pl.training.githubbrowser.presenter.RepositoriesPresenter;

@Module
public class PresenterModule {

    @Provides
    RepositoriesPresenter repositoriesPresenter(GitHub gitHub) {
        return new RepositoriesPresenter(gitHub);
    }

}
