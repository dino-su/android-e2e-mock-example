package github.dinosu.mock.dog.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import github.dinosu.mock.dog.BaseApplication;
import github.dinosu.mock.dog.data.DogService;
import github.dinosu.mock.dog.data.ImageSchema;
import github.dinosu.mock.dog.data.RetrofitFactory;
import retrofit2.Call;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment {
    public static final String TAG = "DogFragment";
    private HomeView homeView;
    private DogService service;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // API
        BaseApplication app = (BaseApplication) getActivity().getApplication();
        Retrofit retrofit  = RetrofitFactory.createInstance(app.getBaseUrl());
        service = retrofit .create(DogService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        homeView = new HomeView(inflater, container);
        View rootView = homeView.getRooView();
        rootView.setTag(TAG);

        showImages();

        return rootView;
    }

    private void showImages() {
        Call<ImageSchema> images = service.getImages();
        images.enqueue(new retrofit2.Callback<ImageSchema>() {

            @Override
            public void onResponse(Call<ImageSchema> call, retrofit2.Response<ImageSchema> response) {
                if (response.code() == 200) {
                    ImageSchema responseBoy = response.body();
                    final List<String> imageUrls = responseBoy.imageUrls;

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            homeView.setData(imageUrls);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<ImageSchema> call, Throwable t) {
                homeView.snackbar(t.getMessage(), Snackbar.LENGTH_INDEFINITE);
            }
        });
    }
}
