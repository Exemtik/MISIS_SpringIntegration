package com.example.lab6;

import com.example.lab6.model.StudentMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class Lab6Application implements CommandLineRunner {
    @Autowired
    private MessageChannel outputChannel;

    public static void main(String[] args) {

        SpringApplication.run(Lab6Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            outputChannel.send(MessageBuilder.withPayload(new StudentMessage("Гордеев Глеб Ярославович", LocalDate.of(2003, 9, 14), random.nextInt(100) + 1)).build());
        }
    }
}
