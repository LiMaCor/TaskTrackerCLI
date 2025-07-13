package model;

public enum Status {
    TODO("ToDo"),
    IN_PROGRESS("In progress"),
    DONE("Done");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
