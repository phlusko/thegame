package com.thegame.dd.p4u1.characters;

import com.thegame.dd.p4u1.utils.Walker;

/**
 * Created by Paul on 9/3/2017.
 */
public class Luke extends Krystal {
    public Luke(Human paul) {
        super(paul);
        this.walker = new Walker(4);
    }
}
