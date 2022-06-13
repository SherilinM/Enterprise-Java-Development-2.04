import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person1;

    @BeforeEach
    void init() {
        person1 = new Person("Abraham Puerta", 31, "Programmer");
    }

    @Test
    void testClone_differentID_ok() {

        assertEquals(person1.getId() + 1, person1.clone().getId());
    }

    @Test
    void testClone_clone_ok() {
        assertEquals(person1, person1.clone());

    }


    @Test
    void testClone_sameNameAgeAndOccupation_ok() {
        Person person2 = person1.clone();
        assertEquals(person1.getName(), person2.getName());
        assertEquals(person1.getAge(), person2.getAge());
        assertEquals(person1.getOccupation(), person2.getOccupation());

    }
}