package fr.esgi.ai.models;

import java.util.ArrayList;

public abstract class Resource extends ArrayList<TimeSlot> {

    private String name;

    public Resource(String name) {

        this.name = name;
    }
}
