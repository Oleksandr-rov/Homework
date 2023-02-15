package module_8.enums;

public enum Dashes {
    SOLID (1),
    DOTTED(2),
    DASHED(3);

    int value;

    Dashes(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
