package collectors;

import java.util.Date;

// TODO: make this a more functional classs
public class Person {

    private String name;

    private String birthCountry;
    private Date birthDate;
    private Double salary;

    public Person() {
    }    

    public Person(String name, String birthCountry, Date birthDate, Double salary) {
        this.name = name;
        this.birthCountry = birthCountry;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthCountry='" + birthCountry + '\'' +
                ", birthDate=" + birthDate +
                ", salary=" + salary +
                '}';
    }
}
