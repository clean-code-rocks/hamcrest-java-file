package rocks.cleancode.hamcrest.file.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static rocks.cleancode.hamcrest.file.io.IsFileMatcher.file;

public class IsFileMatcherTest {

    @Test
    public void should_match_existing_file() throws URISyntaxException {
        File emptyFile = new File(getClass().getResource("/empty_file").toURI());

        assertThat(emptyFile, is(file()));
    }

    @Test
    public void should_fail_when_file_does_not_exist() {
        File notAFile = new File("/not/a/file");

        AssertionError assertionError = assertThrows(
            AssertionError.class,
            () -> assertThat(notAFile, is(file()))
        );

        String expectedMessage = String.format(
            "%n%s%n%s",
            "Expected: is a file",
            "     but: was not a file"
        );

        assertThat(assertionError.getMessage(), is(equalTo(expectedMessage)));
    }

}
