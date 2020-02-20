package org.example.heroes.impl;

import org.example.heroes.ShotWeapon;

public class Stick implements ShotWeapon {

    @Override
    public void makeSoundShot() {
        System.out.println("Not in this year, I am stick!");
    }
}
