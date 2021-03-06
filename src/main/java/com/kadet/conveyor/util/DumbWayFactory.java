package com.kadet.conveyor.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by AlexSoroka on 4/21/2015.
 */
public class DumbWayFactory {

    private static final List<String> waysEn = new ArrayList<String>(){{
        add("was poisoned at his own wedding");
        add("was beheaded");
        add("was brutally killed by The Mountain");
        add("was shot with an arrow");
        add("was sentenced to death");
        add("was shoved through the moon door");
        add("was shot with arrows");
        add("was incinerated by dragon");
        add("was set to be burned");
        add("died after holding the gate");
        add("was placed in a locked vault");
        add("was murdered by shadow baby");
        add("was killed by gold crone");
        add("was killed in the privy chamber");
        add("was killed and backed to life");
    }};

    private static final List<String> ways = new ArrayList<String>(){{
        add("отравлен на собственной свадьбе");
        add("обезглавлен");
        add("брутально убит Горой");
        add("застрелен лучником");
        add("убит по приказу");
        add("брошен в лунную дверь");
        add("застрелен лучниками");
        add("сожжен драконами");
        add("сожжен на костре");
        add("убит, сдерживая ворота от гигантов");
        add("заперт в погребе");
        add("убит тенью");
        add("убит расплавленным золотом");
        add("застрелен в туалете");
        add("убит в поединке и возвращен к жизни");
    }};

    public static String createWayToDie () {
        return ways.get(new Random().nextInt(ways.size()));
    }

}
