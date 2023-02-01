import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.isAlphanumeric;
import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.notNull;

class Room {
    private final String roomName;
    private final int roomCapacity;
    private int enrollees;

    Room (String roomName, int roomCapacity) {

        //validate if roomName is null
        notNull(roomName);
        //validate if roomName is alphanumeric
        isTrue(isAlphanumeric(roomName), "roomName must be alphanumeric, was " + roomName);

        //validate if roomCapacity is greater than 0
        if (roomCapacity < 0) {
            throw new IllegalArgumentException("roomCapacity should not be negative, was" + roomCapacity);
        }

        this.roomName = roomName;
        this.roomCapacity = roomCapacity;
        this.enrollees = 0;
    }

    void maxCapacity() {
        if (enrollees == roomCapacity) {
            throw new IllegalArgumentException("Room" + roomName +
                    "already has " + roomCapacity + "enrollees");
        }
    }

    void addCount(){
        this.enrollees += 1;
    }

    void minusCount(){
        this.enrollees -= 1;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomCapacity == room.roomCapacity && Objects.equals(roomName, room.roomName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomName, roomCapacity);
    }
}
