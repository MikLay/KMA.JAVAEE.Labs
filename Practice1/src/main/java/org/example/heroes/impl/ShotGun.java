package org.example.heroes.impl;

import org.example.heroes.ShotWeapon;

public class ShotGun implements ShotWeapon {
    @Override
    public void makeSoundShot() {
        System.out.println("Bahhhh");
    }
}
