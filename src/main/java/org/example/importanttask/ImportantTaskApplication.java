package org.example.importanttask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ImportantTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImportantTaskApplication.class, args);
    }

}
