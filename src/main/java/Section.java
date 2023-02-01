import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.notBlank;


class Section {
    private final String sectionId;


    Section(String sectionId) {
        //validate if null or whitespace
        notBlank(sectionId);

        //validate if alphanumeric
        isTrue(StringUtils.isAlphanumeric(sectionId),
                "sectionID must be alphanumeric, was: " + sectionId );

        this.sectionId = sectionId;
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
        return Objects.hash(sectionId);
    }
}
