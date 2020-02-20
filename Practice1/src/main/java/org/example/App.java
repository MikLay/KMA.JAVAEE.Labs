package org.example;

import org.example.heroes.impl.GunMasterHero;
import org.example.heroes.impl.MetalHero;
import org.example.heroes.impl.SmartHero;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        MetalHero magnetto = (MetalHero) context.getBean("magnetto");
        magnetto.showPower();
        GunMasterHero gunmaster = (GunMasterHero) context.getBean("gunmaster");
        gunmaster.showPower();
        SmartHero smartHero = (SmartHero) context.getBean("smarter");
        smartHero.showPower();
    }
}
