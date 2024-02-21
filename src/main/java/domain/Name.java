package domain;

import java.util.Objects;

class Name {
    private final String name;

    Name(String name) {
        validateNameLength(name);
        validateNameCharacters(name);
        this.name = name;
    }

    private static void validateNameCharacters(String name) {
        if (name.matches("^[^a-zA-Z]+$")) {
            throw new LadderGameException(ExceptionType.NAME_CHARACTER);
        }
    }

    private static void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new LadderGameException(ExceptionType.NAME_LENGTH_RANGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name other = (Name) o;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    String getName() {
        return name;
    }
}
