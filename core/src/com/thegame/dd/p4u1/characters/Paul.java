package com.thegame.dd.p4u1.characters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thegame.dd.p4u1.utils.Duple;
import com.thegame.dd.p4u1.utils.PaulGraphics;
import com.thegame.dd.p4u1.utils.Walker;

/**
 * Created by Paul on 8/29/2017.
 */

public class Paul extends Human {
    public Paul(Duple loc) {
        super();
        location = loc;
        previous_location = loc;
    }
}
