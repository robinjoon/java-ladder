package ladder;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class Direction {
    private final boolean left;
    private final boolean current;

    private Direction(final boolean left, final boolean current) {
        if (left && current) {
            throw new IllegalArgumentException();
        }

        this.left = left;
        this.current = current;
    }

    public int move() {
        if (this.left) {
            return -1;
        }

        if (this.current) {
            return 1;
        }

        return 0;
    }

    public Direction next(boolean nextCurrent) {
        return of(this.current, nextCurrent);
    }

    public Direction next() {
        if (this.current) {
            return next(FALSE);
        }
        return next(RandomValueGenerator.generate());
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean current) {
        return of(FALSE, current);
    }

    public Direction last() {
        return of(this.current, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction pair = (Direction) o;
        return left == pair.left &&
                current == pair.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }

    @Override
    public String toString() {
        return "ladder.Direction{" +
                "left=" + left +
                ", current=" + current +
                '}';
    }
}