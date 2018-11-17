import fr.esgi.ai.models.Person;
import fr.esgi.ai.models.Room;
import fr.esgi.ai.models.TimeSlot;

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

        TimeSlot fletcherMatin = new TimeSlot(10,12);
        TimeSlot fletcherAprem = new TimeSlot(16,17);

        ArrayList<TimeSlot> fletcherAvailabilities = new ArrayList<>();
        fletcherAvailabilities.add(fletcherMatin);
        fletcherAvailabilities.add(fletcherAprem);

        fletcher.addAll(fletcherAvailabilities);

        /*
        Defining room availabilities
         */
        Room a14 = new Room("A14");

        TimeSlot a14Matin = new TimeSlot(8,10);
        TimeSlot a14Aprem = new TimeSlot(14,16);

        ArrayList<TimeSlot> a14Availabilities = new ArrayList<>();
        a14Availabilities.add(a14Matin);
        a14Availabilities.add(a14Aprem);

        a14.addAll(a14Availabilities);
    }
}
