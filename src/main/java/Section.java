import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.*;


class Section {
    private final String sectionId;
    private final Schedule schedule;

    //check
    Section(String sectionId, Schedule schedule) {
        //validate if null or whitespace
        notBlank(sectionId);

        //validate schedule
        notNull(schedule);

        //validate if alphanumeric
        isTrue(StringUtils.isAlphanumeric(sectionId),
                "sectionID must be alphanumeric, was: " + sectionId );

        this.sectionId = sectionId;
        this.schedule = schedule;
    }

    Schedule getSchedule() {
        return schedule;
    }

    //toString
    @Override
    public String toString() {
        return sectionId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return Objects.equals(sectionId, section.sectionId);
    }

    @Override
    public int hashCode() {
        return sectionId != null ? sectionId.hashCode() : 0;
    }
}


