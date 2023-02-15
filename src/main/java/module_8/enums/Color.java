package module_8.enums;

public enum Color {
    YELLOW(0),
    RED(1),
    GREEN(2),
    BLUE(3),
    GRAY(4),
    CYAN(5),
    BLACK(6),
    MAGENTA(7);

    int value;

    Color(int value) {

        this.value = value;
    }

    public int getValue() {

        return this.value;
    }
}
