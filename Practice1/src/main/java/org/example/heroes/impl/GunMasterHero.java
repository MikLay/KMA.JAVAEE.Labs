package org.example.heroes.impl;

import org.example.heroes.Hero;
import org.example.heroes.ShotWeapon;

import java.util.Collection;

public class GunMasterHero implements Hero {
    private Collection<ShotWeapon> weapon;

    public void setWeapon(Collection<ShotWeapon> weapon) {
        this.weapon = weapon;
    }

    @Override
    public void showPower() {
        System.out.println("Hello I am GUNMaster and I know how all my weapon sound: ");
        weapon.forEach(ShotWeapon::makeSoundShot);
    }
}
