package org.example.heroes.impl;

import org.example.heroes.Hero;

public class MetalHero implements Hero {

    private final int age;

    public MetalHero() {
        this(25);
    }

    public MetalHero(int age) {
        this.age = age;
    }

    @Override
    public void showPower() {
        System.out.println("Hello my age is: " + age + " and I'm not a magnet at your fridge");
    }

}
