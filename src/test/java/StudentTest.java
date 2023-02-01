import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void enlist_2_sections_no_conflict() {
        //Given 1 student and 2 sections w/o conflict
        Student student = new Student(1, Collections.emptyList());
        Section sec1 = new Section("A", new Schedule(Days.MTH, Period.H1000), new Room("S12", 45));
        Section sec2 = new Section("B", new Schedule(Days.MTH, Period.H0830), new Room("S11", 45));

        //When student enlists in both sections
        student.enlist(sec1);
        student.enlist(sec2);

        // Then the 2 sections should be found
        //and student should only have 2 sections
        Collection<Section> sections = student.getSections();
        assertAll(
                () -> assertTrue(sections.containsAll(List.of(sec1, sec2))),
                () -> assertEquals(2, sections.size())
        );
    }

    @Test
    void enlist_2_sections_same_schedule() {
        //Given a student and 2 sections w/ same sched
        Student student = new Student(1, Collections.emptyList());
        Section sec1 = new Section("A", new Schedule(Days.MTH, Period.H1000), new Room("S12", 45));
        Section sec2 = new Section("B", new Schedule(Days.MTH, Period.H1000), new Room("S11", 45));

        //When student enlists in 2 sections
        student.enlist(sec1);

        //Then on the 2nd enlistment, throw exception
        assertThrows(Exception.class, () -> student.enlist(sec2));
    }

    @Test
    void enlist_full_section(){
        Student student1 = new Student(12011843, Collections.emptyList());
        Student student2 = new Student(12011754, Collections.emptyList());
        Section sec1 = new Section("C", new Schedule(Days.MTH, Period.H1000), new Room("S13", 1));
        student1.enlist(sec1);
        assertThrows(Exception.class, () -> student2.enlist(sec1));
    }

}
