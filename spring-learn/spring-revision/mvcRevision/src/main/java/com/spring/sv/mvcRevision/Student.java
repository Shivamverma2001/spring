package com.spring.sv.mvcRevision;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public class Student {
    @NotNull(message = "is required")
    private String firstName;
    @NotNull(message = "is required")
    private String lastName;
    private String country;
    private String favouriteLanguage;
    private List<String> favouriteOperatingSystems;
    @NotNull(message = "is required")
    @Min(value = 5,message = "more than 5 years")
    @Max(value = 20,message = "less than 20 years")
    private int age;
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 digits/characters")
    private String postalCode;

    public Student(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    public void setFavouriteLanguage(String favouriteLanguage) {
        this.favouriteLanguage = favouriteLanguage;
    }

    public List<String> getFavouriteOperatingSystems() {
        return favouriteOperatingSystems;
    }

    public void setFavouriteOperatingSystems(List<String> favouriteOperatingSystems) {
        this.favouriteOperatingSystems = favouriteOperatingSystems;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", favouriteLanguage='" + favouriteLanguage + '\'' +
                ", favouriteOperatingSystems=" + favouriteOperatingSystems +
                ", age=" + age +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
