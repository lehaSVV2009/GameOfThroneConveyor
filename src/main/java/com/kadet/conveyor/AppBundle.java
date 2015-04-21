package com.kadet.conveyor;

import com.kadet.conveyor.container.*;
import com.kadet.conveyor.entity.Personage;
import com.kadet.conveyor.machine.*;
import com.kadet.conveyor.service.ConveyorService;
import com.kadet.conveyor.util.PersonageFactory;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by AlexSoroka on 4/21/2015.
 */
public class AppBundle {

    private static ConveyorService conveyorService;

    public static void initState () {

        if (conveyorService == null) {

            Container<Personage> beforeWishContainer = new BeforeWishContainer(new ArrayList<Personage>());
            Container<Personage> beforeFansContainer = new BeforeFansContainer(new ArrayList<Personage>());
            Container<Personage> beforeConflictContainer = new BeforeConflictContainer(new ArrayList<Personage>());
            Container<Personage> beforeKillingContainer = new BeforeKillingContainer(new ArrayList<Personage>());
            Container<Personage> killedContainer = new KilledContainer(new ArrayList<Personage>());

            int size = fillFirstContainer(beforeWishContainer);

            final Machine<Personage> wishMaker = new WishMaker(beforeWishContainer, beforeFansContainer, size);
            final Machine<Personage> fansMaker = new FansMaker(beforeFansContainer, beforeConflictContainer, size);
            final Machine<Personage> conflictMaker = new ConflictMaker(beforeConflictContainer, beforeKillingContainer, size);
            final Machine<Personage> dumWayKiller = new DumbWayKiller(beforeKillingContainer, killedContainer, size);

            conveyorService = new ConveyorService(new ArrayList<Machine>() {{
                add(wishMaker);
                add(fansMaker);
                add(conflictMaker);
                add(dumWayKiller);
            }});
        }

    }

    private static int fillFirstContainer (Container<Personage> container) {

        Personage JonArryn = PersonageFactory.createPersonage("Jon", "Arryn");
        Personage ViserysTargaryan = PersonageFactory.createPersonage("Viserys", "Targaryan");
        Personage RobertBaratheon = PersonageFactory.createPersonage("Robert", "Baratheon");
        Personage EddardStark = PersonageFactory.createPersonage("Eddard", "Stark");
        Personage KhalDrogo = PersonageFactory.createPersonage("Khal", "Drogo");
        Personage RanlyBaratheon = PersonageFactory.createPersonage("Ranly", "Baratheon");
        Personage KathelineStark = PersonageFactory.createPersonage("Katheline", "Stark");
        Personage RobbStark = PersonageFactory.createPersonage("Robb", "Stark");
        Personage GrayWind = PersonageFactory.createPersonage("Gray", "Wind");
        Personage IgritWild = PersonageFactory.createPersonage("Igrit", "Wild");
        Personage OberinMartell = PersonageFactory.createPersonage("Oberin", "Martell");
        Personage TayvinLannistar = PersonageFactory.createPersonage("Tayvin", "Lannistar");
        Personage GrigarKligan = PersonageFactory.createPersonage("Grigar", "Kligan");
        Personage SandorKligan = PersonageFactory.createPersonage("Sandor", "Kligan");

        container.add(JonArryn);
        container.add(ViserysTargaryan);
        container.add(RobertBaratheon);
        container.add(EddardStark);
        container.add(KhalDrogo);
        container.add(RanlyBaratheon);
        container.add(KathelineStark);
        container.add(RobbStark);
        container.add(GrayWind);
        container.add(IgritWild);
        container.add(OberinMartell);
        container.add(TayvinLannistar);
        container.add(GrigarKligan);
        container.add(SandorKligan);

        return container.size();
    }

    public static void start () {
        if (conveyorService != null) {
            conveyorService.start();
        }
    }

}
