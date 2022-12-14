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
import static rocks.cleancode.hamcrest.file.FileMatchers.*;

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

    @Test
    public void should_match_readable_file(@TempDir Path tempDir) throws IOException {
        File readableFile = tempDir.resolve("readable-file.txt").toFile();
        readableFile.createNewFile();
        readableFile.setReadable(true);

        assertThat(readableFile, is(readable()));
    }

    @Test
    public void should_fail_when_file_is_not_readable(@TempDir Path tempDir) throws IOException {
        File notReadableFile = tempDir.resolve("not-readable-file.txt").toFile();
        notReadableFile.createNewFile();
        notReadableFile.setReadable(false);

        AssertionError assertionError = assertThrows(
            AssertionError.class,
            () -> assertThat(notReadableFile, is(readable()))
        );

        String expectedMessage = String.format(
            "%n%s%n%s",
            "Expected: is a readable file",
            "     but: was not readable"
        );

        assertThat(assertionError.getMessage(), is(equalTo(expectedMessage)));
    }

    @Test
    public void should_match_writable_file(@TempDir Path tempDir) throws IOException {
        File writableFile = tempDir.resolve("writable-file.txt").toFile();
        writableFile.createNewFile();
        writableFile.setWritable(true);

        assertThat(writableFile, is(writable()));
    }

    @Test
    public void should_fail_when_file_is_not_writable(@TempDir Path tempDir) throws IOException {
        File notWritableFile = tempDir.resolve("not-writable-file.txt").toFile();
        notWritableFile.createNewFile();
        notWritableFile.setWritable(false);

        AssertionError assertionError = assertThrows(
            AssertionError.class,
            () -> assertThat(notWritableFile, is(writable()))
        );

        String expectedMessage = String.format(
            "%n%s%n%s",
            "Expected: is a writable file",
            "     but: was not writable"
        );

        assertThat(assertionError.getMessage(), is(equalTo(expectedMessage)));
    }

    @Test
    public void should_match_executable_file(@TempDir Path tempDir) throws IOException {
        File executableFile = tempDir.resolve("executable-file.txt").toFile();
        executableFile.createNewFile();
        executableFile.setExecutable(true);

        assertThat(executableFile, is(executable()));
    }

    @Test
    public void should_fail_when_file_is_not_executable(@TempDir Path tempDir) throws IOException {
        File notExecutableFile = tempDir.resolve("not-executable-file.txt").toFile();
        notExecutableFile.createNewFile();
        notExecutableFile.setExecutable(false);

        AssertionError assertionError = assertThrows(
            AssertionError.class,
            () -> assertThat(notExecutableFile, is(executable()))
        );

        String expectedMessage = String.format(
            "%n%s%n%s",
            "Expected: is an executable file",
            "     but: was not executable"
        );

        assertThat(assertionError.getMessage(), is(equalTo(expectedMessage)));
    }

}
