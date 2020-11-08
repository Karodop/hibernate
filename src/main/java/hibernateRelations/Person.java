package hibernateRelations;

import javax.persistence.OneToOne;

public class Person {

    private Long id;
    private String firstName;
    private String lastName;
    private String PESEL;
    private int age;

    @OneToOne
    private Adress adress;


    public Person(String firstName, String lastName, String PESEL, int age, Adress adress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.PESEL = PESEL;
        this.age = age;
        this.adress = adress;
    }

    public Person (){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", age=" + age +
                ", adress=" + adress +
                '}';
    }
}
