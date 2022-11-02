package rocks.cleancode.hamcrest.file.nio;

import org.hamcrest.Matcher;
import rocks.cleancode.hamcrest.file.AbstractIsFileMatcher;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Matches a file.
 *
 * @since 1.0.0
 */
public class IsFileMatcher extends AbstractIsFileMatcher<Path> {

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
        super(Files::isRegularFile);
    }

}
