package pl.training.githubbrowser.viewmodel;

import pl.training.githubbrowser.model.github.Repository;

public class RepositoryItemViewModel {

    private long id;
    private String title;
    private String description;
    private int forks;
    private int watchers;
    private int stars;

    public RepositoryItemViewModel(Repository repository) {
        id = repository.getId();
        title = repository.getName();
        description = repository.getDescription();
        forks = repository.getForks();
        watchers = repository.getWatchers();
        stars = repository.getStars();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getForks() {
        return forks;
    }

    public int getWatchers() {
        return watchers;
    }

    public int getStars() {
        return stars;
    }

}
