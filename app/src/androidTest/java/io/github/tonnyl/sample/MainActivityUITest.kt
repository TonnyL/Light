package io.github.tonnyl.sample

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.RootMatchers.withDecorView
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.SmallTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import org.hamcrest.Matchers.not
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by lizhaotailang on 2017/5/12.
 *
 * Test for the layout components in [MainActivity].
 */

@RunWith(AndroidJUnit4::class)
@SmallTest
class MainActivityUITest {

    /**
     * [ActivityTestRule] is a JUnit [@Rule][Rule] to launch your activity under test.
     * Rules are interceptors which are executed for each test method and are important building
     * blocks of Junit tests.
     */
    @Rule
    var mainActivityActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testSuccess() {
        onView(withId(R.id.button_success)).perform(click())
        // Check that Snackbar was displayed.
        onView(allOf<View>(withId(android.support.design.R.id.snackbar_text), withText("Success")))
                .check(matches(isDisplayed()))

        onView(withId(android.support.design.R.id.snackbar_action)).perform(click())
        // Check that Toast was displayed.
        onView(withText("Hello, Light!")).inRoot(withDecorView(not<View>(mainActivityActivityTestRule.activity.window.decorView)))
    }

    @Test
    fun testInfo() {
        onView(withId(R.id.button_info)).perform(click())
        // Check that Snackbar was displayed.
        onView(allOf<View>(withId(android.support.design.R.id.snackbar_text), withText("Info")))
                .check(matches(isDisplayed()))
    }

    @Test
    fun testNormal() {
        onView(withId(R.id.button_normal)).perform(click())
        // Check that Snackbar was displayed.
        onView(allOf<View>(withId(android.support.design.R.id.snackbar_text), withText("Formatted bold italic text")))
                .check(matches(isDisplayed()))
    }

    @Test
    fun testError() {
        onView(withId(R.id.button_error)).perform(click())
        // Check that Snackbar was displayed.
        onView(allOf<View>(withId(android.support.design.R.id.snackbar_text), withText("Error")))
                .check(matches(isDisplayed()))
    }

    @Test
    fun testMakeCustom() {
        onView(withId(R.id.button_custom)).perform(click())
        // Check that Snackbar was displayed.
        onView(allOf<View>(withId(android.support.design.R.id.snackbar_text), withText("Awesome Snackbar")))
                .check(matches(isDisplayed()))

        onView(withId(android.support.design.R.id.snackbar_action)).perform(click())
        // Check that Toast was displayed.
        onView(withText("Hello, Light!")).inRoot(withDecorView(not<View>(mainActivityActivityTestRule.activity.window.decorView)))
    }

}
