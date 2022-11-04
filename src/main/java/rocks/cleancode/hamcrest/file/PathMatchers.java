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

    /**
     * Create a matcher for writable file.
     *
     * @return Matcher for writable file.
     *
     * @since 1.0.0
     */
    public static Matcher<Path> writable() {
        return Matchers.writable(Files::isWritable);
    }

    /**
     * Create a matcher for executable file.
     *
     * @return Matcher for executable file.
     *
     * @since 1.0.0
     */
    public static Matcher<Path> executable() {
        return Matchers.executable(Files::isExecutable);
    }

    private PathMatchers() {
    }

}
