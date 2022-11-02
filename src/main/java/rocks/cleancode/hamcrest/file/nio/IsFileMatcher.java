package rocks.cleancode.hamcrest.file.nio;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Matches a file.
 *
 * @since 1.0.0
 */
public class IsFileMatcher extends TypeSafeMatcher<Path> {

    /**
     * Create a matcher for an existing file.
     *
     * @return Existing file matcher
     *
     * @since 1.0.0
     */
    public static Matcher<Path> file() {
        return new IsFileMatcher();
    }

    private IsFileMatcher() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean matchesSafely(Path path) {
        return Files.isRegularFile(path);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void describeTo(Description description) {
        description.appendText("a file");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void describeMismatchSafely(Path path, Description mismatchDescription) {
        mismatchDescription.appendText("was not a file");
    }

}
