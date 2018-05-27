package al.edu.fti.enums;

public enum StatusEnum {

    ACTIVE, DISABLED;

    public static StatusEnum getStatus(String status) {
        if(status.equalsIgnoreCase(DISABLED.toString())) {
            return DISABLED;
        } else if(status.equalsIgnoreCase(ACTIVE.toString())) {
            return ACTIVE;
        }
        return null;
    }
}
