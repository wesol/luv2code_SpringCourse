package com.mw.springdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomFortuneService implements FortuneService {

    private String[] messages = {"You are the best",
            "All girls will be your",
            "You look like Hercules"};

    private Random random = new Random();

    @Override
    public String getFortune() {
        int i = random.nextInt(messages.length);
        return messages[i];
    }
}
