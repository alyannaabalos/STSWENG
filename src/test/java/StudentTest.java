import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;

class StudentTest {
    @Test
    void enlist_2_sections_same_schedule() {
        //Given 1 student and 2 sections w/o conflict
        Student student = new Student(1, Collections.emptyList());
        Section sec1 = new Section("A");
        Section sec2 = new Section("B");

        //When student enlists in both sections
        student.enlist(sec1);
        student.enlist(sec2);

        // Then the 2 sections should be found
        //and student should only have 2 sections
        Collection<Section> sections = student.getSections();

    }

}
