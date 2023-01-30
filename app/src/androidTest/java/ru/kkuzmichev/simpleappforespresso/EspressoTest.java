package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;

//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
public class EspressoTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void shouldCheckMainActivityText() {
        ViewInteraction mainText = onView(withId(R.id.text_home));
        mainText.check(matches(isDisplayed()));
        mainText.check(matches(withText("This is home fragment")));
    }

    @Test
    public void shouldCheckNavMenu() {
        ViewInteraction appCompatImageButton = onView(withContentDescription("Open navigation drawer"));
        appCompatImageButton.perform(click());

        ViewInteraction navigationMenuHomeView = onView(withId(R.id.nav_home));
        navigationMenuHomeView.check(matches(isDisplayed()));

        ViewInteraction navigationMenuGalleryView = onView(withId(R.id.nav_gallery));
        navigationMenuGalleryView.check(matches(isDisplayed()));

        ViewInteraction navigationMenuSlideshowView = onView(withId(R.id.nav_slideshow));
        navigationMenuSlideshowView.check(matches(isDisplayed()));
    }

    @Test
    public void shouldCheckSlideshowActivityText() {
        ViewInteraction appCompatImageButton = onView(withContentDescription("Open navigation drawer"));
        appCompatImageButton.perform(click());

        ViewInteraction navigationMenuItemView = onView(withId(R.id.nav_slideshow));
        navigationMenuItemView.check(matches(isDisplayed()));
        navigationMenuItemView.perform(click());

        ViewInteraction textView = onView(withId(R.id.text_slideshow));
        textView.check(matches(withText("This is slideshow fragment")));
    }
}
