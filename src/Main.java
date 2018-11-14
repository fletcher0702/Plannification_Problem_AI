import fr.esgi.ai.models.Person;
import fr.esgi.ai.models.TimeSlot;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        

        TimeSlot matin = new TimeSlot(8,10);
        TimeSlot aprem = new TimeSlot(14,16);

        ArrayList<TimeSlot> allamAvailabilities = new ArrayList<>();

        Person allam = new Person("Allam");
        allam.addAll(allamAvailabilities);


        allamAvailabilities.add(matin);
        allamAvailabilities.add(aprem);




    }
}
