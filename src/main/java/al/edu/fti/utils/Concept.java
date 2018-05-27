package al.edu.fti.utils;

public class Concept {

    private String label;
    private String value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Concept() {
    }

    public Concept(String label, String value) {
        this.label = label;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Concept{" +
                "label='" + label + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
