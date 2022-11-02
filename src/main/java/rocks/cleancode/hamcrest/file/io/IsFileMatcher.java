package rocks.cleancode.hamcrest.file.io;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.io.File;

/**
 * Matches a file.
 *
 * @since 1.0.0
 */
public class IsFileMatcher extends TypeSafeMatcher<File> {

    /**
     * Create a matcher for an existing file.
     *
     * @return Existing file matcher
     *
     * @since 1.0.0
     */
    public static Matcher<File> file() {
        return new IsFileMatcher();
    }

    private IsFileMatcher() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean matchesSafely(File file) {
        return file.isFile();
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
    protected void describeMismatchSafely(File file, Description mismatchDescription) {
        mismatchDescription.appendText("was not a file");
    }

}
