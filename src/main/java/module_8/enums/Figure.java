package module_8.enums;

public enum Figure {
    SQUARE(1),
    CIRCLE(2),
    TRIANGLE(3),
    RHOMBUS(4),
    PARALLELOGRAM(5),
    STAR(6);

    int value;

    Figure(int value) {

        this.value = value;
    }

    public int getValue() {

        return this.value;
    }
}
