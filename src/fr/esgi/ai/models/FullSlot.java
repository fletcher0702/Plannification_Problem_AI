package fr.esgi.ai.models;

import java.util.Date;

public class FullSlot extends TimeSlot {

    private Person person;
    private Room room;

    public FullSlot(Date start, Date end, Person person, Room room) {
        super(start, end);
        this.person = person;
        this.room = room;
    }
}
