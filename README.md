# Hamcrest - File

[![Maven Central][Maven Central - badge]][Maven Central - link]
[![Javadoc][Javadoc - badge]][Javadoc - link]
[![Codecov][Codecov - badge]][Codecov - link]
[![License: GPL v3][Licence - badge]][Licence - link]
[![Fossa][Fossa - badge]][Fossa - link]

[Java Hamcrest] matchers for files and directories.

## Requirement

Java 8+

## Installation

### Maven

```xml
<dependency>
    <groupId>rocks.cleancode</groupId>
    <artifactId>hamcrest-file</artifactId>
    <version>1.0.0</version>
    <scope>test</scope>
</dependency>
```

## Usage

Five matchers are provided:
- `file()` / `directory()`: matches an existing file or directory
- `readable()` / `writable()` / `executable()`: matches file accessibility

### file() / directory()

#### For `java.nio.file.Path`

```java
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static rocks.cleancode.hamcrest.file.PathMatchers.directory;
import static rocks.cleancode.hamcrest.file.PathMatchers.file;

Path file = Paths.get("/path/to/file.txt");
Path dir = Paths.get("/path/to/directory");

assertThat(file, is(file()));
assertThat(dir, is(directory()));
```

#### For `java.io.File`

```java
import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static rocks.cleancode.hamcrest.file.FileMatchers.directory;
import static rocks.cleancode.hamcrest.file.FileMatchers.file;

File file = new File("/path/to/file.txt");
File dir = new File("/path/to/directory");

assertThat(file, is(file()));
assertThat(dir, is(directory()));
```

### readable() / writable() / executable()

#### For `java.nio.file.Path`

```java
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static rocks.cleancode.hamcrest.file.PathMatchers.executable;
import static rocks.cleancode.hamcrest.file.PathMatchers.readable;
import static rocks.cleancode.hamcrest.file.PathMatchers.writable;

Path path = Paths.get("/path/to/readable/file.txt");

assertThat(path, is(readable()));
assertThat(path, is(writable()));
assertThat(path, is(executable()));
```

#### For `java.io.File`

```java
import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static rocks.cleancode.hamcrest.file.FileMatchers.executable;
import static rocks.cleancode.hamcrest.file.FileMatchers.readable;
import static rocks.cleancode.hamcrest.file.FileMatchers.writable;

File file = new File("/path/to/readable/file.txt");

assertThat(file, is(readable()));
assertThat(file, is(writable()));
assertThat(file, is(executable()));
```

[Java Hamcrest]: https://hamcrest.org/JavaHamcrest/

[Maven Central - badge]: https://img.shields.io/maven-central/v/rocks.cleancode/hamcrest-file?color=brightgreen
[Maven Central - link]: https://search.maven.org/artifact/rocks.cleancode/hamcrest-file
[Javadoc - badge]: https://javadoc.io/badge2/rocks.cleancode/hamcrest-file/javadoc.svg
[Javadoc - link]: https://javadoc.io/doc/rocks.cleancode/hamcrest-file
[Codecov - badge]: https://codecov.io/gh/clean-code-rocks/hamcrest-java-file/branch/main/graph/badge.svg?token=20U73YBOJB
[Codecov - link]: https://codecov.io/gh/clean-code-rocks/hamcrest-java-file
[Licence - badge]: https://img.shields.io/badge/License-GPLv3-blue.svg
[Licence - link]: https://www.gnu.org/licenses/gpl-3.0
[Fossa - badge]: https://app.fossa.com/api/projects/git%2Bgithub.com%2Fclean-code-rocks%2Fhamcrest-java-file.svg?type=shield
[Fossa - link]: https://app.fossa.com/projects/git%2Bgithub.com%2Fclean-code-rocks%2Fhamcrest-java-file?ref=badge_shield
