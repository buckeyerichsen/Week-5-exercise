package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    PotluckRepository repository;

    @Override
    public void run(String... strings) throws Exception{
        Potluck potluck;
        potluck = new Potluck();
        potluck.setDescription("sdfgsdfgsdfgsdgfs");
        potluck.setName("spongebob");
        potluck.setPerson("victor");
        potluck.setDish("dishname");
        repository.save(potluck);
    }
}