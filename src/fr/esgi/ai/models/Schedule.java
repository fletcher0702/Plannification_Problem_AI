package fr.esgi.ai.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Schedule extends ArrayList<FullSlot>
{
    private Map<String, ArrayList<TimeSlot>> roomList;

    public Schedule()
    {
        this.roomList = new HashMap<>();
    }

    public void planSchedule()
    {
        /*
        Fetching the concerned resources
         */
        for (FullSlot fullSlot: this)
        {
            if (!this.roomList.containsKey(fullSlot.getRoom().getName()))
                this.roomList.put(fullSlot.getRoom().getName(), fullSlot.getRoom());
        }
    }
}
