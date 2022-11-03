package rocks.cleancode.hamcrest.file;

import org.hamcrest.Matcher;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Hamcrest matchers for {@link java.nio.file.Path}.
 *
 * @since 1.0.0
 */
public class PathMatchers {

    /**
     * Create a matcher for existing file.
     *
     * @return Matcher for existing file.
     *
     * @since 1.0.0
     */
    public static Matcher<Path> file() {
        return new IsFileMatcher<>(Files::isRegularFile);
    }

    /**
     * Create a matcher for existing directory.
     *
     * @return Matcher for existing directory.
     *
     * @since 1.0.0
     */
    public static Matcher<Path> directory() {
        return new IsDirectoryMatcher<>(Files::isDirectory);
    }

    private PathMatchers() {
    }

}
