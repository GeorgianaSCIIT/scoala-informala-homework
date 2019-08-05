package ro.scit.enums;

/**
 * @author Georgiana
 * gender Enum
 */

public enum GenderEnum {
    MALE ("male"),
    FEMALE("female");

    private String gender;

    GenderEnum(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
