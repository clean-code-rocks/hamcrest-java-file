package rocks.cleancode.hamcrest.file;

import java.io.File;

public class FileMatchers {

    public static IsFileMatcher<File> file() {
        return new IsFileMatcher<>(File::isFile);
    }

    private FileMatchers() {
    }

}
