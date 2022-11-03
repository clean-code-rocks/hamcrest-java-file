package rocks.cleancode.hamcrest.file;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.function.Predicate;

class PredicateMatcher<T> extends TypeSafeMatcher<T> {

    private final Predicate<T> predicate;

    private final String describeText;

    private final String mismatchText;

    PredicateMatcher(Predicate<T> predicate, String describeText, String mismatchText) {
        this.predicate = predicate;
        this.describeText = describeText;
        this.mismatchText = mismatchText;
    }

    @Override
    protected boolean matchesSafely(T item) {
        return predicate.test(item);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(describeText);
    }

    @Override
    protected final void describeMismatchSafely(T item, Description mismatchDescription) {
        mismatchDescription.appendText(mismatchText);
    }

}
