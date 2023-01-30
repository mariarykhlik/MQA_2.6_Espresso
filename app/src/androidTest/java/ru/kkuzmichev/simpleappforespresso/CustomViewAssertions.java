package ru.kkuzmichev.simpleappforespresso;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.ViewAssertion;

public class CustomViewAssertions {
    public static ViewAssertion isRecyclerView() {
        return (view, noViewFoundException) -> {
            if (!(view instanceof RecyclerView))
                throw new IllegalStateException("This is not a RecyclerView");
//            try {
//                RecyclerView recyclerView = (RecyclerView) view;
//            } catch (ClassCastException e) {
//                throw new IllegalStateException("This is not a RecyclerView");
//            }
        };
    }
}
