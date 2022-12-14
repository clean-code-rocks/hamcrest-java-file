package rocks.cleancode.hamcrest.file;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static rocks.cleancode.hamcrest.file.PathMatchers.*;

public class PathMatchersTest {

    @Test
    public void should_match_existing_file(@TempDir Path tempDir) throws IOException {
        Path existingFile = tempDir.resolve("existing-file.txt");

        Files.createFile(existingFile);

        assertThat(existingFile, is(file()));
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
    public void should_match_existing_directory(@TempDir Path tempDir) throws IOException {
        Path existingDirectory = tempDir.resolve("path/to/directory");

        Files.createDirectories(existingDirectory);

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

    @Test
    public void should_match_readable_file(@TempDir Path tempDir) throws IOException {
        Path readableFile = tempDir.resolve("readable-file.txt");

        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("r--r--r--");
        Files.createFile(readableFile, PosixFilePermissions.asFileAttribute(permissions));

        assertThat(readableFile, is(readable()));
    }

    @Test
    public void should_fail_when_file_is_not_readable(@TempDir Path tempDir) throws IOException {
        Path notReadableFile = tempDir.resolve("not-readable-file.txt");

        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("---------");
        Files.createFile(notReadableFile, PosixFilePermissions.asFileAttribute(permissions));

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
        Path writableFile = tempDir.resolve("writable-file.txt");

        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("-w--w--w-");
        Files.createFile(writableFile, PosixFilePermissions.asFileAttribute(permissions));

        assertThat(writableFile, is(writable()));
    }

    @Test
    public void should_fail_when_file_is_not_writable(@TempDir Path tempDir) throws IOException {
        Path notWritableFile = tempDir.resolve("not-writable-file.txt");

        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("---------");
        Files.createFile(notWritableFile, PosixFilePermissions.asFileAttribute(permissions));

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
        Path executableFile = tempDir.resolve("executable-file.txt");

        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("--x--x--x");
        Files.createFile(executableFile, PosixFilePermissions.asFileAttribute(permissions));

        assertThat(executableFile, is(executable()));
    }

    @Test
    public void should_fail_when_file_is_not_executable(@TempDir Path tempDir) throws IOException {
        Path notExecutableFile = tempDir.resolve("not-executable-file.txt");

        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("---------");
        Files.createFile(notExecutableFile, PosixFilePermissions.asFileAttribute(permissions));

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
