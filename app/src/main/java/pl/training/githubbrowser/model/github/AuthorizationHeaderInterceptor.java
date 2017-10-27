package pl.training.githubbrowser.model.github;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthorizationHeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .addHeader("Authorization", "token 2df245fcbcd9f675eea421fac74f3afac644fb7d")
                .build();
        return chain.proceed(request);
    }

}
