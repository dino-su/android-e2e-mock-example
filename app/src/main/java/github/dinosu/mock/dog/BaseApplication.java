package github.dinosu.mock.dog;

import android.app.Application;

public class BaseApplication extends Application {
    public static final String API_BASE_URL = "https://dog.ceo/api/";
    private String baseUrl = API_BASE_URL;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String url) {
        baseUrl = url;
    }
}
