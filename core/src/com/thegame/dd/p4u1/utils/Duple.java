package com.thegame.dd.p4u1.utils;

/**
 * Created by Paul on 8/29/2017.
 */

public class Duple {
    public int x,y;
    public Duple() {
        x = 0;
        y = 0;
    }

    public Duple (int arg0, int arg1) {
        x = arg0;
        y = arg1;
    }

    public boolean same(Duple arg0){
        return x == arg0.x && y == arg0.y;
    }

    public void add(Duple arg0) {
        x += arg0.x;
        y += arg0.y;
    }

    public static Duple subtract(Duple a, Duple b) {
        return new Duple(a.x - b.x, a.y - b.y);
    }
    public static Duple add(Duple a, Duple b) {
        return new Duple(a.x + b.x, a.y + b.y);
    }
    public String toString() {
        return x + " , " + y;
    }
}
