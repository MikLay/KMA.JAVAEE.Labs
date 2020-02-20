package org.example.heroes.impl;

import org.example.heroes.Hero;

public class SmartHero implements Hero {

    private int iQLevel;

    public void setiQLevel(int iQLevel) {
        this.iQLevel = iQLevel;
    }

    @Override
    public void showPower() {
        System.out.println("Hello my IQ level is " + iQLevel + " and I know what 3 letters change a girl into a woman");
    }
}
