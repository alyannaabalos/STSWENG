import org.apache.commons.lang3.Validate;

import java.util.*;

class Student {

    private final int studentNumber;
    private final Collection<Section> sections = new HashSet<>();

    Student(int studentNumber, Collection<Section> sections) {
        //validate if negative
        if (studentNumber < 0) {
            throw new IllegalArgumentException(
                    "studentNumber should be non-negative, was "
                            + studentNumber);
        }

        if (sections == null) {
            throw new NullPointerException("Sections should not be null");
        }


        //initialize
        this.studentNumber = studentNumber;
        this.sections.addAll(sections);
        this.sections.removeIf(Objects::isNull);
    }

    //Enlist a student to a section
    void enlist(Section newSection){
        Validate.notNull(newSection);

        // loop through sections, check for same sched
        sections.forEach( currSection -> {
            if (currSection.getSchedule().equals(newSection.getSchedule())){
                throw new RuntimeException("current section" + currSection +
                        " has same schedule as new section" + newSection +
                        " at schedule " + currSection.getSchedule());
            }
        });

        //check room capacity
        newSection.getRoom().maxCapacity();
        this.sections.add(newSection);
        newSection.getRoom().addCount();
    }

    //Cancel enlisted section
    void cancel(Section section){
        Validate.notNull(section);
        if (this.sections.contains(section)){
            section.getRoom().minusCount();
            sections.remove(section);
        }
        else {
            throw new IllegalArgumentException("You are not enrolled in section " + section);
        }
    }

    //getters and setters
    Collection<Section> getSections() {
        return new ArrayList<>(sections);
    }

    @Override
    public String toString(){
        return "Student# " + studentNumber;
    }

    //hashcode  - hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentNumber == student.studentNumber;
    }

    @Override
    public int hashCode() {
        return studentNumber;
    }
}
