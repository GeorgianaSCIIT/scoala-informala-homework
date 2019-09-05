package ro.siit.enums;


/**
 * @author Georgiana
 * @version 1.0
 * @sience 31/08/2019
 * Gender Enum - gender is a String field with two possible values(male/female) or
 * gender sex is an int(0 for male and 1 for female)
 */

public enum Gender {
    MALE, FEMALE;

    private static String gender;
    private static int gender1;



    public static Gender setGender(){
        if(gender.equals("female")) {
            return FEMALE;
        }  else if(gender.equals("male")){
            return MALE;
        } else if(gender1 == 1){
            return FEMALE;
        } else if(gender1 == 0){
            return MALE;
        } else
            throw new  IllegalArgumentException("No such gender!");
    }
}
