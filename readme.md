# Android applications architecture 

Article: [Android applications architecture](https://medium.com/@landrzejewski.poczta/android-application-architecture-fd0a07fd6bbf#.h3hv7is4v)

Example demonstrates three different approaches to the implementation of the Android applications.

    * Master branch - traditional approach, the application is divided into the view layer and a model
    * MVP branch - Model View Presenter
    * MVVM branch - Model View ViewModel

## Sample application

Displays a list of GitHub repositories for a given username. 

## Requirements

    * SDK version 24 (uses Jack and Jill tool chain and Java 8 features)
    * GitHub token (replace *** in AuthorizationHeaderInterceptor with your GitHub Personal access token)
