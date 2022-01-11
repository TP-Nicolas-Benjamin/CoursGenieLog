package datamocklib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Person {

    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;
    private String cityOfResidence;
    private String cityOfBirth;

    public Person(String firstName, String lastName, String birthDate, String gender, String cityOfResidence, String cityOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.cityOfResidence = cityOfResidence;
        this.cityOfBirth = cityOfBirth;
    }

    // firstName,lastName,birthDate,gender,cityOfResidence,cityOfBirth
    private final int  FIRSTNAME_INDEX = 0;
    private final int LASTNAME_INDEX = 1;
    private final int BIRTHDATE_INDEX = 2;
    private final int GENDER_INDEX = 3;
    private final int CITY_RESIDENCE_INDEX = 4;
    private final int CITY_BIRTH_INDEX = 5;


    // line --> 
    public Person(String line) {
        // Split line by ,
        String[] personInfo = line.split(",");
        this.firstName = personInfo[FIRSTNAME_INDEX];
        this.lastName = personInfo[LASTNAME_INDEX];
        this.birthDate = personInfo[BIRTHDATE_INDEX];
        this.gender = personInfo[GENDER_INDEX];
        this.cityOfResidence = personInfo[CITY_RESIDENCE_INDEX];
        this.cityOfBirth= personInfo[CITY_BIRTH_INDEX];
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfResidence(String cityOfResidence) {
        this.cityOfResidence = cityOfResidence;
    }

    public String getCityOfResidence() {
        return cityOfResidence;
    }

    public int getAge() {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthDate);
            return 2022 - date.getYear();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", gender='" + gender + '\'' +
                ", cityOfResidence='" + cityOfResidence + '\'' +
                ", cityOfBirth='" + cityOfBirth + '\'' +
                '}';
    }
}
