package rocks.cleancode.hamcrest.file;

import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static rocks.cleancode.hamcrest.file.PathMatchers.directory;
import static rocks.cleancode.hamcrest.file.PathMatchers.file;

public class PathMatchersTest {

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

    @Test
    public void should_match_existing_directory() throws URISyntaxException {
        Path existingDirectory = Paths.get(getClass().getResource("/test_directory").toURI());

        assertThat(existingDirectory, is(directory()));
    }

    @Test
    public void should_fail_when_directory_does_not_exist() {
        Path notADirectory = Paths.get("/not/a/directory");

        AssertionError assertionError = assertThrows(
            AssertionError.class,
            () -> assertThat(notADirectory, is(directory()))
        );

        String expectedMessage = String.format(
            "%n%s%n%s",
            "Expected: is a directory",
            "     but: was not a directory"
        );

        assertThat(assertionError.getMessage(), is(equalTo(expectedMessage)));
    }

}
