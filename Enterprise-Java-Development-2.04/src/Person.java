import java.util.Objects;

public class Person {
    private static int idCounter = 0;
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(String name, int age, String occupation) {

        Validator.checkName(name);
        Validator.checkAge(age);

        id = idCounter++;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public Person() {
    }

    @Override
    protected Person clone() {
        return new Person(name, age, occupation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() && getName().equals(person.getName()) && getOccupation().equals(person.getOccupation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getOccupation());
    }

    @Override
    public String toString() {
        return "Person:" + name +
                "\nid=" + id +
                "\nage=" + age +
                "\noccupation='" + occupation + '\n';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}