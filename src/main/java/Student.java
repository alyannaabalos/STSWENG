import java.util.*;

class Student {

    private final int studentNumber;
    private final Collection<Section> sections = new ArrayList<>();

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
    void enlist(Section section){
        if (section==null){
            throw new NullPointerException("Section should not be null");
        }
        this.sections.add(section);
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
