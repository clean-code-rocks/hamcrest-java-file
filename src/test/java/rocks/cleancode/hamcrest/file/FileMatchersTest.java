package rocks.cleancode.hamcrest.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static rocks.cleancode.hamcrest.file.FileMatchers.directory;
import static rocks.cleancode.hamcrest.file.FileMatchers.file;

class FileMatchersTest {

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

    @Test
    public void should_match_existing_directory() throws URISyntaxException {
        File existingDirectory = new File(getClass().getResource("/test_directory").toURI());

        assertThat(existingDirectory, is(directory()));
    }

    @Test
    public void should_fail_when_directory_does_not_exist() {
        File notADirectory = new File("/not/a/directory");

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
