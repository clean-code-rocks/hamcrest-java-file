package rocks.cleancode.hamcrest.file;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.nio.file.Files;
import java.nio.file.Path;

public class IsFileMatcher extends TypeSafeMatcher<Path> {

    @Override
    protected boolean matchesSafely(Path path) {
        return Files.isRegularFile(path);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a file");
    }

    @Override
    protected void describeMismatchSafely(Path path, Description mismatchDescription) {
        mismatchDescription.appendText("was not a file");
    }

}
