package io.github.tonnyl.sample;

import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by lizhaotailang on 2017/5/12.
 * Test for the layout components in {@link MainActivity}.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class MainActivityUITest {

    /**
     * {@link ActivityTestRule} is a JUnit {@link Rule @Rule} to launch your activity under test.
     *
     * <p>
     * Rules are interceptors which are executed for each test method and are important building
     * blocks of Junit tests.
     */
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testSuccess() {
        onView(withId(R.id.button_success)).perform(click());
        // Check that Snackbar was displayed.
        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText("Success")))
               .check(matches(isDisplayed()));

        onView(withId(android.support.design.R.id.snackbar_action)).perform(click());
        // Check that Toast was displayed.
        onView(withText("Hello, Light!")).inRoot(withDecorView(not(mainActivityActivityTestRule.getActivity().getWindow().getDecorView())));
    }

    @Test
    public void testInfo() {
        onView(withId(R.id.button_info)).perform(click());
        // Check that Snackbar was displayed.
        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText("Info")))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testNormal() {
        onView(withId(R.id.button_normal)).perform(click());
        // Check that Snackbar was displayed.
        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText("Formatted bold italic text")))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testError() {
        onView(withId(R.id.button_error)).perform(click());
        // Check that Snackbar was displayed.
        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText("Error")))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testMakeCustom() {
        onView(withId(R.id.button_custom)).perform(click());
        // Check that Snackbar was displayed.
        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText("Awesome Snackbar")))
                .check(matches(isDisplayed()));

        onView(withId(android.support.design.R.id.snackbar_action)).perform(click());
        // Check that Toast was displayed.
        onView(withText("Hello, Light!")).inRoot(withDecorView(not(mainActivityActivityTestRule.getActivity().getWindow().getDecorView())));
    }

}
