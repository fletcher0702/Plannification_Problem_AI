package fr.esgi.ai.models;

import java.util.*;

public class Schedule extends ArrayList<FullSlot>
{
    private Map<String, ArrayList<TimeSlot>> roomList;
    private ArrayList<Person> personList;

    public Schedule()
    {
        this.roomList = new HashMap<>();
        this.personList = new ArrayList<>();
    }

    /*
    Initializing essential data's
     */
    public void initialize()
    {
        /*
        Fetching the concerned rooms
         */
        for (FullSlot fullSlot: this)
        {
            if (!this.roomList.containsKey(fullSlot.getRoom().getName()))
                this.roomList.put(fullSlot.getRoom().getName(), fullSlot.getRoom());
        }

        /*
        Fetching the concerned persons
         */
        for (FullSlot fullSlot: this)
        {
            if (!this.personList.contains(fullSlot.getPerson()))
                this.personList.add(fullSlot.getPerson());
        }
    }

    public void planSchedule()
    {
        int fitness = this.fitness(this);
        if (fitness == 0)
            System.out.println("L'emploi du temps ne présente aucun conflit");

        int numberOfIteration = 100;
        for (int i = 0; i < numberOfIteration; i++)
        {
            Schedule newSchedule = new Schedule();
            newSchedule.addAll(this);
            Random r = new Random();
            int randomPersonIndex = r.nextInt(this.personList.size());
            Person randomPerson = this.personList.get(randomPersonIndex);
            int randomFullSlotIndex = r.nextInt(newSchedule.size());
            FullSlot randomFullSlot = newSchedule.get(randomFullSlotIndex);
            if (randomPerson == randomFullSlot.getPerson())
            {
                randomFullSlot = this.moveFullSlot(randomFullSlot);
                newSchedule.set(randomFullSlotIndex, randomFullSlot);

                int newFitness = this.fitness(newSchedule);
                if (newFitness < fitness)
                {
                    fitness = newFitness;

                    this.clear();
                    this.addAll(newSchedule);
                    this.printSchedule();

                    if (fitness == 0)
                    {
                        System.out.println();
                        System.out.println("L'emploi du temps ne présente aucun conflit");
                        break;
                    }
                }
            }
        }
    }

    /*
    Calculate and return the fitness
     */
    public int fitness(Schedule schedule)
    {
        int conflicts = 0;

        Map<Integer, Integer> start = new HashMap<>();
        // Initializing the map with start values
        for (FullSlot fullSlot: schedule)
        {
            start.put(fullSlot.start, 0);
        }
        // Updating the number of occurrence of start value
        for (FullSlot fullSlot: schedule)
        {
            if (start.containsKey(fullSlot.start))
                start.put(fullSlot.start, start.get(fullSlot.start) + 1);
        }
        // Checking if any value is present more than one time
        for (Map.Entry<Integer, Integer> entry : start.entrySet())
        {
            if (entry.getValue() > 1)
                conflicts++;
        }
        return conflicts;
    }

    /*
    Replace a time slot
     */
    public FullSlot moveFullSlot(FullSlot fullSlot)
    {
        // Fetching the available timeSlot of the room
        ArrayList<TimeSlot> availableTS = this.roomList.get(fullSlot.getRoom().getName());
        int pos = 0;
        // Finding the position of the fullSlot timeSlot
        for (TimeSlot timeSlot: availableTS)
        {
            if (timeSlot.start == fullSlot.start && timeSlot.end == fullSlot.end)
                break;
            pos += 1;
        }
        // Assigning new pos
        int newPos = 0;
        if (pos == 0)
            newPos += 1;
        else if (pos == (availableTS.size() - 1))
            newPos = pos - 1;
        else
        {
            if (Math.random() > 0.5)
                newPos = pos - 1;
            else
                newPos = pos + 1;
        }
        // moving the fullSlot timeSlot
        pos = 0;
        for (TimeSlot timeSlot: availableTS)
        {
            if (pos == newPos)
            {
                fullSlot.start = timeSlot.start;
                fullSlot.end = timeSlot.end;
                break;
            }
            pos += 1;
        }
        return fullSlot;
    }

    /*
    Print schedule
     */
    public void printSchedule()
    {
        System.out.println();
        System.out.println();

        for (FullSlot fullSlot: this)
            System.out.println(fullSlot.getPerson().getName() + " : " +
                               fullSlot.start + "h - " + fullSlot.end + "h. Salle " +
                               fullSlot.getRoom().getName());
    }
}
