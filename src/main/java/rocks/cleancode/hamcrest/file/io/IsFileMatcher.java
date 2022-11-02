package rocks.cleancode.hamcrest.file.io;

import org.hamcrest.Matcher;
import rocks.cleancode.hamcrest.file.AbstractIsFileMatcher;

import java.io.File;

/**
 * Matches a file.
 *
 * @since 1.0.0
 */
public class IsFileMatcher extends AbstractIsFileMatcher<File> {

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
        super(File::isFile);
    }

}
