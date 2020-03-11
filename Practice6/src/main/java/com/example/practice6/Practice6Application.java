package com.example.practice6;

import com.example.practice6.model.ApartmentBillingId;
import com.example.practice6.model.ApartmentEntity;
import com.example.practice6.model.BillingEntity;
import com.example.practice6.model.UserEntity;
import com.example.practice6.service.ApartmentService;
import com.example.practice6.service.BillingService;
import com.example.practice6.service.UserService;
import org.apache.catalina.User;
import org.hibernate.LazyInitializationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.applet.AppletContext;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Practice6Application {

    public static void main(String[] args) {
        ApplicationContext appletContext = SpringApplication.run(Practice6Application.class, args);
        System.out.println("=== User Example ===");
        userExample(appletContext);
        System.out.println("=== Apartment&Billing Example ===");
        apartmentExample(appletContext);

    }

    private static void userExample(ApplicationContext applicationContext) {
        UserService userService = applicationContext.getBean(UserService.class);

        UserEntity user = userService.createUser("firstName1", "lastName1", "email1@example.com");
        System.out.println("Saved new user: " + user);
        userService.createUser("firstName2", "lastName2", "email2@example.com");

        System.out.println("Get user by id 1: " + userService.getUserById(1));
        System.out.println("Get user by unknown id: " + userService.getUserById(1000));

        System.out.println("Number of users in DB:" + userService.countUsers());
        System.out.println("Find all users\n" + userService.findAllUsers());
    }

    private static void apartmentExample(ApplicationContext applicationContext) {
        ApartmentService apartmentService = applicationContext.getBean(ApartmentService.class);
        BillingService billingService = applicationContext.getBean(BillingService.class);


        int firstApartment = apartmentService.createApartment("100a");
        int secondApartment = apartmentService.createApartment("100b");

        System.out.println("create billings for apartment " + firstApartment);
        billingService.createBilling(firstApartment, LocalDate.of(2020, 1, 1), 100);
        billingService.createBilling(firstApartment, LocalDate.of(2020, 1, 2), 100);

        System.out.println("create billings for apartment " + secondApartment);
        billingService.createBilling(secondApartment, LocalDate.of(2020, 1, 1), 100);


        List<ApartmentEntity> apartments = apartmentService.findAllApartmentsWithoutFetch();
        System.out.println("Found " + apartments.size() + " apartments");
        try {
            System.out.println("Bad print of billings");
            printBillings(apartments);
        } catch (LazyInitializationException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("good print of billings");
        apartments = apartmentService.findAllApartmentsWithFetch();
        System.out.println("Found " + apartments.size() + " apartments with billings fetch");
        printBillings(apartments);

        LocalDate period1 = LocalDate.of(2020, 1, 1);
        System.out.println("find billing for apartment " + secondApartment + " and period " + period1);
        System.out.println(billingService.getBillingById(ApartmentBillingId.of(secondApartment, period1)));

        LocalDate period2 = LocalDate.of(2020, 1, 2);
		System.out.println("find billing for apartment " + secondApartment + " and period " + period2);
		System.out.println(billingService.getBillingById(ApartmentBillingId.of(secondApartment, period2)));
    }

    private static void printBillings(final List<ApartmentEntity> apartments) {
        apartments.forEach(apartment -> {
            System.out.println("Billings for apartment " + apartment.getNumber() + " are: " + apartment.getBillings());
        });
    }

}
