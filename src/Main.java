import fr.esgi.ai.models.*;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        /*
        Defining first person availabilities
         */
        Person allam = new Person("Allam");

        TimeSlot allamMatin = new TimeSlot(8,10);
        TimeSlot allamAprem = new TimeSlot(14,16);

        ArrayList<TimeSlot> allamAvailabilities = new ArrayList<>();
        allamAvailabilities.add(allamMatin);
        allamAvailabilities.add(allamAprem);

        allam.addAll(allamAvailabilities);

        /*
        Defining second person availabilities
         */
        Person fletcher = new Person("Fletcher");

        TimeSlot fletcherMatin = new TimeSlot(8,10);
        TimeSlot fletcherAprem = new TimeSlot(14,16);

        ArrayList<TimeSlot> fletcherAvailabilities = new ArrayList<>();
        fletcherAvailabilities.add(fletcherMatin);
        fletcherAvailabilities.add(fletcherAprem);

        fletcher.addAll(fletcherAvailabilities);

        /*
        Defining room availabilities
         */
        Room a14 = new Room("A14");

        TimeSlot a14Matin1 = new TimeSlot(8,10);
        TimeSlot a14Matin2 = new TimeSlot(10,12);
        TimeSlot a14Aprem1 = new TimeSlot(14,16);
        TimeSlot a14Aprem2 = new TimeSlot(16,17);

        ArrayList<TimeSlot> a14Availabilities = new ArrayList<>();
        a14Availabilities.add(a14Matin1);
        a14Availabilities.add(a14Matin2);
        a14Availabilities.add(a14Aprem1);
        a14Availabilities.add(a14Aprem2);

        a14.addAll(a14Availabilities);

        /*
        Filling slots randomly to make a first schedule
         */
        Schedule schedule = new Schedule();

        for (TimeSlot tSlot: allamAvailabilities)
        {
            FullSlot fSlot = new FullSlot(tSlot.start, tSlot.end, allam, a14);
            schedule.add(fSlot);
        }

        for (TimeSlot tSlot: fletcherAvailabilities)
        {
            FullSlot fSlot = new FullSlot(tSlot.start, tSlot.end, fletcher, a14);
            schedule.add(fSlot);
        }

        /*
        Lunching the algorithm
         */
        schedule.initialize();
        schedule.printSchedule();
        schedule.planSchedule();
    }
}
