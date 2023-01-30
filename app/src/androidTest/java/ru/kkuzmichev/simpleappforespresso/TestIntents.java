package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import static org.hamcrest.Matchers.allOf;

import android.content.Intent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.Intents;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;


//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

public class TestIntents {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);
//    // Для реализации проверки Intents с использованием «Правила»
//    public IntentsTestRule intentsTestRule = new IntentsTestRule(MainActivity.class);

    @Test
    public void testSettings() {
        ViewInteraction menuButton = onView(withParent(withParent(withId(R.id.toolbar))));
        menuButton.check(matches(isDisplayed()));
        menuButton.perform(click());
        ViewInteraction settings = onView(allOf(withId(androidx.appcompat.R.id.title),
                withParent(withParent(withId(androidx.appcompat.R.id.content)))));
        settings.check(matches(isDisplayed()));
        Intents.init(); // Для реализации проверки с подписыванием на Intent, перед запуском Intent
        settings.perform(click());
        intended(hasAction(Intent.ACTION_VIEW));
        intended(hasData("https://google.com"));
        Intents.release(); // Для реализации проверки с подписыванием на Intent, после запуска Intent
    }

}
