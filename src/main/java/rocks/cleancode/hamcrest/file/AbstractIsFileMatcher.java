package rocks.cleancode.hamcrest.file;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.function.Predicate;

public abstract class AbstractIsFileMatcher<T> extends TypeSafeMatcher<T> {

    private Predicate<T> predicate;

    protected AbstractIsFileMatcher(Predicate<T> predicate) {
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
        description.appendText("a file");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected final void describeMismatchSafely(T item, Description mismatchDescription) {
        mismatchDescription.appendText("was not a file");
    }

}
