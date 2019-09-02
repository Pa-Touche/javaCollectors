package stream;

import utils.StringUtils;

import java.util.List;
import java.util.Objects;

public class Person {
    String firstName;
    String lastName;
    int age;

    String emailAddress1;
    String emailAddress2;
    String emailAddress3;
    String emailAddress4;
    String emailAddress5;


    public Person() {
    }

    public Person(Person toCopy) {
        this.firstName = toCopy.firstName;
        this.lastName = toCopy.lastName;
        this.age = toCopy.age;
        this.emailAddress1 = toCopy.emailAddress1;
        this.emailAddress2 = toCopy.emailAddress2;
        this.emailAddress3 = toCopy.emailAddress3;
        this.emailAddress4 = toCopy.emailAddress4;
        this.emailAddress5 = toCopy.emailAddress5;
        this.addresses = toCopy.addresses;
    }

    List<Address> addresses;

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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailAddress1() {
        return emailAddress1;
    }

    public void setEmailAddress1(String emailAddress1) {
        this.emailAddress1 = emailAddress1;
    }

    public String getEmailAddress2() {
        return emailAddress2;
    }

    public void setEmailAddress2(String emailAddress2) {
        this.emailAddress2 = emailAddress2;
    }

    public String getEmailAddress3() {
        return emailAddress3;
    }

    public void setEmailAddress3(String emailAddress3) {
        this.emailAddress3 = emailAddress3;
    }

    public String getEmailAddress4() {
        return emailAddress4;
    }

    public void setEmailAddress4(String emailAddress4) {
        this.emailAddress4 = emailAddress4;
    }

    public String getEmailAddress5() {
        return emailAddress5;
    }

    public void setEmailAddress5(String emailAddress5) {
        this.emailAddress5 = emailAddress5;
    }

    public static Person of(String firstName) {
        Person person = new Person();

        person.setFirstName(firstName);
        person.setLastName(StringUtils.generateRandom());

        person.setAge(Math.toIntExact(Math.round(Math.random() * 50)));

        return person;
    }

    public static Person of(String firstName, int age) {
        Person person = new Person();

        person.setFirstName(firstName);
        person.setLastName(StringUtils.generateRandom());
        person.setAge(age);

        return person;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(emailAddress1, person.emailAddress1) &&
                Objects.equals(emailAddress2, person.emailAddress2) &&
                Objects.equals(emailAddress3, person.emailAddress3) &&
                Objects.equals(emailAddress4, person.emailAddress4) &&
                Objects.equals(emailAddress5, person.emailAddress5) &&
                Objects.equals(addresses, person.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, emailAddress1, emailAddress2, emailAddress3, emailAddress4, emailAddress5, addresses);
    }


    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
