package rocks.cleancode.hamcrest.file;

import java.nio.file.Files;
import java.nio.file.Path;

public class PathMatchers {

    public static IsFileMatcher<Path> file() {
        return new IsFileMatcher<>(Files::isRegularFile);
    }

    private PathMatchers() {
    }

}
