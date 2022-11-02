package rocks.cleancode.hamcrest.file;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.function.Predicate;

/**
 * Abstract matcher for file.
 *
 * @param <T> Type representing a file
 *
 * @since 1.0.0
 */
public abstract class AbstractIsFileMatcher<T> extends TypeSafeMatcher<T> {

    private final Predicate<T> predicate;

    /**
     * Default constructor with predicate to check file existence.
     *
     * @param predicate Predicate to check file existence
     *
     * @since 1.0.0
     */
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