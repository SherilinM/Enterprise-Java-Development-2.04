import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonListTest {
    Person person1;
    Person person2;
    Person person3;
    Person person4;
    PersonList people;

    @BeforeEach
    void init() {
        people = new PersonList();
        person1 = new Person("Abraham Puerta", 31, "Programmer");
        person2 = new Person("Juan Perez", 32, "Marketing Executive");
        person3 = new Person("Clara Fuenmayor", 23, "Graphic design");
        person4 = new Person("Antonio Martin", 23, "Finance");
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);

    }

    @Test
    void findByName_nameExactlyMatches_OK() {
        assertEquals(person1, people.findByName("Abraham Puerta"));

    }

    @Test
    void findByName_nameWithoutAccent_throwsException() {
        assertThrows(UnsupportedOperationException.class, () -> people.findByName("Abrahám Puerta"));

    }

    @Test
    void findByName_emptyList_throwsException() {
        people.removeAll();
        assertThrows(UnsupportedOperationException.class, () -> people.findByName("Abrahám Puerta"));
    }

    @Test
    void findByName_nameMultipleTimes_returnsFirst() {
        person4.setName("Abraham Puerta");
        assertEquals(person1.getId(), people.findByName("Abraham Puerta").getId());
    }

}