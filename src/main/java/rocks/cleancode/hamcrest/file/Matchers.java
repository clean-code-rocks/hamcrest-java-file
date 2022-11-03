package rocks.cleancode.hamcrest.file;

import org.hamcrest.Matcher;

import java.util.function.Predicate;

class Matchers {

    static <T> Matcher<T> file(Predicate<T> predicate) {
        return new PredicateMatcher<>(predicate, "a file", "was not a file");
    }

    static <T> Matcher<T> directory(Predicate<T> predicate) {
        return new PredicateMatcher<>(predicate, "a directory", "was not a directory");
    }

    static <T> Matcher<T> readable(Predicate<T> predicate) {
        return new PredicateMatcher<>(predicate, "a readable file", "was not readable");
    }

    private Matchers() {
    }

}
