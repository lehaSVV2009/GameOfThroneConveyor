package com.kadet.conveyor.util;

import com.kadet.conveyor.entity.Personage;

/**
 * Created by AlexSoroka on 4/21/2015.
 */
public class PersonageFactory {

    private static int count = 1;
    private static final String PREFIX = "PERSON_";

    public static Personage createPersonage (String name, String surname, String image) {
        Personage personage = new Personage();
        personage.setId(PREFIX + count);
        personage.setName(name);
        personage.setSurname(surname);
        personage.setImageUrl(image);
        ++count;
        return personage;
    }

}
