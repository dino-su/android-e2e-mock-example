package github.dinosu.mock.dog;

import android.support.test.espresso.AmbiguousViewMatcherException;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import github.dinosu.mock.dog.util.Wait;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class AcceptanceTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testHomeFragmentWillDisplayImages() {
        Wait imagesDisplayed = new Wait() {
            @Override
            public Boolean apply() {
                Boolean isComplete = true;

                try {
                    onView(withId(R.id.image)).check(matches(isDisplayed()));
                } catch (NoMatchingViewException e) {
                    isComplete = false;
                } catch (AmbiguousViewMatcherException e) {
                    isComplete = true;
                }

                return isComplete;
            }
        };
        assertTrue(Wait.until(imagesDisplayed));
    }
}
