package rocks.cleancode.hamcrest.file;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.function.Predicate;

class IsReadableMatcher<T> extends TypeSafeMatcher<T> {

    private final Predicate<T> predicate;

    IsReadableMatcher(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    @Override
    protected boolean matchesSafely(T item) {
        return predicate.test(item);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a readable file");
    }

    @Override
    protected void describeMismatchSafely(T item, Description mismatchDescription) {
        mismatchDescription.appendText("was not readable");
    }

}
