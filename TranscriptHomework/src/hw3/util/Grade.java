package hw3.util;

public enum Grade {
    F("F", 0),
    D("D", 1),
    C("C", 2),
    B("B", 3),
    A("A", 4);

    private String stringValue;
    private int numericValue;

    Grade(String stringValue, int numericValue) {
        this.stringValue = stringValue;
        this.numericValue = numericValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public int getNumericValue() {
        return numericValue;
    }

    public void setNumericValue(int numericValue) {
        this.numericValue = numericValue;
    }

    @Override
    public String toString() {
        return "Grade " + stringValue + " corresponds to numeric grade " + numericValue + ".";
    }
}



