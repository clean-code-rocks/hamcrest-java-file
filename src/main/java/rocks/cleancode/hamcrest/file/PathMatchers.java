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
        return Matchers.file(Files::isRegularFile);
    }

    /**
     * Create a matcher for existing directory.
     *
     * @return Matcher for existing directory.
     *
     * @since 1.0.0
     */
    public static Matcher<Path> directory() {
        return Matchers.directory(Files::isDirectory);
    }

    /**
     * Create a matcher for readable file.
     *
     * @return Matcher for readable file.
     *
     * @since 1.0.0
     */
    public static Matcher<Path> readable() {
        return Matchers.readable(Files::isReadable);
    }

    private PathMatchers() {
    }

}
