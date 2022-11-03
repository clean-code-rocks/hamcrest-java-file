package rocks.cleancode.hamcrest.file;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static rocks.cleancode.hamcrest.file.FileMatchers.directory;
import static rocks.cleancode.hamcrest.file.FileMatchers.file;

class FileMatchersTest {

    @Test
    public void should_match_existing_file(@TempDir Path tempDir) throws IOException {
        Path existingFile = tempDir.resolve("existing-file.txt");

        Files.createFile(existingFile);

        assertThat(existingFile.toFile(), is(file()));
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
    public void should_match_existing_directory(@TempDir Path tempDir) throws IOException {
        Path existingDirectory = tempDir.resolve("path/to/directory");

        Files.createDirectories(existingDirectory);

        assertThat(existingDirectory.toFile(), is(directory()));
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
