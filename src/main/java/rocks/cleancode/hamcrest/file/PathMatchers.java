package rocks.cleancode.hamcrest.file;

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
    public static IsFileMatcher<Path> file() {
        return new IsFileMatcher<>(Files::isRegularFile);
    }

    public static IsDirectoryMatcher<Path> directory() {
        return new IsDirectoryMatcher<>(Files::isDirectory);
    }

    private PathMatchers() {
    }

}
