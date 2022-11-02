package rocks.cleancode.hamcrest.file.nio;

import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static rocks.cleancode.hamcrest.file.nio.IsFileMatcher.file;

public class IsFileMatcherTest {

    @Test
    public void should_match_existing_file() throws URISyntaxException {
        Path emptyFilePath = Paths.get(getClass().getResource("/empty_file").toURI());

        assertThat(emptyFilePath, is(file()));
    }

    @Test
    public void should_fail_when_file_does_not_exist() {
        Path notAFilePath = Paths.get("/not/a/file");

        AssertionError assertionError = assertThrows(
            AssertionError.class,
            () -> assertThat(notAFilePath, is(file()))
        );

        String expectedMessage = String.format(
            "%n%s%n%s",
            "Expected: is a file",
            "     but: was not a file"
        );

        assertThat(assertionError.getMessage(), is(equalTo(expectedMessage)));
    }

}