package rocks.cleancode.hamcrest.file;

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
    public static IsFileMatcher<File> file() {
        return new IsFileMatcher<>(File::isFile);
    }

    private FileMatchers() {
    }

}
