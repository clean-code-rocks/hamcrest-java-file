package rocks.cleancode.hamcrest.file.io;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.io.File;

public class IsFileMatcher extends TypeSafeMatcher<File> {

    public static Matcher<File> file() {
        return new IsFileMatcher();
    }

    private IsFileMatcher() {
    }

    @Override
    protected boolean matchesSafely(File file) {
        return file.isFile();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a file");
    }

    @Override
    protected void describeMismatchSafely(File file, Description mismatchDescription) {
        mismatchDescription.appendText("was not a file");
    }

}
