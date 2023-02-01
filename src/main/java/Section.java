import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.*;


class Section {
    private final String sectionId;
    private final Schedule schedule;
    private final Room room;

    //check
    Section(String sectionId, Schedule schedule, Room room) {
        //validate if null or whitespace
        notBlank(sectionId);

        //validate schedule
        notNull(schedule);

        //validate if alphanumeric
        isTrue(StringUtils.isAlphanumeric(sectionId),
                "sectionID must be alphanumeric, was: " + sectionId );

        //validate if room is not null
        notNull(room);

        this.sectionId = sectionId;
        this.schedule = schedule;
        this.room = room;
    }

    Schedule getSchedule() {
        return schedule;
    }

    Room getRoom(){
        return room;
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


