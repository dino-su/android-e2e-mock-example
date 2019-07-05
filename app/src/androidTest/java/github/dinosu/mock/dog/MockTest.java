package github.dinosu.mock.dog;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.AmbiguousViewMatcherException;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import github.dinosu.mock.dog.rule.MockTestRule;
import github.dinosu.mock.dog.util.Wait;
import okhttp3.mockwebserver.MockResponse;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class MockTest {
    final private BaseApplication mockApp = (BaseApplication) InstrumentationRegistry.getTargetContext().getApplicationContext();

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class, false, false);

    @Rule
    public MockTestRule mockRule = new MockTestRule();

    @Before
    public void setUpMock() {
        mockApp.setBaseUrl(mockRule.server.url("/api/").toString());
        mActivityRule.launchActivity(null);

        String body = "{\"message\":[" +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"," +
                "\"https:\\/\\/imgur.com\\/qG6YmC0.jpg\"], " +
                "\"status\":\"success\"}";
        mockRule.server.enqueue(new MockResponse().setBody(body));
    }

    @After
    public void tearDownMock() {
        mockApp.setBaseUrl(BaseApplication.API_BASE_URL);
    }

    @Test
    public void testHomeFragmentWillDisplayMockImages() {
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
