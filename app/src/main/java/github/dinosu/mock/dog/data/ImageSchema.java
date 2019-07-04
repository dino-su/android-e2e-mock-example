package github.dinosu.mock.dog.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImageSchema {
    @SerializedName("message")
    public List<String> imageUrls;
}
