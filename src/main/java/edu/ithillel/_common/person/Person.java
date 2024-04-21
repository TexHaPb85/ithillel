package edu.ithillel._common.person;

import java.sql.Timestamp;
import java.util.Objects;

public class Person extends Human {
    private String firstName;
    private String lastName;
    public String idCode;
    private Timestamp birthDate;

    public Person() {
    }

    public Person(String firstName, String lastName, String idCode, Timestamp birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCode = idCode;
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(idCode, person.idCode) && Objects.equals(birthDate, person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, idCode, birthDate);
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

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idCode='" + idCode + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
