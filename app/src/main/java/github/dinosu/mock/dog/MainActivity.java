package github.dinosu.mock.dog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import github.dinosu.mock.dog.view.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            HomeFragment homeFragment =
                    (HomeFragment) getSupportFragmentManager().findFragmentByTag(HomeFragment.TAG);
            if (homeFragment == null) {
                homeFragment = new HomeFragment();
            }

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.Fragment, homeFragment)
                    .commit();
        }

        setContentView(R.layout.activity_main);
    }
}
