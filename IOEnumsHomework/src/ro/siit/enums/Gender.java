package ro.siit.enums;

/**
 * @author Georgiana
 * @version 1.0
 * @sience 31/08/2019
 * Gender Enum - gender is a String field with two possible values(male/female) or
 * gender sex is an int(0 for male and 1 for female)
 */

public enum Gender {
    MALE("male", 0),
    FEMALE("female", 1);


    private  String gender;
    private int genderNumber;

    Gender(String gender, int genderNumber) {
        this.gender = gender;
        this.genderNumber = genderNumber;
    }

    public static Gender selectGender(String gender, int genderNumber){
        if(gender.equals("female")){
            return FEMALE;
        } else if (genderNumber == 1) {
            return FEMALE;
        }
        return null;
    }
}
