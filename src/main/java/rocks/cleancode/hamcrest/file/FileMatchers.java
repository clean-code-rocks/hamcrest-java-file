package rocks.cleancode.hamcrest.file;

import org.hamcrest.Matcher;

import java.io.File;

/**
 * Hamcrest matchers for {@link java.io.File}.
 *
 * @since 1.0.0
 */
public class FileMatchers {

    /**
     * Create a matcher for existing file.
     *
     * @return Matcher for existing file.
     *
     * @since 1.0.0
     */
    public static Matcher<File> file() {
        return new IsFileMatcher<>(File::isFile);
    }

    /**
     * Create a matcher for existing directory.
     *
     * @return Matcher for existing directory.
     *
     * @since 1.0.0
     */
    public static Matcher<File> directory() {
        return new IsDirectoryMatcher<>(File::isDirectory);
    }

    private FileMatchers() {
    }

}
