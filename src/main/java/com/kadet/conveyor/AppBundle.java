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

            final Machine<Personage> dumWayKiller = new DumbWayKiller(beforeKillingContainer, killedContainer);
            final Machine<Personage> conflictMaker = new ConflictMaker(beforeConflictContainer, beforeKillingContainer, dumWayKiller);
            final Machine<Personage> fansMaker = new FansMaker(beforeFansContainer, beforeConflictContainer, conflictMaker);
            final Machine<Personage> wishMaker = new WishMaker(beforeWishContainer, beforeFansContainer, fansMaker, size);

            conveyorService = new ConveyorService(new ArrayList<Machine>() {{
                add(wishMaker);
                add(fansMaker);
                add(conflictMaker);
                add(dumWayKiller);
            }});
        }

    }

    private static int fillFirstContainer (Container<Personage> container) {

        Personage JonArryn = PersonageFactory.createPersonage("Jon", "Arryn", "http://oyster.ignimgs.com/mediawiki/apis.ign.com/game-of-thrones/1/18/Jon_Arryn_HS.png");
        Personage ViserysTargaryan = PersonageFactory.createPersonage("Viserys", "Targaryan", "http://7kingdoms.ru/wp-content/uploads/2010/09/mov002.jpg");
        Personage RobertBaratheon = PersonageFactory.createPersonage("Robert", "Baratheon", "http://7kingdoms.ru/wp-content/uploads/2010/09/mov003.jpg");
        Personage EddardStark = PersonageFactory.createPersonage("Eddard", "Stark", "http://7kingdoms.ru/wp-content/uploads/2010/09/got-userpic-ned.jpg");
        Personage KhalDrogo = PersonageFactory.createPersonage("Khal", "Drogo", "http://westeros.ru/wp-content/uploads/i-sing-of-my-scars_drogo-userpic.jpg");
        Personage RenlyBaratheon = PersonageFactory.createPersonage("Renly", "Baratheon", "http://images6.fanpop.com/image/photos/37000000/Renly-Baratheon-Squinty-renly-baratheon-37056740-109-120.jpg");
        Personage KathelineStark = PersonageFactory.createPersonage("Katheline", "Stark", "http://www.gamethronesonline.com/images/actors/michelle_fairley.jpg");
        Personage RobbStark = PersonageFactory.createPersonage("Robb", "Stark", "http://westeros.ru/wp-content/uploads/young-wilf_robb-userpic1.jpg");
        Personage GrayWind = PersonageFactory.createPersonage("Gray", "Wind", "https://pp.vk.me/c313530/v313530392/3d7b/5vjJw3qs39E.jpg");
        Personage IgritWild = PersonageFactory.createPersonage("Igrit", "Wild", "http://7kingdoms.ru/w/images/9/92/Hbo-ygritte.jpg");
        Personage OberinMartell = PersonageFactory.createPersonage("Oberin", "Martell", "http://7kingdoms.ru/w/images/c/c4/Hbo-Oberyn.jpg");
        Personage TayvinLannistar = PersonageFactory.createPersonage("Tayvin", "Lannistar", "http://tamgdeya.ru/photos/norm/1/1_kH86Rg4e.jpg");
        Personage GrigarKligan = PersonageFactory.createPersonage("Grigar", "Kligan", "http://7kingdoms.ru/w/images/9/96/Hbo_Gregor_Clegane-3.png");
        Personage SandorKligan = PersonageFactory.createPersonage("Sandor", "Kligan", "http://cs315827.vk.me/v315827936/99f2/0PnB--oIXx4.jpg");

        container.add(JonArryn);
        container.add(ViserysTargaryan);
        container.add(RobertBaratheon);
        container.add(EddardStark);
        container.add(KhalDrogo);
        container.add(RenlyBaratheon);
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
