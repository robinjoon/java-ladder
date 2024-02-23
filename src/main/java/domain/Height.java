package domain;

class Height {
    static final int MIN = 5;
    static final int MAX = 10;

    private final int length;

    Height(int length) {
        validate(length);
        this.length = length;
    }

    private void validate(int length) {
        if (length < MIN || length > MAX) {
            throw new LadderGameException(ExceptionType.HEIGHT_RANGE);
        }
    }

    int getLength() {
        return length;
    }
}
