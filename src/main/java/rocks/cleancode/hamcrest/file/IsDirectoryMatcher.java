package rocks.cleancode.hamcrest.file;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.function.Predicate;

class IsDirectoryMatcher<T> extends TypeSafeMatcher<T> {

    private final Predicate<T> predicate;

    IsDirectoryMatcher(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected final boolean matchesSafely(T item) {
        return predicate.test(item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void describeTo(Description description) {
        description.appendText("a directory");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected final void describeMismatchSafely(T item, Description mismatchDescription) {
        mismatchDescription.appendText("was not a directory");
    }

}
