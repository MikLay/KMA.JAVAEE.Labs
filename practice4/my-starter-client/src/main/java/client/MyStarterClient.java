package client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import library.MyLibraryClass;

@SpringBootApplication
public class MyStarterClient {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(MyStarterClient.class, args);
        MyLibraryClass myLibraryClassByClass = applicationContext.getBean(MyLibraryClass.class);
        myLibraryClassByClass.printInfo(() -> System.out.println("Test me"));
        MyLibraryClass myLibraryClass = (MyLibraryClass) applicationContext.getBean("myLibraryClassCustom");
        myLibraryClass.printInfo(() -> System.out.println("Test me too)"));
    }
}
