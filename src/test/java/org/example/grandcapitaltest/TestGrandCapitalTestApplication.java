package org.example.grandcapitaltest;

import org.springframework.boot.SpringApplication;

public class TestGrandCapitalTestApplication {

    public static void main(String[] args) {
        SpringApplication.from(GrandCapitalTestApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
