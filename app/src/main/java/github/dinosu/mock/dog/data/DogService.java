package github.dinosu.mock.dog.data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DogService {
    @GET("breeds/image/random/50")
    Call<ImageSchema> getImages();
}
