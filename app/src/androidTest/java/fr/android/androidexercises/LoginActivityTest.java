package fr.android.androidexercises;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void shouldTryLoginAndSuccess() throws Exception {
        Espresso.onView(ViewMatchers.withId(R.id.usernameEdit)).perform(ViewActions.typeText("john"));
        Espresso.onView(ViewMatchers.withId(R.id.passwordEdit)).perform(ViewActions.typeText("password"),
                ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.loginButton)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.loggedText)).check(matches(isDisplayed()));

    }
}